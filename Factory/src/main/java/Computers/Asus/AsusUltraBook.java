package Computers.Asus;

import Computers.Computer;
import Computers.Utils.ComputerBrand;
import Computers.Utils.ComputerType;

public class AsusUltraBook extends Computer {

    public AsusUltraBook() {
        name = "ZenBook Classic";
        price = 200.0;
        os = "Windows 10";
        weight = 2.5;
        brand = ComputerBrand.ASUS;
        computerType = ComputerType.ULTRABOOK;
        components.add("Procesor: i5 4670");
        components.add("RAM: 8GB");
        components.add("GPU: Geforce GTX 1060");
        components.add("Motherboard: Gigabyte X470");
        components.add("Storage: HDD 512GB");
    }
}