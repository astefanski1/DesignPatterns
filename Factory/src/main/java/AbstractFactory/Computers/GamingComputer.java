package AbstractFactory.Computers;

import AbstractFactory.Factory.PartsFactory;
import Computers.Utils.ComputerType;

public class GamingComputer extends Computer {

    PartsFactory partsFactory;

    public GamingComputer(PartsFactory partsFactory) {
        this.partsFactory = partsFactory;
        this.computerType = ComputerType.GAMING;
    }

    public void prepareParts() {
        System.out.println("Preparing parts for " + getBrand());
        processor = partsFactory.createProcessor();
        ram = partsFactory.createRam();
        storage = partsFactory.createStorage();
    }
}
