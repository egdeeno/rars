package rars.riscv.instructions;
import java.util.Optional;

public class ANDN extends Arithmetic {
    public ANDN() {
        super("andn t1,t2,t3", "AND with inverted operand: Set t1 to bitwise AND of t2 and bitwise inverted t3: t1 = t2 & ~t3",
                "0100000", "111");
    }

    public Optional<Long> compute(long value, long value2) {
        long res = value & ~value2;
        return Optional.of(res);
    }
}
