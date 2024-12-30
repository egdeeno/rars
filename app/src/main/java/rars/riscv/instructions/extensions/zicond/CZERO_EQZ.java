package rars.riscv.instructions;
import java.util.Optional;

public class CZERO_EQZ extends Arithmetic {
    public CZERO_EQZ() {
        super("czero.eqz t1,t2,t3", "Condition if zero: set t1 0 if t3 is equal to 0, otherwise move t2 to t1",
                "0000111", "101");
    }

    public Optional<Long> compute(long value, long value2) {
        long res = value;
        if (value2 == 0) {
            res = 0;
        }
        return Optional.of(res);
    }
}
