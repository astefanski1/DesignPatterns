package Computers.Asus;

import Computers.Computer;
import Computers.Utils.ComputerBrand;
import Computers.Utils.ComputerType;

public class AsusGaming extends Computer {

    public AsusGaming() {
        name = "TUF Gaming";
        price = 400.0;
        os = "Windows 10";
        weight = 3;
        brand = ComputerBrand.ASUS;
        computerType = ComputerType.GAMING;
        components.add("Procesor: i7 4770K");
        components.add("RAM: 16GB");
        components.add("GPU: Geforce GTX 1080");
        components.add("Motherboard: Gigabyte X470");
        components.add("Storage: SSD 512GB");
    }
}