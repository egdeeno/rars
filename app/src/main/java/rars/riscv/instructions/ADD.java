package rars.riscv.instructions;
import java.util.Optional;

public class ADD extends Arithmetic {
    public ADD() {
        super("add t1,t2,t3", "Addition: set t1 to (t2 plus t3)",
                "0000000", "000");
    }

    public Optional<Long> compute(long value, long value2) {
        long res = value + value2;
        return Optional.of(res);
    }
}
