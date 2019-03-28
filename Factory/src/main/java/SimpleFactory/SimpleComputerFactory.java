package SimpleFactory;

import Computers.Apple.AppleOffice;
import Computers.Asus.AsusOffice;
import Computers.Computer;
import Computers.Dell.DellOffice;
import Computers.Lenovo.LenovoOffice;
import Computers.Utils.ComputerBrands;

public class SimpleComputerFactory {

    private static SimpleComputerFactory simpleComputerFactory;

    public static SimpleComputerFactory getInstance() {
        if (simpleComputerFactory == null) {
            synchronized (SimpleComputerFactory.class) {
                if (simpleComputerFactory == null) {
                    simpleComputerFactory = new SimpleComputerFactory();
                }
            }
        }
        return simpleComputerFactory;
    }

    public Computer createComputer(Enum brand) {
        Computer computer = null;

        if (brand.equals(ComputerBrands.APPLE)) {
            computer = new AppleOffice();
        } else if (brand.equals(ComputerBrands.DELL)) {
            computer = new DellOffice();
        } else if (brand.equals(ComputerBrands.LENOVO)) {
            computer = new LenovoOffice();
        } else if (brand.equals(ComputerBrands.ASUS)) {
            computer = new AsusOffice();
        }
        return computer;
    }
}
