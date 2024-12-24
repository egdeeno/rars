package rars.riscv.instructions;

public class XNOR extends Arithmetic {
    public XNOR() {
        super("xnor t1,t2,t3", "Exclusive NOR: Set t1 to bitwise exclusive NOR of t2 and t3: t1 = ~(t2 xor t3)",
                "0100000", "100");
    }

    public long compute(long value, long value2) {
        return ~(value ^ value2);
    }
}
