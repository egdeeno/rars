package rars.riscv.instructions;

import rars.ProgramStatement;
import rars.riscv.InstructionSet;
import rars.riscv.hardware.RegisterFile;
import rars.riscv.BasicInstruction;
import rars.riscv.BasicInstructionFormat;

import java.util.Optional;

/**
 * Base class for all integer instructions using immediates
 *
 * @author Benjamin Landers
 * @version June 2017
 */
public abstract class Arithmetic extends BasicInstruction {

    public Arithmetic(String usage, String description, String funct7, String funct3) {
        super(usage, description, BasicInstructionFormat.R_FORMAT,
                funct7 + " ttttt sssss " + funct3 + " fffff 0110011");
    }
    public Arithmetic(String usage, String description, String funct7, String funct3, boolean rv64){
        super(usage, description, BasicInstructionFormat.R_FORMAT,
                funct7 + " ttttt sssss " + funct3 + " fffff 0111011",rv64);
    }

    public void simulate(ProgramStatement statement) {
        int[] operands = statement.getOperands();
        if (InstructionSet.rv64){
            RegisterFile.updateRegister(operands[0], compute(RegisterFile.getValueLong(operands[1]),RegisterFile.getValueLong(operands[2])));
        }else {
            long res = computeW(RegisterFile.getValue(operands[1]),RegisterFile.getValue(operands[2])).orElse(99999);
            RegisterFile.updateRegister(operands[0], Optional.of(res));
        }
    }

    /**
     * @param value  the value from the first register
     * @param value2 the value from the second register
     * @return the result to be stored from the instruction
     */
    protected abstract Optional<Long> compute(long value, long value2);

    /**
     * A version for rv32 / W instructions in rv64, override if the default behaviour is not correct
     * @param value  the value from the first register truncated to 32 bits
     * @param value2 the value from the second register truncated to 32 bits
     * @return the result to be stored from the instruction
     */
    protected Optional<Integer> computeW(int value, int value2) {
        long tmp = compute(value,value2).orElse(0L);
        int res = (int) tmp;
        return Optional.of(res);
    }
}
