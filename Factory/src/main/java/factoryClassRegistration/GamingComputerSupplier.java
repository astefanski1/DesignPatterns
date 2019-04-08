package factoryClassRegistration;

import java.util.function.Supplier;

public class GamingComputerSupplier implements Supplier<Computer> {

    @Override
    public GamingComputer get() {
        return new GamingComputer();
    }
}