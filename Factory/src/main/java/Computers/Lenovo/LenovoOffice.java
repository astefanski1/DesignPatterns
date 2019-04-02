package Computers.Lenovo;

import Computers.Computer;
import Computers.Utils.ComputerBrand;
import Computers.Utils.ComputerType;

public class LenovoOffice extends Computer {

    public LenovoOffice() {
        name = "IdeaPad";
        price = 300.0;
        os = "Windows 10";
        weight = 4.0;
        brand = ComputerBrand.LENOVO;
        computerType = ComputerType.OFFICE;
        components.add("Procesor: i3 4970");
        components.add("RAM: 4GB");
        components.add("GPU: Geforce GTX 1050");
        components.add("Motherboard: MSI B450M");
        components.add("Storage: HDD 250GB");
    }
}