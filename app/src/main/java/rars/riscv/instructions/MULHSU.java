package rars.riscv.instructions;
import java.util.Optional;

import java.math.BigInteger;

public class MULHSU extends Arithmetic {
    public MULHSU() {
        super("mulhsu t1,t2,t3", "Multiplication: set t1 to the upper 32 bits of t2*t3 where t2 is signed and t3 is unsigned",
                "0000001", "010");
    }

    public Optional<Long> compute(long value, long value2) {
        BigInteger unsigned = BigInteger.valueOf(value2);
        if (value2 < 0) {
            unsigned = unsigned.add(BigInteger.ONE.shiftLeft(64));
        }
        long res = BigInteger.valueOf(value).multiply(unsigned).shiftRight(64).longValue();
        return Optional.of(res);
    }
    public Optional<Integer> computeW(int value, int value2) {
        //Sign extend t2, but not t3
        long ext = ((long) value << 32) >> 32, ext2 = ((long) value2) & 0xFFFFFFFFL;
        // Return the top 32 bits of the mutliplication
        int res = (int) ((ext * ext2) >> 32);
        return Optional.of(res);
    }
}
