package rars.riscv.instructions;
import java.util.Optional;

public class XOR extends Arithmetic {
    public XOR() {
        super("xor t1,t2,t3", "Bitwise XOR : Set t1 to bitwise XOR of t2 and t3",
                "0000000", "100");
    }

    public Optional<Long> compute(long value, long value2) {
        long res = value ^ value2;
        return Optional.of(res);
    }
}
