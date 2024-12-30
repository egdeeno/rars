package rars.riscv.instructions;
import java.util.Optional;

public class ORN extends Arithmetic {
    public ORN() {
        super("orn t1,t2,t3", "OR with inverted operand: Set t1 to bitwise OR of t2 and bitwise inverted t3: t1 = t2 | ~t3",
                "0100000", "110");
    }

    public Optional<Long> compute(long value, long value2) {
        long res = value | ~value2;
        return Optional.of(res);
    }
}
