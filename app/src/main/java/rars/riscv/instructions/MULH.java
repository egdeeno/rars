package rars.riscv.instructions;
import java.util.Optional;

import java.math.BigInteger;

public class MULH extends Arithmetic {
    public MULH() {
        super("mulh t1,t2,t3", "Multiplication: set t1 to the upper 32 bits of t2*t3 using signed multiplication",
                "0000001", "001");
    }
    public Optional<Long> compute(long value, long value2) {
        // if this is too slow, it is possible to do it with just long multiplication
        long res = BigInteger.valueOf(value).multiply(BigInteger.valueOf(value2)).shiftRight(64).longValue();
        return Optional.of(res);
    }
    public Optional<Integer> computeW(int value, int value2) {
        // Sign extend both arguments
        long ext = ((long) value << 32) >> 32, ext2 = ((long) value2 << 32) >> 32;
        // Return the top 32 bits of the mutliplication
        int res = (int) ((ext * ext2) >> 32);
        return Optional.of(res);
    }
}
