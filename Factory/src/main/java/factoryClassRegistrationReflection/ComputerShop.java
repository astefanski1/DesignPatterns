package factoryClassRegistrationReflection;

import Computers.Computer;
import Computers.Utils.ComputerType;

import java.lang.reflect.InvocationTargetException;

public class ComputerShop {

    private ComputerFactory computerFactory;

    public ComputerShop(ComputerFactory computerFactory) {
        this.computerFactory = computerFactory.getInstance();
    }

    public Computer makeComputer(ComputerType computerType) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Computer computer = computerFactory.createComputer(computerType);

        computer.orderAccepted();
        computer.assembly();
        computer.send();

        return computer;
    }
}
