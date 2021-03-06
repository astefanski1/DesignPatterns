package Computers.Dell;

import Computers.Computer;
import Computers.Utils.ComputerBrand;
import Computers.Utils.ComputerType;

public class DellOffice extends Computer {

    public DellOffice() {
        name = "Latitude";
        price = 500.0;
        os = "Windows 10";
        weight = 2.0;
        brand = ComputerBrand.DELL;
        computerType = ComputerType.OFFICE;
        components.add("Procesor: i7 4970");
        components.add("RAM: 32GB");
        components.add("GPU: Geforce GTX 1080");
        components.add("Motherboard: Gigabyte Sniper 3.0");
        components.add("Storage: SSD 1TB");
    }
}