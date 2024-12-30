package rars.riscv.instructions;
import java.util.Optional;

import rars.riscv.hardware.ControlAndStatusRegisterFile;

public class REM extends Arithmetic {
    public REM() {
        super("rem t1,t2,t3", "Remainder: set t1 to the remainder of t2/t3",
                "0000001", "110");
    }

    public Optional<Long> compute(long value, long value2) {
        long res = value % value2;
        // Division by 0
        if (value2 == 0) {
            res = value;
        }
        // Overflow case should be correct just by Java modulus
        return Optional.of(res);
    }
}
