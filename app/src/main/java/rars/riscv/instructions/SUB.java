package rars.riscv.instructions;
import java.util.Optional;

public class SUB extends Arithmetic {
    public SUB() {
        super("sub t1,t2,t3", "Subtraction: set t1 to (t2 minus t3)",
                "0100000", "000");
    }

    public Optional<Long> compute(long value, long value2) {
        long res = value - value2;
        return Optional.of(res);
    }
}
