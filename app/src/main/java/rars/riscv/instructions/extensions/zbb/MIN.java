package rars.riscv.instructions;

public class MIN extends Arithmetic {
    public MIN() {
        super("min t1,t2,t3", "Minimum: Set t1 to minimum of t2 and t3: t1 = (t2 < t3) ? t2 : t3",
                "0000101", "100");
    }

    public long compute(long value, long value2) {
        return (value < value2) ? value : value2;
    }
}
