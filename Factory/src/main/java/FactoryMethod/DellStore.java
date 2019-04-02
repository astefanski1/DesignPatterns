package FactoryMethod;

import Computers.Computer;
import Computers.Dell.DellGaming;
import Computers.Dell.DellOffice;
import Computers.Dell.DellPremium;
import Computers.Dell.DellUltrabook;
import Computers.Utils.ComputerType;

public class DellStore extends ComputerStore {

    Computer createComputer(Enum<ComputerType> computerType) {
        if (computerType.equals(ComputerType.OFFICE))
            return new DellOffice();
        else if (computerType.equals(ComputerType.ULTRABOOK))
            return new DellUltrabook();
        else if (computerType.equals(ComputerType.PREMIUM))
            return new DellPremium();
        else if (computerType.equals(ComputerType.GAMING))
            return new DellGaming();
        else return null;
    }
}
