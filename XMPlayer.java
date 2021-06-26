import java.io.InputStream;
import sun.audio.AudioPlayer;

// $FF: renamed from: c
public class XMPlayer extends InputStream {
    // $FF: renamed from: a byte[]
    private byte[] field_131 = new byte[131072];
    // $FF: renamed from: b byte[]
    private byte[] xmFileData;
    // $FF: renamed from: c int[]
    private int[] field_133 = new int[128];
    // $FF: renamed from: d int[]
    private int[] field_134 = new int[]{0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
    // $FF: renamed from: e int
    private int field_135 = 0;
    // $FF: renamed from: f int
    private int field_136 = 0;
    // $FF: renamed from: g int
    private int field_137 = 0;
    // $FF: renamed from: h int
    private int field_138;
    // $FF: renamed from: i int
    private int field_139;
    // $FF: renamed from: j int
    private int field_140;
    // $FF: renamed from: k int
    private int field_141;
    // $FF: renamed from: l int
    private int field_142;
    // $FF: renamed from: m int
    private int field_143;
    // $FF: renamed from: n int
    private int field_144;
    // $FF: renamed from: o int
    private int field_145 = 0;
    // $FF: renamed from: p int
    private int field_146;
    // $FF: renamed from: q int
    private int field_147;
    // $FF: renamed from: r int
    private int field_148;
    // $FF: renamed from: s int
    private int field_149;
    // $FF: renamed from: t int
    private int field_150;
    // $FF: renamed from: u int
    private int field_151;
    // $FF: renamed from: v int
    private int field_152;
    // $FF: renamed from: w int
    private int field_153;
    // $FF: renamed from: x int
    private int field_154;
    // $FF: renamed from: y int
    private int field_155;
    // $FF: renamed from: z int
    private int field_156;
    // $FF: renamed from: A int
    private int field_157;
    // $FF: renamed from: B int
    private int field_158;
    // $FF: renamed from: C int
    private int field_159 = 0;
    // $FF: renamed from: D int
    private int field_160 = 0;
    // $FF: renamed from: E int[]
    private int[] field_161 = new int[256];
    // $FF: renamed from: F int[]
    private int[] field_162 = new int[256];
    // $FF: renamed from: G int[]
    private int[] field_163 = new int[256];
    // $FF: renamed from: H int[]
    private int[] field_164 = new int[256];
    // $FF: renamed from: I int[]
    private int[] field_165 = new int[256];
    // $FF: renamed from: J int[]
    private int[] field_166 = new int[256];
    // $FF: renamed from: K byte[]
    private byte[] field_167 = new byte[256];
    // $FF: renamed from: L byte[]
    private byte[] field_168 = new byte[256];
    // $FF: renamed from: M int[]
    private int[] field_169 = new int[8000];
    // $FF: renamed from: N int[]
    private int[] field_170 = new int[68];
    // $FF: renamed from: O int[]
    private int[] field_171 = new int[64];
    // $FF: renamed from: P int[]
    private int[] field_172 = new int[64];
    // $FF: renamed from: Q int[]
    private int[] field_173 = new int[64];
    // $FF: renamed from: R int[]
    private int[] field_174 = new int[64];
    // $FF: renamed from: S int[]
    private int[] field_175 = new int[256];
    // $FF: renamed from: T int[]
    private int[] field_176 = new int[256];
    // $FF: renamed from: U int
    private int field_177;
    // $FF: renamed from: V int[]
    private int[] field_178 = new int[64];
    // $FF: renamed from: W int[]
    private int[] field_179 = new int[64];
    // $FF: renamed from: X int[]
    private int[] field_180 = new int[64];
    // $FF: renamed from: Y int[]
    private int[] field_181 = new int[64];
    // $FF: renamed from: Z int[]
    private int[] field_182 = new int[64];
    // $FF: renamed from: ab int[]
    private int[] field_183 = new int[64];
    // $FF: renamed from: bb int[]
    private int[] field_184 = new int[64];
    // $FF: renamed from: cb int[]
    private int[] field_185 = new int[64];
    // $FF: renamed from: db int[]
    private int[] field_186 = new int[64];
    // $FF: renamed from: eb int[]
    private int[] field_187 = new int[64];
    // $FF: renamed from: fb int[]
    private int[] field_188 = new int[64];
    // $FF: renamed from: gb int[]
    private int[] field_189 = new int[64];
    // $FF: renamed from: hb int[]
    private int[] field_190 = new int[64];
    // $FF: renamed from: ib int[]
    private int[] field_191 = new int[64];
    // $FF: renamed from: jb int[]
    private int[] field_192 = new int[64];
    // $FF: renamed from: kb int[]
    private int[] field_193 = new int[64];
    // $FF: renamed from: lb int[]
    private int[] field_194 = new int[64];
    // $FF: renamed from: mb int[]
    private int[] field_195 = new int[64];
    // $FF: renamed from: nb int[]
    private int[] field_196 = new int[64];
    // $FF: renamed from: ob int[]
    private int[] field_197 = new int[64];
    // $FF: renamed from: pb int[]
    private int[] field_198 = new int[64];
    // $FF: renamed from: qb int[]
    private int[] field_199 = new int[256];
    // $FF: renamed from: rb int[]
    private int[] field_200 = new int[256];
    // $FF: renamed from: sb int[]
    private int[] field_201 = new int[256];
    // $FF: renamed from: tb int[]
    private int[] field_202 = new int[256];
    // $FF: renamed from: ub int[][]
    private int[][] field_203 = new int[256][12];
    // $FF: renamed from: vb int[][]
    private int[][] field_204 = new int[256][12];
    // $FF: renamed from: wb int[]
    private int[] field_205 = new int[256];
    // $FF: renamed from: xb int[]
    private int[] field_206 = new int[256];
    // $FF: renamed from: yb boolean[]
    private boolean[] field_207 = new boolean[64];
    // $FF: renamed from: zb byte[][]
    private byte[][] field_208 = new byte[256][96];
    // $FF: renamed from: Ab int[]
    private int[] field_209 = new int[32];
    // $FF: renamed from: Bb int[]
    private int[] field_210 = new int[32];
    // $FF: renamed from: Cb int[]
    private int[] field_211 = new int[32];
    // $FF: renamed from: Db int[]
    private int[] field_212 = new int[32];
    // $FF: renamed from: Eb int[]
    private int[] field_213 = new int[32];
    // $FF: renamed from: Fb int
    private int field_214 = 1;
    // $FF: renamed from: Gb int
    private int field_215 = 0;
    // $FF: renamed from: Hb int
    private int field_216 = 0;
    // $FF: renamed from: Ib int
    private int field_217 = -1;
    // $FF: renamed from: Jb int
    private int field_218 = 0;
    // $FF: renamed from: Kb int
    private int field_219 = 0;
    // $FF: renamed from: Lb int
    private int field_220 = 64;

    // $FF: renamed from: a (int) void
    private void method_34(int var1) {
        boolean var2 = false;
        byte var7 = 0;
        if (this.field_145 != 1 && this.field_145 != 2) {
            this.field_135 = 0;
            this.field_137 = 0;
            this.field_136 = 0;
        } else {
            this.field_135 += var1 * this.field_144;
            if (this.field_136 == 0 && this.field_135 >= 20000) {
                if (this.field_145 == 1) {
                    this.field_145 = 2;
                    this.field_148 = 0;
                    this.field_147 = 0;
                    this.field_149 = this.field_165[this.field_148];
                    this.field_177 = this.field_175[this.field_149];
                    this.field_146 = 0;
                }

                if (this.field_147 >= this.field_161[this.field_149] || this.field_218 == 1 || this.field_215 == 1) {
                    if (this.field_215 == 1) {
                        this.field_148 = this.field_216;
                        this.field_159 = 1;
                    } else {
                        ++this.field_148;
                    }

                    if (this.field_217 != -1) {
                        this.field_148 = this.field_217;
                        this.field_217 = -1;
                    }

                    if (this.field_148 >= this.field_138) {
                        this.field_148 = 0;
                        this.field_159 = 1;
                    }

                    this.field_147 = 0;
                    this.field_149 = this.field_165[this.field_148];
                    this.field_177 = this.field_175[this.field_149];
                    this.field_146 = 0;
                    if (this.field_219 > 0) {
                        this.field_218 = 1;
                        this.field_216 = this.field_219;
                        this.field_219 = 0;
                    }

                    if (this.field_218 == 1) {
                        this.field_216 = this.field_216 / 16 * 10 + this.field_216 % 16;
                        if (this.field_216 >= this.field_161[this.field_149]) {
                            this.field_216 = 0;
                        }

                        this.field_147 = this.field_216;

                        for(int var15 = 0; var15 < this.field_216; ++var15) {
                            for(this.field_156 = 0; this.field_156 < this.field_139; ++this.field_156) {
                                this.field_150 = this.xmFileData[this.field_177 + this.field_146] & 255;
                                ++this.field_146;
                                if (this.field_150 < 128) {
                                    this.field_146 += -1;
                                    this.field_150 = 31;
                                } else {
                                    this.field_150 -= 128;
                                }

                                if ((this.field_150 & 1) == 1) {
                                    this.field_151 = this.xmFileData[this.field_177 + this.field_146] & 255;
                                    ++this.field_146;
                                }

                                if ((this.field_150 & 2) == 2) {
                                    this.field_152 = (this.xmFileData[this.field_177 + this.field_146] & 255) - 1;
                                    ++this.field_146;
                                }

                                if ((this.field_150 & 4) == 4) {
                                    this.field_153 = (this.xmFileData[this.field_177 + this.field_146] & 255) - 16;
                                    ++this.field_146;
                                }

                                if ((this.field_150 & 8) == 8) {
                                    this.field_154 = this.xmFileData[this.field_177 + this.field_146] & 255;
                                    ++this.field_146;
                                }

                                if ((this.field_150 & 16) == 16) {
                                    this.field_155 = this.xmFileData[this.field_177 + this.field_146] & 255;
                                    ++this.field_146;
                                }
                            }
                        }
                    }

                    this.field_217 = -1;
                    this.field_218 = 0;
                    this.field_215 = 0;
                }

                ++this.field_147;

                for(this.field_156 = 0; this.field_156 < this.field_139; ++this.field_156) {
                    this.field_151 = -1;
                    this.field_152 = -1;
                    this.field_153 = -1;
                    this.field_154 = -1;
                    this.field_155 = 0;
                    this.field_150 = this.xmFileData[this.field_177 + this.field_146] & 255;
                    ++this.field_146;
                    if (this.field_150 < 128) {
                        this.field_146 += -1;
                        this.field_150 = 31;
                    } else {
                        this.field_150 -= 128;
                    }

                    if ((this.field_150 & 1) == 1) {
                        this.field_151 = this.xmFileData[this.field_177 + this.field_146] & 255;
                        ++this.field_146;
                    }

                    if ((this.field_150 & 2) == 2) {
                        this.field_152 = (this.xmFileData[this.field_177 + this.field_146] & 255) - 1;
                        ++this.field_146;
                    }

                    if ((this.field_150 & 4) == 4) {
                        this.field_153 = (this.xmFileData[this.field_177 + this.field_146] & 255) - 16;
                        ++this.field_146;
                    }

                    if ((this.field_150 & 8) == 8) {
                        this.field_154 = this.xmFileData[this.field_177 + this.field_146] & 255;
                        ++this.field_146;
                    }

                    if ((this.field_150 & 16) == 16) {
                        this.field_155 = this.xmFileData[this.field_177 + this.field_146] & 255;
                        ++this.field_146;
                    }

                    if (!this.field_207[this.field_156]) {
                        if (this.field_153 >= 80 && this.field_153 < 96) {
                            this.field_198[this.field_156] = 2;
                            this.field_178[this.field_156] = 80 - this.field_153;
                            this.field_153 = -1;
                        }

                        if (this.field_153 >= 96 && this.field_153 < 112) {
                            this.field_198[this.field_156] = 2;
                            this.field_178[this.field_156] = this.field_153 - 96;
                            this.field_153 = -1;
                        }

                        if (this.field_153 >= 112 && this.field_153 < 128) {
                            this.field_153 = this.field_171[this.field_156] - (this.field_153 - 112);
                            if (this.field_153 < 0) {
                                this.field_153 = 0;
                            } else if (this.field_153 > 63) {
                                this.field_153 = 63;
                            }
                        }

                        if (this.field_153 >= 128 && this.field_153 < 136) {
                            this.field_153 = this.field_171[this.field_156] + (this.field_153 - 128);
                            if (this.field_153 < 0) {
                                this.field_153 = 0;
                            } else if (this.field_153 > 63) {
                                this.field_153 = 63;
                            }
                        }

                        if (this.field_153 > 64) {
                            this.field_153 = -1;
                        }

                        if (this.field_154 == 13) {
                            this.field_218 = 1;
                            this.field_216 = this.field_155;
                        }

                        if (this.field_154 == 15) {
                            if (this.field_155 < 32) {
                                this.field_143 = this.field_155;
                            } else {
                                this.field_144 = this.field_155;
                            }
                        }

                        if (this.field_154 == 12) {
                            this.field_153 = this.field_155;
                        }

                        if (this.field_154 == 14) {
                            this.field_154 = this.field_154 * 16 + this.field_155 / 16;
                            this.field_155 &= 15;
                        }

                        if (this.field_154 == 236 && this.field_155 < this.field_143) {
                            this.field_151 = 97;
                        }

                        if (this.field_154 == 11) {
                            this.field_215 = 1;
                            this.field_216 = this.field_155;
                        }

                        if (this.field_154 == 20) {
                            this.field_151 = 97;
                        }

                        if (this.field_154 == 21) {
                            this.field_193[this.field_156] = this.field_155;
                            if (this.field_193[this.field_156] >= this.field_203[var7][this.field_199[var7] - 1]) {
                                this.field_193[this.field_156] = this.field_203[var7][this.field_199[var7] - 1] - 1;
                            }
                        }

                        if (this.field_152 >= 0 && this.field_151 <= 96) {
                            this.field_193[this.field_156] = 0;
                            this.field_195[this.field_156] = 1;
                            this.field_196[this.field_156] = 0;
                        }

                        if (this.field_154 == 3 && this.field_153 < 0 && this.field_152 != -1) {
                            this.field_153 = this.field_163[this.field_173[this.field_156]];
                        }

                        if (this.field_151 >= 0 && this.field_151 <= 96 && this.field_154 != 3) {
                            if (this.field_152 == -1 && this.field_153 < 0) {
                                this.field_153 = this.field_171[this.field_156];
                            }

                            if (this.field_152 == -1) {
                                this.field_152 = this.field_173[this.field_156];
                            } else {
                                this.field_174[this.field_156] = this.field_152;
                                if (this.field_151 < 96) {
                                    this.field_152 = this.field_208[this.field_152][this.field_151];
                                } else {
                                    this.field_152 = this.field_208[this.field_152][95];
                                }
                            }

                            if (this.field_153 < 0) {
                                this.field_153 = this.field_163[this.field_152];
                            }

                            this.field_158 = 7680 - (this.field_151 + this.field_167[this.field_152]) * 16 * 4 - this.field_168[this.field_152] / 2;
                            if (this.field_158 < 500) {
                                this.field_158 = 500;
                            } else if (this.field_158 > 7999) {
                                this.field_158 = 7999;
                            }

                            this.field_191[this.field_156] = this.field_158;
                            this.field_157 = this.field_169[this.field_158];
                            this.field_173[this.field_156] = this.field_152;
                            this.field_171[this.field_156] = this.field_153;
                            this.field_172[this.field_156] = this.field_158;
                            int var4 = this.field_176[this.field_152];
                            int var5 = this.field_162[this.field_152];
                            if (this.field_154 == 9) {
                                if (this.field_155 * 256 > this.field_162[this.field_152]) {
                                    var4 += this.field_162[this.field_152];
                                    var5 = 0;
                                } else {
                                    var4 += this.field_155 * 256;
                                    var5 -= this.field_155 * 256;
                                }
                            }

                            this.playSound(this.field_156, var4, this.field_157, this.field_153 * this.field_220 / 64, var5, this.field_164[this.field_152]);
                            this.field_181[this.field_156] = 0;
                        } else if (this.field_151 > 96) {
                            if (this.field_194[this.field_156] == 1) {
                                this.field_195[this.field_156] = 0;
                            } else {
                                this.method_35(this.field_156);
                            }
                        } else if (this.field_153 >= 0) {
                            this.method_46(this.field_156, this.field_153 * this.field_220 / 64);
                            this.field_171[this.field_156] = this.field_153;
                        }

                        if (this.field_154 == 3) {
                            this.field_197[this.field_156] = 1;
                            if (this.field_151 >= 0 && this.field_151 <= 96) {
                                this.field_152 = this.field_173[this.field_156];
                                this.field_158 = 7680 - (this.field_151 + this.field_167[this.field_152]) * 16 * 4 - this.field_168[this.field_152] / 2;
                                if (this.field_158 < 500) {
                                    this.field_158 = 500;
                                } else if (this.field_158 > 7999) {
                                    this.field_158 = 7999;
                                }

                                this.field_191[this.field_156] = this.field_158;
                            }

                            if (this.field_155 != 0) {
                                this.field_192[this.field_156] = this.field_155;
                                if (this.field_142 == 0) {
                                    this.field_192[this.field_156] *= 2;
                                }
                            }
                        } else if (this.field_154 != 5) {
                            this.field_197[this.field_156] = 0;
                        }

                        if (this.field_154 == 4) {
                            this.field_182[this.field_156] = 1;
                            if (this.field_155 / 16 > 0) {
                                this.field_179[this.field_156] = this.field_155 / 16;
                            }

                            if ((this.field_155 & 15) > 0) {
                                this.field_180[this.field_156] = this.field_155 & 15;
                            }
                        } else if (this.field_154 != 6) {
                            if (this.field_182[this.field_156] != 0) {
                                this.field_157 = this.field_169[this.field_172[this.field_156]];
                                this.method_44(this.field_156, this.field_157);
                            }

                            this.field_181[this.field_156] = 0;
                            this.field_182[this.field_156] = 0;
                        }

                        if (this.field_154 != 10 && this.field_154 != 6 && this.field_154 != 5) {
                            if (this.field_198[this.field_156] == 2) {
                                this.field_198[this.field_156] = 1;
                            } else {
                                this.field_198[this.field_156] = 0;
                            }
                        } else {
                            this.field_198[this.field_156] = 1;
                            if (this.field_155 != 0) {
                                this.field_178[this.field_156] = (this.field_155 & 240) / 16 - (this.field_155 & 15);
                            }
                        }

                        if (this.field_154 == 234) {
                            if (this.field_155 == 0) {
                                this.field_155 = this.field_183[this.field_156];
                            } else {
                                this.field_183[this.field_156] = this.field_155;
                            }

                            this.field_171[this.field_156] += this.field_155;
                            if (this.field_171[this.field_156] < 0) {
                                this.field_171[this.field_156] = 0;
                            } else if (this.field_171[this.field_156] > 63) {
                                this.field_171[this.field_156] = 63;
                            }

                            this.method_46(this.field_156, this.field_171[this.field_156] * this.field_220 / 64);
                        }

                        if (this.field_154 == 235) {
                            if (this.field_155 == 0) {
                                this.field_155 = this.field_186[this.field_156];
                            } else {
                                this.field_186[this.field_156] = this.field_155;
                            }

                            this.field_171[this.field_156] -= this.field_155;
                            if (this.field_171[this.field_156] < 0) {
                                this.field_171[this.field_156] = 0;
                            } else if (this.field_171[this.field_156] > 63) {
                                this.field_171[this.field_156] = 63;
                            }

                            this.method_46(this.field_156, this.field_171[this.field_156] * this.field_220 / 64);
                        }

                        if (this.field_154 == 1) {
                            if (this.field_155 != 0) {
                                this.field_189[this.field_156] = this.field_155;
                            }
                        } else {
                            this.field_189[this.field_156] = 0;
                        }

                        if (this.field_154 == 2) {
                            if (this.field_155 != 0) {
                                this.field_190[this.field_156] = this.field_155;
                            }
                        } else {
                            this.field_190[this.field_156] = 0;
                        }

                        if (this.field_154 == 225) {
                            if (this.field_155 == 0) {
                                this.field_155 = this.field_184[this.field_156];
                            } else {
                                this.field_184[this.field_156] = this.field_155;
                            }

                            this.field_172[this.field_156] -= this.field_155 * 4;
                            if (this.field_172[this.field_156] < 500) {
                                this.field_172[this.field_156] = 500;
                            } else if (this.field_172[this.field_156] > 7999) {
                                this.field_172[this.field_156] = 7999;
                            }

                            this.field_157 = this.field_169[this.field_172[this.field_156]];
                            this.method_44(this.field_156, this.field_157);
                        }

                        if (this.field_154 == 226) {
                            if (this.field_155 == 0) {
                                this.field_155 = this.field_187[this.field_156];
                            } else {
                                this.field_187[this.field_156] = this.field_155;
                            }

                            this.field_172[this.field_156] += this.field_155 * 4;
                            if (this.field_172[this.field_156] < 500) {
                                this.field_172[this.field_156] = 500;
                            } else if (this.field_172[this.field_156] > 7999) {
                                this.field_172[this.field_156] = 7999;
                            }

                            this.field_157 = this.field_169[this.field_172[this.field_156]];
                            this.method_44(this.field_156, this.field_157);
                        }

                        if (this.field_154 == 33) {
                            if (this.field_155 / 16 == 1) {
                                this.field_155 &= 15;
                                if (this.field_155 == 0) {
                                    this.field_155 = this.field_185[this.field_156];
                                } else {
                                    this.field_185[this.field_156] = this.field_155;
                                }

                                this.field_172[this.field_156] -= this.field_155;
                                if (this.field_172[this.field_156] < 500) {
                                    this.field_172[this.field_156] = 500;
                                } else if (this.field_172[this.field_156] > 7999) {
                                    this.field_172[this.field_156] = 7999;
                                }

                                this.field_157 = this.field_169[this.field_172[this.field_156]];
                                this.method_44(this.field_156, this.field_157);
                            } else {
                                this.field_155 &= 15;
                                if (this.field_155 == 0) {
                                    this.field_155 = this.field_188[this.field_156];
                                } else {
                                    this.field_188[this.field_156] = this.field_155;
                                }

                                this.field_172[this.field_156] += this.field_155;
                                if (this.field_172[this.field_156] < 500) {
                                    this.field_172[this.field_156] = 500;
                                } else if (this.field_172[this.field_156] > 7999) {
                                    this.field_172[this.field_156] = 7999;
                                }

                                this.field_157 = this.field_169[this.field_172[this.field_156]];
                                this.method_44(this.field_156, this.field_157);
                            }
                        }
                    }
                }
            }

            if (this.field_136 > 0 && this.field_135 >= 20000) {
                for(this.field_156 = 0; this.field_156 < this.field_139; ++this.field_156) {
                    if (!this.field_207[this.field_156]) {
                        if (this.field_198[this.field_156] != 0) {
                            this.field_171[this.field_156] += this.field_178[this.field_156];
                            if (this.field_171[this.field_156] < 0) {
                                this.field_171[this.field_156] = 0;
                            } else if (this.field_171[this.field_156] > 63) {
                                this.field_171[this.field_156] = 63;
                            }

                            this.method_46(this.field_156, this.field_171[this.field_156] * this.field_220 / 64);
                        }

                        if (this.field_182[this.field_156] == 1) {
                            this.field_181[this.field_156] = (this.field_181[this.field_156] + this.field_179[this.field_156]) % 68;
                            int var6 = this.field_170[this.field_181[this.field_156]] * this.field_180[this.field_156] >> 8;
                            this.field_158 = this.field_172[this.field_156] + var6;
                            this.method_44(this.field_156, this.field_169[this.field_158]);
                        }

                        if (this.field_189[this.field_156] > 0) {
                            this.field_172[this.field_156] -= this.field_189[this.field_156] * 4;
                            if (this.field_172[this.field_156] < 500) {
                                this.field_172[this.field_156] = 500;
                            } else if (this.field_172[this.field_156] > 7999) {
                                this.field_172[this.field_156] = 7999;
                            }

                            this.field_157 = this.field_169[this.field_172[this.field_156]];
                            this.method_44(this.field_156, this.field_157);
                        }

                        if (this.field_190[this.field_156] > 0) {
                            this.field_172[this.field_156] += this.field_190[this.field_156] * 4;
                            if (this.field_172[this.field_156] < 500) {
                                this.field_172[this.field_156] = 500;
                            } else if (this.field_172[this.field_156] > 7999) {
                                this.field_172[this.field_156] = 7999;
                            }

                            this.field_157 = this.field_169[this.field_172[this.field_156]];
                            this.method_44(this.field_156, this.field_157);
                        }

                        if (this.field_197[this.field_156] > 0) {
                            if (this.field_172[this.field_156] < this.field_191[this.field_156]) {
                                this.field_172[this.field_156] += this.field_192[this.field_156] * 4;
                                if (this.field_172[this.field_156] > this.field_191[this.field_156]) {
                                    this.field_172[this.field_156] = this.field_191[this.field_156];
                                }
                            }

                            if (this.field_172[this.field_156] > this.field_191[this.field_156]) {
                                this.field_172[this.field_156] -= this.field_192[this.field_156] * 4;
                                if (this.field_172[this.field_156] < this.field_191[this.field_156]) {
                                    this.field_172[this.field_156] = this.field_191[this.field_156];
                                }
                            }

                            if (this.field_172[this.field_156] < 500) {
                                this.field_172[this.field_156] = 500;
                            } else if (this.field_172[this.field_156] > 7999) {
                                this.field_172[this.field_156] = 7999;
                            }

                            this.field_157 = this.field_169[this.field_172[this.field_156]];
                            this.method_44(this.field_156, this.field_157);
                        }
                    }
                }
            }

            this.field_137 += 50;
            if (this.field_137 >= 64 || this.field_135 >= 20000) {
                this.field_137 %= 64;

                for(this.field_156 = 0; this.field_156 < this.field_139; ++this.field_156) {
                    if (!this.field_207[this.field_156]) {
                        if (this.field_174[this.field_156] >= 0 && (this.field_205[this.field_174[this.field_156]] & 1) == 1) {
                            this.field_194[this.field_156] = 1;
                            int var18 = this.field_174[this.field_156];
                            int var9 = this.field_193[this.field_156];

                            int var10;
                            for(var10 = 0; this.field_203[var18][var10 + 1] < var9; ++var10) {
                                ;
                            }

                            int var11 = this.field_203[var18][var10];
                            int var13 = this.field_203[var18][var10 + 1];
                            int var12 = this.field_204[var18][var10];
                            int var14 = this.field_204[var18][var10 + 1];
                            if (var13 == var11) {
                                ++var13;
                            }

                            int var16 = ((var13 - var9) * var12 + (var9 - var11) * var14) / (var13 - var11);
                            int var17 = 64 - this.field_196[this.field_156] / 500;
                            if (var17 < 0) {
                                var17 = 0;
                            }

                            this.field_153 = this.field_171[this.field_156] * var16 * var17 / 4096;
                            this.method_46(this.field_156, this.field_153 * this.field_220 / 64);
                            if ((this.field_205[var18] & 2) == 2 && this.field_195[this.field_156] == 1 && this.field_193[this.field_156] == this.field_203[var18][this.field_200[var18]]) {
                                this.field_193[this.field_156] += -1;
                            }

                            if (this.field_193[this.field_156] == this.field_203[var18][this.field_199[var18] - 1]) {
                                this.field_193[this.field_156] += -1;
                            }

                            if (this.field_195[this.field_156] == 0) {
                                this.field_196[this.field_156] += this.field_206[var18];
                            }

                            ++this.field_193[this.field_156];
                            if ((this.field_205[var18] & 4) == 4 && this.field_193[this.field_156] == this.field_203[var18][this.field_202[var18]]) {
                                this.field_193[this.field_156] = this.field_203[var18][this.field_201[var18]];
                            }
                        } else {
                            this.field_194[this.field_156] = 0;
                        }
                    }
                }
            }

            if (this.field_135 >= 20000) {
                this.field_135 -= 20000;
                ++this.field_136;
                if (this.field_136 >= this.field_143) {
                    this.field_136 = 0;
                }
            }

            if (this.field_135 >= 20000) {
                this.method_34(0);
            }

        }
    }

    // $FF: renamed from: b (int) void
    public void method_35(int isPlayingSound) {
        this.field_211[isPlayingSound] = 0;
    }

    public XMPlayer(byte[] xmFileData) {
        ++xmFileData[0];
        this.xmFileData = xmFileData;
        this.loadXmFileData(xmFileData);

        int var2;
        for(var2 = -32768; var2 < 32767; ++var2) {
            this.field_131[var2 + 65536] = this.method_41(var2);
        }

        for(var2 = 0; var2 < 32768; ++var2) {
            this.field_131[var2] = this.field_131[32768];
        }

        for(var2 = 98304; var2 < 131072; ++var2) {
            this.field_131[var2] = this.field_131[98303];
        }

        for(var2 = 0; var2 < 32; ++var2) {
            this.field_209[var2] = 0;
            this.field_210[var2] = 0;
            this.field_211[var2] = 0;
            this.field_212[var2] = 0;
            this.field_213[var2] = 10;
            this.field_207[var2] = false;
        }

        this.field_145 = 1;
        this.field_159 = 0;
    }

    // $FF: renamed from: a (int, int, int, int) void
    public void playSound(int isPlayingSound, int soundId, int var3, int var4) {
        this.playSound(isPlayingSound, this.field_176[soundId], var3, var4, this.field_162[soundId], this.field_164[soundId]);
    }

    public int read(byte[] var1, int var2, int var3) {
        if (var3 > 128) {
            this.read(var1, var2, 128);
            this.read(var1, var2 + 128, var3 - 128);
            return var3;
        } else {
            this.method_43(this.xmFileData, 0, 0, 0, this.field_133, var3);
            this.method_40(this.field_131, this.field_133, var1, 0, var2, var3);
            this.method_34(var3);
            return var3;
        }
    }

    public int read() {
        byte[] var1 = new byte[1];
        this.read(var1, 0, 1);
        return var1[0];
    }

    // $FF: renamed from: a (byte[], int) int
    private int method_37(byte[] var1, int var2) {
        return (var1[var2] & 255) + (var1[var2 + 1] & 255) * 256 + (var1[var2 + 2] & 255) * 65536 + (var1[var2 + 3] & 255) * 65536 * 256;
    }

    // $FF: renamed from: a () void
    public void init() {
        AudioPlayer.player.start(this);
    }

    // $FF: renamed from: a (int, int, int, int, int, int) void
    private void playSound(int isPlayingSound, int var2, int var3, int var4, int var5, int var6) {
        if (var3 > 0 && var3 <= 340000) {
            if (var4 < 0) {
                var4 = 0;
            } else if (var4 > 63) {
                var4 = 63;
            }

            this.field_209[isPlayingSound] = var2 << 8;
            this.field_213[isPlayingSound] = var2 + var5 << 8;
            this.field_212[isPlayingSound] = var6 << 8;
            this.field_210[isPlayingSound] = var4;
            this.field_211[isPlayingSound] = var3 * 256 / 8000;
        } else {
            this.method_35(isPlayingSound);
        }
    }

    // $FF: renamed from: a (byte[], int[], byte[], int, int, int) void
    private void method_40(byte[] var1, int[] var2, byte[] var3, int var4, int var5, int var6) {
        for(var4 = 0; var4 < var6; ++var4) {
            var3[var5++] = var1[(var2[var4] >> 8) + 65536];
        }

    }

    // $FF: renamed from: c (int) byte
    private byte method_41(int var1) {
        int var2 = var1 >> 8 & 128;
        if (var2 != 0) {
            var1 = -var1;
        }

        if (var1 > 32635) {
            var1 = 32635;
        }

        var1 += 132;
        int var3 = this.field_134[var1 >> 7 & 255];
        int var4 = var1 >> var3 + 3 & 15;
        byte var5 = (byte)(~(var2 | var3 << 4 | var4));
        return var5;
    }

    // $FF: renamed from: b (byte[], int) int
    private int method_42(byte[] var1, int var2) {
        return (var1[var2] & 255) + (var1[var2 + 1] & 255) * 256;
    }

    // $FF: renamed from: a (byte[], int, int, int, int[], int) void
    private void method_43(byte[] var1, int var2, int var3, int var4, int[] var5, int var6) {
        int var7 = this.field_209[0];
        int var8 = this.field_211[0];
        int var9 = this.field_213[0];
        int var10 = this.field_212[0];
        int var11 = this.field_210[0] * this.field_214;

        for(var4 = 0; var4 < var6; ++var4) {
            var2 = var7 & 255;
            var3 = var7 >> 8;
            var5[var4] = (var1[var3] * (256 - var2) + var1[var3 + 1] * var2) * var11;
            if ((var7 += var8) >= var9) {
                if (var10 == 0) {
                    var8 = 0;
                    this.field_211[0] = 0;
                    var7 = var9 - 1;
                } else {
                    var7 = (var7 - var9) % var10 + var9 - var10;
                }
            }
        }

        this.field_209[0] = var7;

        for(int var12 = 1; var12 < this.field_139; ++var12) {
            var7 = this.field_209[var12];
            var8 = this.field_211[var12];
            var9 = this.field_213[var12];
            var10 = this.field_212[var12];
            var11 = this.field_210[var12] * this.field_214;

            for(var4 = 0; var4 < var6; ++var4) {
                var2 = var7 & 255;
                var3 = var7 >> 8;
                var5[var4] += (var1[var3] * (256 - var2) + var1[var3 + 1] * var2) * var11;
                if ((var7 += var8) >= var9) {
                    if (var10 == 0) {
                        var8 = 0;
                        this.field_211[var12] = 0;
                        var7 = var9 - 1;
                    } else {
                        var7 = (var7 - var9) % var10 + var9 - var10;
                    }
                }
            }

            this.field_209[var12] = var7;
        }

    }

    // $FF: renamed from: a (int, int) void
    public void method_44(int var1, int var2) {
        this.field_211[var1] = var2 * 256 / 8000;
    }

    // $FF: renamed from: a (byte[]) void
    private void loadXmFileData(byte[] var1) {
        int var4;
        for(var4 = 0; var4 < 8000; ++var4) {
            this.field_169[var4] = (int)(8363.0D * Math.pow(2.0D, (double)(4608 - var4) / 768.0D));
        }

        for(var4 = 0; var4 < 68; ++var4) {
            this.field_170[var4] = (int)(-2048.0D * Math.sin((double)var4 * 0.0923998D));
        }

        for(var4 = 0; var4 < 64; ++var4) {
            this.field_183[var4] = 0;
            this.field_184[var4] = 0;
            this.field_185[var4] = 0;
            this.field_186[var4] = 0;
            this.field_187[var4] = 0;
            this.field_188[var4] = 0;
            this.field_178[var4] = 0;
            this.field_179[var4] = 0;
            this.field_180[var4] = 0;
            this.field_181[var4] = 0;
            this.field_182[var4] = 0;
            this.field_189[var4] = 0;
            this.field_190[var4] = 0;
            this.field_191[var4] = 0;
            this.field_192[var4] = 0;
            this.field_173[var4] = 0;
            this.field_171[var4] = 0;
            this.field_172[var4] = 0;
            this.field_193[var4] = 0;
            this.field_174[var4] = -1;
            this.field_194[var4] = 0;
            this.field_195[var4] = 0;
            this.field_196[var4] = 0;
            this.field_197[var4] = 0;
            this.field_198[var4] = 0;
        }

        this.field_138 = this.method_42(var1, 64);
        this.field_139 = this.method_42(var1, 68);
        this.field_140 = this.method_42(var1, 70);
        this.field_141 = this.method_42(var1, 72);
        this.field_142 = this.method_42(var1, 74);
        this.field_143 = this.method_42(var1, 76);
        this.field_144 = this.method_42(var1, 78);

        for(var4 = 0; var4 < this.field_138; ++var4) {
            this.field_165[var4] = this.method_47(var1, var4 + 80);
        }

        int var14 = 60 + this.method_37(var1, 60);
        int var9 = 0;

        for(var4 = 0; var4 < this.field_140; ++var4) {
            this.field_161[var4] = this.method_42(var1, var14 + var9 + 5);
            this.field_175[var4] = var14 + var9 + this.method_37(var1, var14 + var9);
            var9 += this.method_37(var1, var14 + var9) + this.method_42(var1, var14 + var9 + 7);
        }

        int var15 = var14 + var9;
        var9 = 0;
        var4 = 0;

        for(int var6 = 0; var6 < this.field_141; ++var6) {
            int var11 = this.method_42(var1, var15 + var9 + 27);

            int var8;
            for(var8 = 0; var8 < 96; ++var8) {
                if (var11 > 0) {
                    this.field_208[var6][var8] = (byte)(var4 + this.method_47(var1, var15 + var9 + 33 + var8));
                } else {
                    this.field_208[var6][var8] = -1;
                }
            }

            this.field_199[var6] = this.method_47(var1, var15 + var9 + 225);
            this.field_200[var6] = this.method_47(var1, var15 + var9 + 227);
            this.field_201[var6] = this.method_47(var1, var15 + var9 + 228);
            this.field_202[var6] = this.method_47(var1, var15 + var9 + 229);
            this.field_205[var6] = this.method_47(var1, var15 + var9 + 233);
            this.field_206[var6] = this.method_42(var1, var15 + var9 + 239);

            for(var8 = 0; var8 < 12; ++var8) {
                this.field_203[var6][var8] = this.method_42(var1, var15 + var9 + 129 + var8 * 4);
                this.field_204[var6][var8] = this.method_42(var1, var15 + var9 + 131 + var8 * 4);
            }

            int var13 = this.method_37(var1, var15 + var9 + 29);
            var9 += this.method_37(var1, var15 + var9);
            int var10 = var9 + var13 * var11;

            for(var8 = 0; var8 < var11; ++var8) {
                int var12 = this.method_47(var1, var15 + var9 + 14);
                if ((var12 & 16) == 16) {
                    this.field_166[var4] = 1;
                } else {
                    this.field_166[var4] = 0;
                }

                if ((var12 & 3) == 0) {
                    this.field_164[var4] = 0;
                    this.field_162[var4] = this.method_37(var1, var15 + var9);
                } else {
                    this.field_162[var4] = this.method_37(var1, var15 + var9 + 4) + this.method_37(var1, var15 + var9 + 8);
                    this.field_164[var4] = this.method_37(var1, var15 + var9 + 8);
                }

                this.field_168[var4] = var1[var15 + var9 + 13];
                this.field_167[var4] = (byte)(var1[var15 + var9 + 16] - 1);
                this.field_163[var4] = this.method_47(var1, var15 + var9 + 12);
                this.field_176[var4] = var15 + var10;
                if (this.field_166[var4] == 1) {
                    this.field_162[var4] /= 2;
                    this.field_164[var4] /= 2;
                }

                var10 += this.method_37(var1, var15 + var9);
                var9 += var13;
                ++var4;
            }

            var4 -= var11;

            for(var8 = 0; var8 < var11; ++var8) {
                int var3 = 0;

                for(int var7 = 0; var7 < this.field_162[var4]; ++var7) {
                    int var2;
                    if (this.field_166[var4] == 0) {
                        var2 = var1[this.field_176[var4] + var7] + var3;
                        var1[this.field_176[var4] + var7] = (byte)((byte)var2 / 2);
                    } else {
                        var2 = this.method_42(var1, this.field_176[var4] + var7 * 2) + var3;
                        var1[this.field_176[var4] + var7] = (byte)((byte)(var2 / 256) / 2);
                    }

                    var3 = var2;
                }

                ++var4;
                var9 = var10;
            }
        }

    }

    // $FF: renamed from: b (int, int) void
    public void method_46(int var1, int var2) {
        if (var2 < 0) {
            var2 = 0;
        } else if (var2 > 63) {
            var2 = 63;
        }

        this.field_210[var1] = var2;
    }

    // $FF: renamed from: c (byte[], int) int
    private int method_47(byte[] var1, int var2) {
        return var1[var2] & 255;
    }
}
