package rars.riscv.instructions;
import java.util.Optional;

public class MAX extends Arithmetic {
    public MAX() {
        super("max t1,t2,t3", "Maximum: Set t1 to maximum of t2 and t3: t1 = (t2 > t3) ? t2 : t3",
                "0000101", "110");
    }

    public Optional<Long> compute(long value, long value2) {
        long res = (value > value2) ? value : value2;
        return Optional.of(res);
    }
}
