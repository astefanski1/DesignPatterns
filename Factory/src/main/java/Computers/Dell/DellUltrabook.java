package Computers.Dell;

import Computers.Computer;
import Computers.Utils.ComputerBrands;
import Computers.Utils.ComputerTypes;

public class DellUltrabook extends Computer {

    public DellUltrabook() {
        name = "XPS";
        price = 400.0;
        os = "Windows 10";
        weight = 4;
        brand = ComputerBrands.DELL;
        computerType = ComputerTypes.ULTRABOOK;
        components.add("Procesor: i5 4770");
        components.add("RAM: 8GB");
        components.add("GPU: Geforce GTX 1060");
        components.add("Motherboard: MSI B250M");
        components.add("Storage: HDD 500GB");
    }
}
