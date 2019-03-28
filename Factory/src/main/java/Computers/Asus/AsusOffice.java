package Computers.Asus;

import Computers.Computer;
import Computers.Utils.ComputerBrands;
import Computers.Utils.ComputerTypes;

public class AsusOffice extends Computer {

    public AsusOffice() {
        name = "VivoBook";
        price = 225.0;
        os = "Windows 10";
        weight = 2.0;
        brand = ComputerBrands.ASUS;
        computerType = ComputerTypes.OFFICE;
        components.add("Procesor: i5 4770");
        components.add("RAM: 12GB");
        components.add("GPU: Geforce GTX 1060ti");
        components.add("Motherboard: Gigabyte X470");
        components.add("Storage: HDD 512GB");
    }
}