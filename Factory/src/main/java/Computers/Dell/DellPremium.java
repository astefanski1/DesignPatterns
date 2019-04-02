package Computers.Dell;

import Computers.Computer;
import Computers.Utils.ComputerBrand;
import Computers.Utils.ComputerType;

public class DellPremium extends Computer {

    public DellPremium() {
        name = "Vostro";
        price = 450.0;
        os = "Windows 10";
        weight = 2.5;
        brand = ComputerBrand.DELL;
        computerType = ComputerType.PREMIUM;
        components.add("Procesor: i7 4770");
        components.add("RAM: 16GB");
        components.add("GPU: Geforce GTX 1080");
        components.add("Motherboard: MSI X470");
        components.add("Storage: SSD 500GB");
    }
}