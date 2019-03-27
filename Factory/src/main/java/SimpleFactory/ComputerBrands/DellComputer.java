package SimpleFactory.ComputerBrands;

import SimpleFactory.Computer;

public class DellComputer extends Computer {

    public DellComputer() {
        name = "Dell";
        price = 400.0;
        processor = "i7 5990K";
        os = "Windows 10";
        ram = 32;
        weight = 4;
        brand = ComputerBrands.DELL;
    }
}
