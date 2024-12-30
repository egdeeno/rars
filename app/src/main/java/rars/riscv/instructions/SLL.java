package rars.riscv.instructions;
import java.util.Optional;

public class SLL extends Arithmetic {
    public SLL() {
        super("sll t1,t2,t3", "Shift left logical: Set t1 to result of shifting t2 left by number of bits specified by value in low-order 5 bits of t3",
                "0000000", "001");
    }
    public Optional<Long> compute(long value, long value2) {
        long res = value << (value2 & 0x0000003F); // Use the bottom 6 bits
        return Optional.of(res);
    }

    public Optional<Integer> computeW(int value, int value2) {
        int res = value << (value2 & 0x0000001F); // Only use the bottom 5 bits
        return Optional.of(res);
    }
}
