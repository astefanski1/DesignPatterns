package AbstractFactory.store;


import AbstractFactory.Computers.Computer;
import Computers.Utils.ComputerType;

public abstract class ComputerStore {

    protected abstract Computer createComputer(ComputerType computerType);

    public Computer orderComputer(ComputerType computerType) {
        Computer computer = createComputer(computerType);

        computer.orderAccepted();
        computer.assembly();
        computer.send();

        return computer;
    }
}
