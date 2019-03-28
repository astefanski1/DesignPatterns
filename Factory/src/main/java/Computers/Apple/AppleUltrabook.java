package Computers.Apple;

import Computers.Computer;
import Computers.Utils.ComputerBrands;
import Computers.Utils.ComputerTypes;

public class AppleUltrabook extends Computer {

    public AppleUltrabook() {
        name = "MacBook";
        price = 560.0;
        os = "Mac OS";
        weight = 1.5;
        brand = ComputerBrands.APPLE;
        computerType = ComputerTypes.ULTRABOOK;
        components.add("Procesor: i5 4990");
        components.add("RAM: 32GB");
        components.add("GPU: Geforce GTX 1070");
        components.add("Motherboard: MSI X470");
        components.add("Storage: SSD 1TB");
    }
}
