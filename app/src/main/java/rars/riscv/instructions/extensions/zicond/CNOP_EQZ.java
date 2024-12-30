package rars.riscv.instructions;
import java.util.Optional;

public class CNOP_EQZ extends Arithmetic {
    public CNOP_EQZ() {
        super("cnop.eqz t1,t2,t3", "Nop if zero: do nothing(nop) if t3 is equal to 0, otherwise move t2 to t1",
                "0000111", "100");
    }
    
    public Optional<Long> compute(long value, long value2) {
        if (value2 == 0) {
            return Optional.empty();
        }
        return Optional.of(value);
    }
}
