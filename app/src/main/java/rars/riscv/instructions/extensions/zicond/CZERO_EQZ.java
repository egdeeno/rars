package rars.riscv.instructions;

public class CZERO_EQZ extends Arithmetic {
    public CZERO_EQZ() {
        super("czero.eqz t1,t2,t3", "Condition if zero: set t1 0 if t3 is equal to 0, otherwise move t2 to t1",
                "0000111", "101");
    }

    public long compute(long value, long value2) {
        if (value2 == 0) {
            return 0;
        }
        return value;
    }
}
