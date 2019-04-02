package Computers.Apple;

import Computers.Computer;
import Computers.Utils.ComputerBrand;
import Computers.Utils.ComputerType;

public class ApplePremium extends Computer {

    public ApplePremium() {
        name = "MackBook Air";
        price = 360.0;
        os = "Mac OS";
        weight = 2.0;
        brand = ComputerBrand.APPLE;
        computerType = ComputerType.PREMIUM;
        components.add("Procesor: i3 4790");
        components.add("RAM: 16GB");
        components.add("GPU: Geforce GTX 1050");
        components.add("Motherboard: MSI B250");
        components.add("Storage: SSS 256GB");
    }
}