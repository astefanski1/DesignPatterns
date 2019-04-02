package Computers.Lenovo;

import Computers.Computer;
import Computers.Utils.ComputerBrand;
import Computers.Utils.ComputerType;

public class LenovoPremium extends Computer {

    public LenovoPremium() {
        name = "ThinkPad";
        price = 250.0;
        os = "Windows 10";
        weight = 4.0;
        brand = ComputerBrand.LENOVO;
        computerType = ComputerType.PREMIUM;
        components.add("Procesor: i3 4570");
        components.add("RAM: 4GB");
        components.add("GPU: Geforce GTX 1050");
        components.add("Motherboard: MSI B450M");
        components.add("Storage: HDD 250 GB");
    }
}
