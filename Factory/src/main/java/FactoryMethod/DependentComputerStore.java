package FactoryMethod;

import Computers.Computer;
import Computers.Utils.ComputerBrand;
import Computers.Utils.ComputerType;

public class DependentComputerStore {

    private static DependentComputerStore dependentComputerStore;
    private AppleStore appleStore = AppleStore.getInstance();
    private AsusStore asusStore = AsusStore.getInstance();
    private DellStore dellStore = DellStore.getInstance();
    private LenovoStore lenovoStore = LenovoStore.getInstance();

    public static DependentComputerStore getInstance() {
        if (dependentComputerStore == null) {
            synchronized (DependentComputerStore.class) {
                if (dependentComputerStore == null) {
                    dependentComputerStore = new DependentComputerStore();
                }
            }
        }
        return dependentComputerStore;
    }

    public Computer orderComputer(Enum<ComputerBrand> computerBrand, Enum<ComputerType> computerType) {
        System.out.println("Trying to order: " + computerBrand + " - " + computerType);
        System.out.println("---------------------------------------");
        if (computerBrand.equals(ComputerBrand.APPLE))
            return appleStore.orderComputer(computerType);
        else if (computerBrand.equals(ComputerBrand.ASUS))
            return asusStore.orderComputer(computerType);
        else if (computerBrand.equals(ComputerBrand.DELL))
            return dellStore.orderComputer(computerType);
        else if (computerBrand.equals(ComputerBrand.LENOVO))
            return lenovoStore.orderComputer(computerType);
        else return null;
    }
}
