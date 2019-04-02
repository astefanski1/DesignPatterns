package FactoryMethod;

import Computers.Computer;
import Computers.Utils.ComputerType;

public abstract class ComputerStore {

    abstract Computer createComputer(Enum<ComputerType> computerType);

    public Computer orderComputer(Enum<ComputerType> computerType) {
        Computer computer = createComputer(computerType);

        computer.orderAccepted();
        computer.assembly();
        computer.send();

        return computer;
    }
}
