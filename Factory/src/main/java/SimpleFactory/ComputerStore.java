package SimpleFactory;

public class ComputerStore {
    private SimpleComputerFactory simpleComputerFactory;

    public ComputerStore(SimpleComputerFactory simpleComputerFactory) {
        this.simpleComputerFactory = simpleComputerFactory;
    }

    public Computer orderComputer(Enum brand) {
        Computer computer;

        computer = simpleComputerFactory.createComputer(brand);

        return computer;
    }
}
