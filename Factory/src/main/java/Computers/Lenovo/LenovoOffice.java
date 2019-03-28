package Computers.Lenovo;

import Computers.Computer;
import Computers.Utils.ComputerBrands;
import Computers.Utils.ComputerTypes;

public class LenovoOffice extends Computer {

    public LenovoOffice() {
        name = "IdeaPad";
        price = 300.0;
        os = "Windows 10";
        weight = 4.0;
        brand = ComputerBrands.LENOVO;
        computerType = ComputerTypes.OFFICE;
        components.add("Procesor: i3 4970");
        components.add("RAM: 4GB");
        components.add("GPU: Geforce GTX 1050");
        components.add("Motherboard: MSI B450M");
        components.add("Storage: HDD 250GB");
    }
}