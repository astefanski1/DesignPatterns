package AbstractFactory.Computers;

import AbstractFactory.Factory.PartsFactory;
import Computers.Utils.ComputerType;

public class OfficeComputer extends Computer {

    PartsFactory partsFactory;

    public OfficeComputer(PartsFactory partsFactory) {
        this.partsFactory = partsFactory;
        this.computerType = ComputerType.OFFICE;
    }

    public void prepareParts() {
        System.out.println("Preparing parts for " + getBrand());
        processor = partsFactory.createProcessor();
        ram = partsFactory.createRam();
        storage = partsFactory.createStorage();
    }
}