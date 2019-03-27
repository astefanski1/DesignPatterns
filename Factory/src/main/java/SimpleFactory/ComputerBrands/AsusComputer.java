package SimpleFactory.ComputerBrands;

import SimpleFactory.Computer;

public class AsusComputer extends Computer {

    public AsusComputer() {
        name = "Asus";
        price = 250.0;
        processor = "i5 4970";
        os = "Windows 10";
        ram = 8;
        weight = 3;
        brand = ComputerBrands.ASUS;
    }
}