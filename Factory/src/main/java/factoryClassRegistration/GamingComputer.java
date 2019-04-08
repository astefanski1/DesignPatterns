package factoryClassRegistration;

import Computers.Utils.ComputerBrand;
import Computers.Utils.ComputerType;

public class GamingComputer extends Computer {
    public GamingComputer() {
        name = "MackBook Pro";
        price = 760.0;
        os = "Mac OS";
        weight = 1.3;
        brand = ComputerBrand.APPLE;
        computerType = ComputerType.GAMING;
        components.add("Procesor: i7 4990k");
        components.add("RAM: 64GB");
        components.add("GPU: Geforce GTX 1080");
        components.add("Motherboard: MSI X470");
        components.add("Storage: SSD 2TB");
    }

    @Override
    public Computer createComputer() {
        return new GamingComputer();
    }
}
