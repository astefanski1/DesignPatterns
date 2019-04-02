package Computers.Lenovo;

import Computers.Computer;
import Computers.Utils.ComputerBrand;
import Computers.Utils.ComputerType;

public class LenovoGaming extends Computer {

    public LenovoGaming() {
        name = "Legion";
        price = 800.0;
        os = "Windows 10";
        weight = 2.0;
        brand = ComputerBrand.LENOVO;
        computerType = ComputerType.GAMING;
        components.add("Procesor: i7 4970k");
        components.add("RAM: 16GB");
        components.add("GPU: Geforce GTX 1080 ti");
        components.add("Motherboard: MSI B450M");
        components.add("Storage: SSD 1TB");
    }
}