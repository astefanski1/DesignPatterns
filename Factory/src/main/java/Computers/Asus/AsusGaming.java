package Computers.Asus;

import Computers.Computer;
import Computers.Utils.ComputerBrands;
import Computers.Utils.ComputerTypes;

public class AsusGaming extends Computer {

    public AsusGaming() {
        name = "TUF Gaming";
        price = 400.0;
        os = "Windows 10";
        weight = 3;
        brand = ComputerBrands.ASUS;
        computerType = ComputerTypes.GAMING;
        components.add("Procesor: i7 4770K");
        components.add("RAM: 16GB");
        components.add("GPU: Geforce GTX 1080");
        components.add("Motherboard: Gigabyte X470");
        components.add("Storage: SSD 512GB");
    }
}