// $FF: renamed from: d
public class BZLib {
    // $FF: renamed from: a (e) byte
    private static byte getUchar(BZState state) {
        return (byte) getBits(8, state);
    }

    // $FF: renamed from: b (e) void
    private static void decompress(BZState state) {
        boolean unusedBool1 = false;
        boolean unusedBool2 = false;
        boolean unusedBool3 = false;
        boolean unusedBool4 = false;
        boolean unusedBool5 = false;
        boolean unusedBool6 = false;
        boolean unusedBool7 = false;
        boolean unusedBool8 = false;
        boolean unusedBool9 = false;
        boolean unusedBool10 = false;
        boolean unusedBool11 = false;
        boolean unusedBool12 = false;
        boolean unusedBool13 = false;
        boolean unusedBool14 = false;
        boolean unusedBool15 = false;
        boolean unusedBool16 = false;
        boolean unusedBool17 = false;
        boolean unusedBool18 = false;
        boolean unusedBool19 = false;
        boolean unusedBool20 = false;
        int gMinLen = 0;
        int[] gLimit = null;
        int[] gBase = null;
        int[] gPerm = null;
        state.blocksize100k = 1;
        if (BZState.tt == null) {
            BZState.tt = new int[state.blocksize100k * 100000];
        }

        boolean stillDecompressing = true;

        while(true) {
            while(stillDecompressing) {
                byte uc = getUchar(state);
                if (uc == 23) {
                    return;
                }

                uc = getUchar(state);
                uc = getUchar(state);
                uc = getUchar(state);
                uc = getUchar(state);
                uc = getUchar(state);
                ++state.blockNo;
                uc = getUchar(state);
                uc = getUchar(state);
                uc = getUchar(state);
                uc = getUchar(state);
                uc = getBit(state);
                if (uc != 0) {
                    state.blockRandomized = true;
                } else {
                    state.blockRandomized = false;
                }

                if (state.blockRandomized) {
                    System.out.println("PANIC! RANDOMISED BLOCK!");
                }

                state.origPtr = 0;
                uc = getUchar(state);
                state.origPtr = state.origPtr << 8 | uc & 255;
                uc = getUchar(state);
                state.origPtr = state.origPtr << 8 | uc & 255;
                uc = getUchar(state);
                state.origPtr = state.origPtr << 8 | uc & 255;

                int i;
                for(i = 0; i < 16; ++i) {
                    uc = getBit(state);
                    if (uc == 1) {
                        state.inUse_16[i] = true;
                    } else {
                        state.inUse_16[i] = false;
                    }
                }

                for(i = 0; i < 256; ++i) {
                    state.inUse[i] = false;
                }

                int j;
                for(i = 0; i < 16; ++i) {
                    if (state.inUse_16[i]) {
                        for(j = 0; j < 16; ++j) {
                            uc = getBit(state);
                            if (uc == 1) {
                                state.inUse[i * 16 + j] = true;
                            }
                        }
                    }
                }

                makeMaps(state);
                int alphaSize = state.nInUse + 2;
                int nGroups = getBits(3, state);
                int nSelectors = getBits(15, state);

                for(i = 0; i < nSelectors; ++i) {
                    j = 0;

                    while(true) {
                        uc = getBit(state);
                        if (uc == 0) {
                            state.selectorMtf[i] = (byte)j;
                            break;
                        }

                        ++j;
                    }
                }

                byte[] pos = new byte[6];

                byte v;
                for(v = 0; v < nGroups; pos[v] = v++) {
                    ;
                }

                for(i = 0; i < nSelectors; ++i) {
                    v = state.selectorMtf[i];

                    byte tmp;
                    for(tmp = pos[v]; v > 0; v += -1) {
                        pos[v] = pos[v - 1];
                    }

                    pos[0] = tmp;
                    state.selector[i] = tmp;
                }

                int t;
                for(t = 0; t < nGroups; ++t) {
                    int curr = getBits(5, state);

                    for(i = 0; i < alphaSize; ++i) {
                        while(true) {
                            uc = getBit(state);
                            if (uc == 0) {
                                state.len[t][i] = (byte)curr;
                                break;
                            }

                            uc = getBit(state);
                            if (uc == 0) {
                                ++curr;
                            } else {
                                --curr;
                            }
                        }
                    }
                }

                for(t = 0; t < nGroups; ++t) {
                    byte minLen = 32;
                    byte maxLen = 0;

                    for(i = 0; i < alphaSize; ++i) {
                        if (state.len[t][i] > maxLen) {
                            maxLen = state.len[t][i];
                        }

                        if (state.len[t][i] < minLen) {
                            minLen = state.len[t][i];
                        }
                    }

                    createDecodeTables(state.limit[t], state.base[t], state.perm[t], state.len[t], minLen, maxLen, alphaSize);
                    state.minLens[t] = minLen;
                }

                int eob = state.nInUse + 1;
                int nblockMax = 100000 * state.blocksize100k;
                int groupNo = -1;
                byte groupPos = 0;

                for(i = 0; i <= 255; ++i) {
                    state.unzftab[i] = 0;
                }

                int kk = 4095; // "MTFASIZE-1;"

                int ii;
                int jj;
                for(ii = 15; ii >= 0; --ii) {
                    for(jj = 15; jj >= 0; --jj) {
                        state.mtfa[kk] = (byte)(ii * 16 + jj);
                        --kk;
                    }

                    state.mtfbase[ii] = kk + 1;
                }

                int nblock = 0;
                byte gsel;
                // "GETMTFVAL"
                if (groupPos == 0) {
                    ++groupNo;
                    groupPos = 50; // "BZGSIZE"
                    gsel = state.selector[groupNo];
                    gMinLen = state.minLens[gsel];
                    gLimit = state.limit[gsel];
                    gPerm = state.perm[gsel];
                    gBase = state.base[gsel];
                }

                int groupPos_ = groupPos - 1;
                int zn_2 = gMinLen;

                int zvec_2;
                byte zj_2;
                for(zvec_2 = getBits(gMinLen, state); zvec_2 > gLimit[zn_2]; zvec_2 = zvec_2 << 1 | zj_2) {
                    ++zn_2;
                    zj_2 = getBit(state);
                }

                int nextSym = gPerm[zvec_2 - gBase[zn_2]];

                while(true) {
                    while(nextSym != eob) {
                        if (nextSym != 0 && nextSym != 1) { // "BZRUNA, BZRUNB"
                            int es = nextSym - 1;
                            int pp;
                            if (es < 16) { // "MTFLSIZE"
                                pp = state.mtfbase[0];

                                for(uc = state.mtfa[pp + es]; es > 3; es -= 4) {
                                    int z = pp + es;
                                    state.mtfa[z] = state.mtfa[z - 1];
                                    state.mtfa[z - 1] = state.mtfa[z - 2];
                                    state.mtfa[z - 2] = state.mtfa[z - 3];
                                    state.mtfa[z - 3] = state.mtfa[z - 4];
                                }

                                while(es > 0) {
                                    state.mtfa[pp + es] = state.mtfa[pp + es - 1];
                                    --es;
                                }

                                state.mtfa[pp] = uc;
                            } else {
                                int lno = es / 16;
                                int off = es % 16;
                                pp = state.mtfbase[lno] + off;

                                for(uc = state.mtfa[pp]; pp > state.mtfbase[lno]; --pp) {
                                    state.mtfa[pp] = state.mtfa[pp - 1];
                                }

                                ++state.mtfbase[lno];

                                while(lno > 0) {
                                    state.mtfbase[lno] += -1;
                                    state.mtfa[state.mtfbase[lno]] = state.mtfa[state.mtfbase[lno - 1] + 16 - 1];
                                    --lno;
                                }

                                state.mtfbase[0] += -1;
                                state.mtfa[state.mtfbase[0]] = uc;
                                if (state.mtfbase[0] == 0) {
                                    kk = 4095; // "MTFASIZE - 1"

                                    for(ii = 15; ii >= 0; --ii) {
                                        for(jj = 15; jj >= 0; --jj) {
                                            state.mtfa[kk] = state.mtfa[state.mtfbase[ii] + jj];
                                            --kk;
                                        }

                                        state.mtfbase[ii] = kk + 1;
                                    }
                                }
                            }

                            ++state.unzftab[state.setToUnseq[uc & 255] & 255];
                            BZState.tt[nblock] = state.setToUnseq[uc & 255] & 255;
                            ++nblock;
                            // "GETMTFVAL"
                            if (groupPos_ == 0) {
                                ++groupNo;
                                groupPos_ = 50;
                                gsel = state.selector[groupNo];
                                gMinLen = state.minLens[gsel];
                                gLimit = state.limit[gsel];
                                gPerm = state.perm[gsel];
                                gBase = state.base[gsel];
                            }

                            --groupPos_;
                            zn_2 = gMinLen;

                            for(zvec_2 = getBits(gMinLen, state); zvec_2 > gLimit[zn_2]; zvec_2 = zvec_2 << 1 | zj_2) {
                                ++zn_2;
                                zj_2 = getBit(state);
                            }

                            nextSym = gPerm[zvec_2 - gBase[zn_2]];
                        } else {
                            int es = -1;
                            int N = 1;

                            do {
                                if (nextSym == 0) {
                                    es += 1 * N;
                                } else if (nextSym == 1) {
                                    es += 2 * N;
                                }

                                N *= 2;
                                if (groupPos_ == 0) {
                                    ++groupNo;
                                    groupPos_ = 50;
                                    gsel = state.selector[groupNo];
                                    gMinLen = state.minLens[gsel];
                                    gLimit = state.limit[gsel];
                                    gPerm = state.perm[gsel];
                                    gBase = state.base[gsel];
                                }

                                --groupPos_;
                                zn_2 = gMinLen;

                                for(zvec_2 = getBits(gMinLen, state); zvec_2 > gLimit[zn_2]; zvec_2 = zvec_2 << 1 | zj_2) {
                                    ++zn_2;
                                    zj_2 = getBit(state);
                                }

                                nextSym = gPerm[zvec_2 - gBase[zn_2]];
                            } while(nextSym == 0 || nextSym == 1);

                            ++es;
                            uc = state.setToUnseq[state.mtfa[state.mtfbase[0]] & 255];

                            for(state.unzftab[uc & 255] += es; es > 0; --es) {
                                BZState.tt[nblock] = uc & 255;
                                ++nblock;
                            }
                        }
                    }

                    state.stateOutLen = 0;
                    state.stateOutCh = 0;
                    state.cftab[0] = 0;

                    for(i = 1; i <= 256; ++i) {
                        state.cftab[i] = state.unzftab[i - 1];
                    }

                    for(i = 1; i <= 256; ++i) {
                        state.cftab[i] += state.cftab[i - 1];
                    }

                    for(i = 0; i < nblock; ++i) {
                        uc = (byte)(BZState.tt[i] & 255);
                        BZState.tt[state.cftab[uc & 255]] |= i << 8;
                        ++state.cftab[uc & 255];
                    }

                    state.tpos = BZState.tt[state.origPtr] >> 8;
                    state.nblockUsed = 0;
                    state.tpos = BZState.tt[state.tpos];
                    state.k0 = (byte)(state.tpos & 255);
                    state.tpos >>= 8;
                    ++state.nblockUsed;
                    state.saveNblock = nblock;
                    nextHeader(state);
                    if (state.nblockUsed == state.saveNblock + 1 && state.stateOutLen == 0) {
                        stillDecompressing = true;
                        break;
                    }

                    stillDecompressing = false;
                    break;
                }
            }

            return;
        }
    }

    // $FF: renamed from: c (e) void
    private static void nextHeader(BZState state) {
        byte cStateOutCh = state.stateOutCh;
        int cStateOutLen = state.stateOutLen;
        int cNblockUsed = state.nblockUsed;
        int cK0 = state.k0;
        int[] cTt = BZState.tt;
        int cTpos = state.tpos;
        byte[] output = state.output;
        int csNextOut = state.availOut;
        int csAvailOut = state.decompressedSize;
        int sSaveNblockPP = state.saveNblock + 1;

        returnNotr:
        while(true) {
            if (cStateOutLen > 0) {
                while(true) {
                    if (csAvailOut == 0) {
                        break returnNotr;
                    }

                    if (cStateOutLen == 1) {
                        if (csAvailOut == 0) {
                            cStateOutLen = 1;
                            break returnNotr;
                        }

                        output[csNextOut] = cStateOutCh;
                        ++csNextOut;
                        --csAvailOut;
                        break;
                    }

                    output[csNextOut] = cStateOutCh;
                    --cStateOutLen;
                    ++csNextOut;
                    --csAvailOut;
                }
            }

            boolean flag = true;

            byte k1;
            while(flag) {
                flag = false;
                if (cNblockUsed == sSaveNblockPP) {
                    cStateOutLen = 0;
                    break returnNotr;
                }

                cStateOutCh = (byte)cK0;
                cTpos = cTt[cTpos];
                k1 = (byte)(cTpos & 255);
                cTpos >>= 8;
                ++cNblockUsed;
                if (k1 != cK0) {
                    cK0 = k1;
                    if (csAvailOut == 0) {
                        cStateOutLen = 1;
                        break returnNotr;
                    }

                    output[csNextOut] = cStateOutCh;
                    ++csNextOut;
                    --csAvailOut;
                    flag = true;
                } else if (cNblockUsed == sSaveNblockPP) {
                    if (csAvailOut == 0) {
                        cStateOutLen = 1;
                        break returnNotr;
                    }

                    output[csNextOut] = cStateOutCh;
                    ++csNextOut;
                    --csAvailOut;
                    flag = true;
                }
            }

            cStateOutLen = 2;
            cTpos = cTt[cTpos];
            k1 = (byte)(cTpos & 255);
            cTpos >>= 8;
            ++cNblockUsed;
            if (cNblockUsed != sSaveNblockPP) {
                if (k1 != cK0) {
                    cK0 = k1;
                } else {
                    cStateOutLen = 3;
                    cTpos = cTt[cTpos];
                    k1 = (byte)(cTpos & 255);
                    cTpos >>= 8;
                    ++cNblockUsed;
                    if (cNblockUsed != sSaveNblockPP) {
                        if (k1 != cK0) {
                            cK0 = k1;
                        } else {
                            cTpos = cTt[cTpos];
                            k1 = (byte)(cTpos & 255);
                            cTpos >>= 8;
                            ++cNblockUsed;
                            cStateOutLen = (k1 & 255) + 4;
                            cTpos = cTt[cTpos];
                            cK0 = (byte)(cTpos & 255);
                            cTpos >>= 8;
                            ++cNblockUsed;
                        }
                    }
                }
            }
        }

        int i = state.totalOutLo32;
        state.totalOutLo32 += csAvailOut - csAvailOut;
        if (state.totalOutLo32 < i) {
            ++state.totalOutHi32;
        }

        state.stateOutCh = cStateOutCh;
        state.stateOutLen = cStateOutLen;
        state.nblockUsed = cNblockUsed;
        state.k0 = cK0;
        BZState.tt = cTt;
        state.tpos = cTpos;
        state.output = output;
        state.availOut = csNextOut;
        state.decompressedSize = csAvailOut;
    }

    // $FF: renamed from: d (e) void
    private static void makeMaps(BZState state) {
        state.nInUse = 0;

        for(int i = 0; i < 256; ++i) {
            if (state.inUse[i]) {
                state.setToUnseq[state.nInUse] = (byte)i;
                ++state.nInUse;
            }
        }

    }

    // $FF: renamed from: e (e) byte
    private static byte getBit(BZState state) {
        return (byte) getBits(1, state);
    }

    // $FF: renamed from: a (int[], int[], int[], byte[], int, int, int) void
    private static void createDecodeTables(int[] limit, int[] base, int[] perm, byte[] length, int minLength, int maxLength, int alphaSize) {
        int pp = 0;

        int i;
        for(i = minLength; i <= maxLength; ++i) {
            for(int j = 0; j < alphaSize; ++j) {
                if (length[j] == i) {
                    perm[pp] = j;
                    ++pp;
                }
            }
        }

        for(i = 0; i < 23; ++i) {
            base[i] = 0;
        }

        for(i = 0; i < alphaSize; ++i) {
            ++base[length[i] + 1];
        }

        for(i = 1; i < 23; ++i) {
            base[i] += base[i - 1];
        }

        for(i = 0; i < 23; ++i) {
            limit[i] = 0;
        }

        int vec = 0;

        for(i = minLength; i <= maxLength; ++i) {
            vec += base[i + 1] - base[i];
            limit[i] = vec - 1;
            vec <<= 1;
        }

        for(i = minLength + 1; i <= maxLength; ++i) {
            base[i] = (limit[i - 1] + 1 << 1) - base[i];
        }

    }

    // $FF: renamed from: a (byte[], int, byte[], int, int) int
    public static int readFileData(byte[] output, int decompressedSize, byte[] input, int dataLength, int start) {
        BZState bz = new BZState();
        bz.input = input;
        bz.nextIn = start;
        bz.output = output;
        bz.availOut = 0;
        bz.availIn = dataLength;
        bz.decompressedSize = decompressedSize;
        bz.bsLive = 0;
        bz.bsBuff = 0;
        bz.totalInLo32 = 0;
        bz.totalInHi32 = 0;
        bz.totalOutLo32 = 0;
        bz.totalOutHi32 = 0;
        bz.blockNo = 0;
        decompress(bz);
        decompressedSize -= bz.decompressedSize;
        return decompressedSize;
    }

    // $FF: renamed from: a (int, e) int
    private static int getBits(int i, BZState state) {
        while(state.bsLive < i) {
            state.bsBuff = state.bsBuff << 8 | state.input[state.nextIn] & 255;
            state.bsLive += 8;
            ++state.nextIn;
            state.availIn += -1;
            ++state.totalInLo32;
            if (state.totalInLo32 == 0) {
                ++state.totalInHi32;
            }
        }

        int vvv = state.bsBuff >> state.bsLive - i & (1 << i) - 1;
        state.bsLive -= i;
        return vvv;
    }
}
