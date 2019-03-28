package Computers.Dell;

import Computers.Computer;
import Computers.Utils.ComputerBrands;
import Computers.Utils.ComputerTypes;

public class DellGaming extends Computer {

    public DellGaming() {
        name = "Alienware";
        price = 800.0;
        os = "Windows 10";
        weight = 3.0;
        brand = ComputerBrands.DELL;
        computerType = ComputerTypes.GAMING;
        components.add("Procesor: i9 4770k");
        components.add("RAM: 64GB");
        components.add("GPU: Geforce GTX 1080ti");
        components.add("Motherboard: MSI X470");
        components.add("Storage: SSD 2TB");
    }
}
