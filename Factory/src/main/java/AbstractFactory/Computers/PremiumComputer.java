package AbstractFactory.Computers;

import AbstractFactory.Factory.PartsFactory;
import Computers.Utils.ComputerType;

public class PremiumComputer extends Computer {
    PartsFactory partsFactory;

    public PremiumComputer(PartsFactory partsFactory) {
        this.partsFactory = partsFactory;
        this.computerType = ComputerType.PREMIUM;
    }

    public void prepareParts() {
        System.out.println("Preparing parts for " + getBrand());
        processor = partsFactory.createProcessor();
        ram = partsFactory.createRam();
        storage = partsFactory.createStorage();
    }
}