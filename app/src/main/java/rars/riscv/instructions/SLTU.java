package rars.riscv.instructions;
import java.util.Optional;

public class SLTU extends Arithmetic {
    public SLTU() {
        super("sltu t1,t2,t3", "Set less than : If t2 is less than t3 using unsigned comparision, then set t1 to 1 else set t1 to 0",
                "0000000", "011");
    }
    public Optional<Long> compute(long value, long value2) {
        long res = (Long.compareUnsigned(value, value2) < 0) ? 1 : 0;
        return Optional.of(res);
    }
}
