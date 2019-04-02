package AbstractFactory.store;

import AbstractFactory.Computers.Computer;
import AbstractFactory.Computers.GamingComputer;
import AbstractFactory.Computers.OfficeComputer;
import AbstractFactory.Computers.PremiumComputer;
import AbstractFactory.Computers.UltrabookComputer;
import AbstractFactory.Factory.LenovoPartsFactory;
import AbstractFactory.Factory.PartsFactory;
import Computers.Utils.ComputerBrand;
import Computers.Utils.ComputerType;

public class LenovoComputerStore extends ComputerStore {

    @Override
    protected Computer createComputer(ComputerType computerType) {
        PartsFactory partsFactory = LenovoPartsFactory.getInstance();
        Computer computer = null;

        if (computerType.equals(ComputerType.PREMIUM)) {
            computer = new PremiumComputer(partsFactory);
            computer.setBrand(ComputerBrand.LENOVO);
            computer.setName("L300");
            computer.setOs("Windows 10");
            computer.setPrice(300.0);
            computer.setWeight(2.0);
            return computer;
        } else if (computerType.equals(ComputerType.GAMING)) {
            computer = new GamingComputer(partsFactory);
            computer.setBrand(ComputerBrand.LENOVO);
            computer.setName("L500");
            computer.setOs("Windows 10");
            computer.setPrice(500.0);
            computer.setWeight(2.5);
            return computer;
        } else if (computerType.equals(ComputerType.OFFICE)) {
            computer = new OfficeComputer(partsFactory);
            computer.setBrand(ComputerBrand.LENOVO);
            computer.setName("L200");
            computer.setOs("Windows 10");
            computer.setPrice(200.0);
            computer.setWeight(4.0);
            return computer;
        } else if (computerType.equals(ComputerType.ULTRABOOK)) {
            computer = new UltrabookComputer(partsFactory);
            computer.setBrand(ComputerBrand.LENOVO);
            computer.setName("L400");
            computer.setOs("Windows 10");
            computer.setPrice(400.0);
            computer.setWeight(1.0);
            return computer;
        } else return null;
    }
}