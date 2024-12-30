package rars.riscv.instructions;
import java.util.Optional;

import rars.riscv.hardware.ControlAndStatusRegisterFile;

public class DIV extends Arithmetic {
    public DIV() {
        super("div t1,t2,t3", "Division: set t1 to the result of t2/t3",
                "0000001", "100");
    }

    public Optional<Long> compute(long value, long value2) {
        long res = value / value2;
        // Signal illegal division with -1
        if (value2 == 0) {
            res = -1;
        }
        // Overflow case should be correct just by Java division
        return Optional.of(res);
    }
}