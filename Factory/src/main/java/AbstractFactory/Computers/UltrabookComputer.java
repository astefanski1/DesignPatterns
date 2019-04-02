package AbstractFactory.Computers;

import AbstractFactory.Factory.PartsFactory;
import Computers.Utils.ComputerType;

public class UltrabookComputer extends Computer {

    PartsFactory partsFactory;

    public UltrabookComputer(PartsFactory partsFactory) {
        this.partsFactory = partsFactory;
        this.computerType = ComputerType.ULTRABOOK;
    }

    public void prepareParts() {
        System.out.println("Preparing parts for " + getBrand());
        processor = partsFactory.createProcessor();
        ram = partsFactory.createRam();
        storage = partsFactory.createStorage();
    }
}
