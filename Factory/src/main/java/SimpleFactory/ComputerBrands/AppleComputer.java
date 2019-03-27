package SimpleFactory.ComputerBrands;

import SimpleFactory.Computer;

public class AppleComputer extends Computer {

    public AppleComputer() {
        name = "Apple";
        price = 560.0;
        processor = "i5 4770";
        os = "Mac OS";
        ram = 16;
        weight = 1.5;
        brand = ComputerBrands.APPLE;
    }
}
