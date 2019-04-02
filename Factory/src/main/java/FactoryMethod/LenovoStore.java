package FactoryMethod;

import Computers.Computer;
import Computers.Lenovo.LenovoGaming;
import Computers.Lenovo.LenovoOffice;
import Computers.Lenovo.LenovoPremium;
import Computers.Lenovo.LenovoUltrabook;
import Computers.Utils.ComputerType;

public class LenovoStore extends ComputerStore {

    Computer createComputer(Enum<ComputerType> computerType) {
        if (computerType.equals(ComputerType.GAMING))
            return new LenovoGaming();
        else if (computerType.equals(ComputerType.PREMIUM))
            return new LenovoPremium();
        else if (computerType.equals(ComputerType.ULTRABOOK))
            return new LenovoUltrabook();
        else if (computerType.equals(ComputerType.OFFICE))
            return new LenovoOffice();
        else return null;
    }
}
