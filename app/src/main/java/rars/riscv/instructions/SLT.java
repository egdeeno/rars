package rars.riscv.instructions;
import java.util.Optional;

public class SLT extends Arithmetic {
    public SLT() {
        super("slt t1,t2,t3", "Set less than : If t2 is less than t3, then set t1 to 1 else set t1 to 0",
                "0000000", "010");
    }

    public Optional<Long> compute(long value, long value2) {
        long res = (value < value2) ? 1 : 0;
        return Optional.of(res);
    }
}
