package Computers.Apple;

import Computers.Computer;
import Computers.Utils.ComputerBrand;
import Computers.Utils.ComputerType;

public class AppleOffice extends Computer {

    public AppleOffice() {
        name = "IMac";
        price = 1060.0;
        os = "Mac OS";
        weight = 4.0;
        brand = ComputerBrand.APPLE;
        computerType = ComputerType.OFFICE;
        components.add("Procesor: i7 4990k");
        components.add("RAM: 64GB");
        components.add("GPU: Geforce GTX 1080ti");
        components.add("Motherboard: MSI X470");
        components.add("Storage: SSD 2TB");
    }
}