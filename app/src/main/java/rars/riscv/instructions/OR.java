package rars.riscv.instructions;
import java.util.Optional;

public class OR extends Arithmetic {
    public OR() {
        super("or t1,t2,t3", "Bitwise OR : Set t1 to bitwise OR of t2 and t3",
                "0000000", "110");
    }

    public Optional<Long> compute(long value, long value2) {
        long res = value | value2;
        return Optional.of(res);
    }
}
