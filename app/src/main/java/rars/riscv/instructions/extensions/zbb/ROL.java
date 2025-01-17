package rars.riscv.instructions;

public class ROL extends Arithmetic {
    public ROL() {
        super("rol t1,t2,t3", "Rotate left: Rotate left of t2 by the amount in least-significant log2(XLEN) bits of t3: shamt = (XLEN == 32) ? t3[4..0] : t3[5..0]; t1 = (t2 << shamt) | (t2 >> (XLEN - shamt))",
                "0110000", "001");
    }

    public long compute(long value, long value2) {
        int shamt = (int)value2 & 0b110;
        return ((value << shamt) | (value >> (64-shamt)));
    }
    
    public int computeW(int value, int value2) {
        int shamt = value2 & 0b101;
        return ((value << shamt) | (value >> (32-shamt)));
    }
}
