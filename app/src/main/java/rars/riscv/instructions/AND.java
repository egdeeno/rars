package rars.riscv.instructions;
import java.util.Optional;

public class AND extends Arithmetic {
    public AND() {
        super("and t1,t2,t3", "Bitwise AND : Set t1 to bitwise AND of t2 and t3",
                "0000000", "111");
    }

    public Optional<Long> compute(long value, long value2) {
        long res = value & value2;
        return Optional.of(res);
    }
}
