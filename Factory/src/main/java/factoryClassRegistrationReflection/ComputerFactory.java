package factoryClassRegistrationReflection;

import Computers.Computer;
import Computers.Utils.ComputerType;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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

    public Computer createComputer(ComputerType computerType) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class computerClass = (Class) registeredComputers.get(computerType);
        Constructor computerConstructor = computerClass.getDeclaredConstructor(new Class[] {});
        return (Computer) computerConstructor.newInstance(new Object[] {});
    }
}
