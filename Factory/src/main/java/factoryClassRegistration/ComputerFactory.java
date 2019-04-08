package factoryClassRegistration;


import Computers.Utils.ComputerType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ComputerFactory {

    private static ComputerFactory computerFactory;
    private Map<ComputerType, Supplier<? extends Computer>> registeredComputers = new HashMap<>();

    private ComputerFactory() {
    }

    public static ComputerFactory getInstance() {
        if (computerFactory == null) {
            synchronized (ComputerFactory.class) {
                if (computerFactory == null) {
                    computerFactory = new ComputerFactory();
                }
            }
        }
        return computerFactory;
    }

    public void registerComputer(ComputerType computerType, Supplier<? extends Computer> computer) {
        registeredComputers.put(computerType, computer);
    }

    public Computer createComputer(ComputerType computerType) {
        Supplier<? extends Computer> computer = registeredComputers.get(computerType);
        return computer != null ? computer.get() : null;
    }
}
