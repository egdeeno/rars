package rars.riscv.instructions;
import java.util.Optional;

public class XNOR extends Arithmetic {
    public XNOR() {
        super("xnor t1,t2,t3", "Exclusive NOR: Set t1 to bitwise exclusive NOR of t2 and t3: t1 = ~(t2 xor t3)",
                "0100000", "100");
    }

    public Optional<Long> compute(long value, long value2) {
        long res = ~(value ^ value2);
        return Optional.of(res);
    }
}
