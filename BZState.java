// $FF: renamed from: e
class BZState {
    // $FF: renamed from: a int
    final int unusedInt1 = 4096;
    // $FF: renamed from: b int
    final int unusedInt2 = 16;
    // $FF: renamed from: c int
    final int unusedInt3 = 258;
    // $FF: renamed from: d int
    final int unusedInt4 = 23;
    // $FF: renamed from: e int
    final int unusedInt5 = 0;
    // $FF: renamed from: f int
    final int unusedInt6 = 1;
    // $FF: renamed from: g int
    final int unusedInt7 = 6;
    // $FF: renamed from: h int
    final int unusedInt8 = 50;
    // $FF: renamed from: i int
    final int unusedInt9 = 4;
    // $FF: renamed from: j int
    final int eighteenThousandTwo = 18002;
    // $FF: renamed from: k byte[]
    byte[] input;
    // $FF: renamed from: l int
    int nextIn = 0;
    // $FF: renamed from: m int
    int availIn;
    // $FF: renamed from: n int
    int totalInLo32;
    // $FF: renamed from: o int
    int totalInHi32;
    // $FF: renamed from: p byte[]
    byte[] output;
    // $FF: renamed from: q int
    int availOut = 0;
    // $FF: renamed from: r int
    int decompressedSize;
    // $FF: renamed from: s int
    int totalOutLo32;
    // $FF: renamed from: t int
    int totalOutHi32;
    // $FF: renamed from: u byte
    byte stateOutCh;
    // $FF: renamed from: v int
    int stateOutLen;
    // $FF: renamed from: w boolean
    boolean blockRandomized;
    // $FF: renamed from: x int
    int bsBuff;
    // $FF: renamed from: y int
    int bsLive;
    // $FF: renamed from: z int
    int blocksize100k;
    // $FF: renamed from: A int
    int blockNo;
    // $FF: renamed from: B int
    int origPtr;
    // $FF: renamed from: C int
    int tpos;
    // $FF: renamed from: D int
    int k0;
    // $FF: renamed from: E int[]
    int[] unzftab = new int[256];
    // $FF: renamed from: F int
    int nblockUsed;
    // $FF: renamed from: G int[]
    int[] cftab = new int[257];
    // $FF: renamed from: H int[]
    int[] unusedIntArray = new int[257];
    // $FF: renamed from: I int[]
    public static int[] tt;
    // $FF: renamed from: J int
    int nInUse;
    // $FF: renamed from: K boolean[]
    boolean[] inUse = new boolean[256];
    // $FF: renamed from: L boolean[]
    boolean[] inUse_16 = new boolean[16];
    // $FF: renamed from: M byte[]
    byte[] setToUnseq = new byte[256];
    // $FF: renamed from: N byte[]
    byte[] mtfa = new byte[4096];
    // $FF: renamed from: O int[]
    int[] mtfbase = new int[16];
    // $FF: renamed from: P byte[]
    byte[] selector;
    // $FF: renamed from: Q byte[]
    byte[] selectorMtf;
    // $FF: renamed from: R byte[][]
    byte[][] len;
    // $FF: renamed from: S int[][]
    int[][] limit;
    // $FF: renamed from: T int[][]
    int[][] base;
    // $FF: renamed from: U int[][]
    int[][] perm;
    // $FF: renamed from: V int[]
    int[] minLens;
    // $FF: renamed from: W int
    int saveNblock;

    BZState() {
        this.selector = new byte[this.eighteenThousandTwo];
        this.selectorMtf = new byte[this.eighteenThousandTwo];
        this.len = new byte[6][258];
        this.limit = new int[6][258];
        this.base = new int[6][258];
        this.perm = new int[6][258];
        this.minLens = new int[6];
    }
}
