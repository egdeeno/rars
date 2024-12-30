package rars.riscv.instructions;
import java.util.Optional;

import rars.riscv.hardware.ControlAndStatusRegisterFile;

public class DIVU extends Arithmetic {
    public DIVU() {
        super("divu t1,t2,t3", "Division: set t1 to the result of t2/t3 using unsigned division",
                "0000001", "101");
    }
    public Optional<Long> compute(long value, long value2) {
        // Signal illegal division with -1
        long res = Long.divideUnsigned(value, value2);
        if (value2 == 0) {
            res = -1;
        }
        return Optional.of(res);
    }
    public Optional<Integer> computeW(int value, int value2) {
        long res = compute(value & 0xFFFFFFFFL, value2 & 0xFFFFFFFFL).orElse(0l);
        return Optional.of((int)res);
    }
}
