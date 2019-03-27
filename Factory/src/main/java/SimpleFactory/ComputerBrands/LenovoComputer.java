package SimpleFactory.ComputerBrands;

import SimpleFactory.Computer;

public class LenovoComputer extends Computer {

    public LenovoComputer() {
        name = "Lenovo";
        price = 300.0;
        processor = "i7 4970K";
        os = "Windows 10";
        ram = 16;
        weight = 2;
        brand = ComputerBrands.LENOVO;
    }
}