package Computers.Lenovo;

import Computers.Computer;
import Computers.Utils.ComputerBrand;
import Computers.Utils.ComputerType;

public class LenovoUltrabook extends Computer {

    public LenovoUltrabook() {
        name = "Yoga";
        price = 400.0;
        os = "Windows 10";
        weight = 1.5;
        brand = ComputerBrand.LENOVO;
        computerType = ComputerType.ULTRABOOK;
        components.add("Procesor: i5 4970k");
        components.add("RAM: 8GB");
        components.add("GPU: Geforce GTX 1060");
        components.add("Motherboard: MSI B450M");
        components.add("Storage: SSD 256GB");
    }
}
