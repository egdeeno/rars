package rars.riscv.instructions;

public class MAX extends Arithmetic {
    public MAX() {
        super("max t1,t2,t3", "Maximum: Set t1 to maximum of t2 and t3: t1 = (t2 > t3) ? t2 : t3",
                "0000101", "110");
    }

    public long compute(long value, long value2) {
        return (value > value2) ? value : value2;
    }
}
