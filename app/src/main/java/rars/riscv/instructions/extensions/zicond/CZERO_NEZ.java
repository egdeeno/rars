package rars.riscv.instructions;
import java.util.Optional;

public class CZERO_NEZ extends Arithmetic {
    public CZERO_NEZ() {
        super("czero.nez t1,t2,t3", "Condition if zero: set t1 0 if t3 is not equal to 0, otherwise move t2 to t1",
                "0000111", "111");
    }

    public Optional<Long> compute(long value, long value2) {
        long res = value;
        if (value2 != 0) {
            res = 0;
        }
        return Optional.of(res);
    }
}
