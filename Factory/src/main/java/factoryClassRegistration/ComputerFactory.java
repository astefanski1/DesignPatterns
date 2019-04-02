package factoryClassRegistration;


import Computers.Utils.ComputerType;

import java.util.HashMap;

public class ComputerFactory {

    private static ComputerFactory computerFactory;
    private HashMap registeredComputers = new HashMap();

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

    public void registerComputer(ComputerType computerType, Class computerClass) {
        registeredComputers.put(computerType, computerClass);
    }

    public void registerComputer(ComputerType computerType, Computer computer) {
        registeredComputers.put(computerType, computer);
    }

    public Computer createComputer(ComputerType computerType) {
        return ((Computer) registeredComputers.get(computerType)).createComputer();
    }
}
