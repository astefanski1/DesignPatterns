package FactoryMethod;

import Computers.Asus.AsusGaming;
import Computers.Asus.AsusOffice;
import Computers.Asus.AsusPremium;
import Computers.Asus.AsusUltraBook;
import Computers.Computer;
import Computers.Utils.ComputerType;

public class AsusStore extends ComputerStore {

    private static AsusStore asusStore;

    private AsusStore() {
    }

    public static AsusStore getInstance() {
        if (asusStore == null) {
            synchronized (AsusStore.class) {
                if (asusStore == null) {
                    asusStore = new AsusStore();
                }
            }
        }
        return asusStore;
    }

    Computer createComputer(Enum<ComputerType> computerType) {
        if (computerType.equals(ComputerType.GAMING))
            return new AsusGaming();
        else if (computerType.equals(ComputerType.PREMIUM))
            return new AsusPremium();
        else if (computerType.equals(ComputerType.ULTRABOOK))
            return new AsusUltraBook();
        else if (computerType.equals(ComputerType.OFFICE))
            return new AsusOffice();
        else return null;
    }
}
