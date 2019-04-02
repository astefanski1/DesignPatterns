package Computers;

import SimpleFactory.SimpleComputerFactory;

public class ComputerStore {
    private SimpleComputerFactory simpleComputerFactory;

    public ComputerStore(SimpleComputerFactory simpleComputerFactory) {
        this.simpleComputerFactory = simpleComputerFactory;
    }

    public Computer orderComputer(Enum brand) {
        Computer computer;

        computer = simpleComputerFactory.createComputer(brand);

        computer.orderAccepted();
        computer.assembly();
        computer.send();

        return computer;
    }
}
