package rars.riscv.instructions;
import java.util.Optional;

public class SRA extends Arithmetic {
    public SRA() {
        super("sra t1,t2,t3", "Shift right arithmetic: Set t1 to result of sign-extended shifting t2 right by number of bits specified by value in low-order 5 bits of t3",
                "0100000", "101");
    }
    public Optional<Long> compute(long value, long value2) {
        long res = value >> (value2 & 0x0000003F); // Use the bottom 6 bits
        return Optional.of(res);
    }
    public Optional<Integer> computeW(int value, int value2) {
        /// Use >> to sign-fill
        int res = value >> (value2 & 0x0000001F); // Only use the bottom 5 bits
        return Optional.of(res);
    }
}
