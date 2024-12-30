package rars.riscv.hardware;

import rars.util.Binary;

/**
 * Represents AddressErrorException. This is generated by the simulator when the
 * source code references a memory address not valid for the context.
 *
 * @author Pete Sanderson
 * @version August 2003
 **/
public class AddressErrorException extends Exception {
    private final int address;
    private final int type;  // SimulationException.(STORE|LOAD|INSTRUCTION)_(ADDRESS_MISALIGNED|ACCESS_FAULT)


    /**
     * Constructor for the AddressErrorException class
     *
     * @param addr The erroneous memory address.
     **/

    public AddressErrorException(String message, int exceptType, int addr) {
        super(message + Binary.intToHexString(addr));
        address = addr;
        type = exceptType;
    }

    /**
     * Get the erroneous memory address.
     *
     * @return The erroneous memory address.
     **/
    public int getAddress() {
        return address;
    }

    /**
     * Get the exception type (load or store).
     *
     * @return Exception type: SimulationException.(STORE|LOAD|INSTRUCTION)_(ADDRESS_MISALIGNED|ACCESS_FAULT)
     **/
    public int getType() {
        return type;
    }
}