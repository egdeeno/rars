package rars.riscv.instructions;
import java.util.Optional;

import rars.riscv.hardware.ControlAndStatusRegisterFile;

public class REMU extends Arithmetic {
    public REMU() {
        super("remu t1,t2,t3", "Remainder: set t1 to the remainder of t2/t3 using unsigned division",
                "0000001", "111");
    }
    public Optional<Long> compute(long value, long value2) {
        long res = Long.remainderUnsigned(value, value2);
        if (value2 == 0) {
            res = value;
        }
        return Optional.of(res);
    }
    public Optional<Integer> computeW(int value, int value2) {
        int res = Integer.remainderUnsigned(value, value2);
        if (value2 == 0) {
            res = value;
        }
        return Optional.of(res);
    }
}
