package Computers.Asus;

import Computers.Computer;
import Computers.Utils.ComputerBrands;
import Computers.Utils.ComputerTypes;

public class AsusPremium extends Computer {

    public AsusPremium() {
        name = "ZenBook";
        price = 150.0;
        os = "Windows 10";
        weight = 3;
        brand = ComputerBrands.ASUS;
        computerType = ComputerTypes.PREMIUM;
        components.add("Procesor: i3 4670");
        components.add("RAM: 4GB");
        components.add("GPU: Geforce GTX 1050");
        components.add("Motherboard: Gigabyte X470");
        components.add("Storage: HDD 256GB");
    }
}