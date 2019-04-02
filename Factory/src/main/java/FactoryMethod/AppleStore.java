package FactoryMethod;

import Computers.Apple.AppleGaming;
import Computers.Apple.AppleOffice;
import Computers.Apple.ApplePremium;
import Computers.Apple.AppleUltrabook;
import Computers.Computer;
import Computers.Utils.ComputerType;

public class AppleStore extends ComputerStore {

    private static AppleStore appleStore;

    private AppleStore() {
    }

    public static AppleStore getInstance() {
        if (appleStore == null) {
            synchronized (AppleStore.class) {
                if (appleStore == null) {
                    appleStore = new AppleStore();
                }
            }
        }
        return appleStore;
    }

    Computer createComputer(Enum<ComputerType> computerType) {
        if (computerType.equals(ComputerType.GAMING))
            return new AppleGaming();
        else if (computerType.equals(ComputerType.PREMIUM))
            return new ApplePremium();
        else if (computerType.equals(ComputerType.OFFICE))
            return new AppleOffice();
        else if (computerType.equals(ComputerType.ULTRABOOK))
            return new AppleUltrabook();
        else return null;
    }
}
