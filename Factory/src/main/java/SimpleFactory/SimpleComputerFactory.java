package SimpleFactory;

import SimpleFactory.ComputerBrands.AppleComputer;
import SimpleFactory.ComputerBrands.AsusComputer;
import SimpleFactory.ComputerBrands.ComputerBrands;
import SimpleFactory.ComputerBrands.DellComputer;
import SimpleFactory.ComputerBrands.LenovoComputer;

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
            computer = new AppleComputer();
        } else if (brand.equals(ComputerBrands.DELL)) {
            computer = new DellComputer();
        } else if (brand.equals(ComputerBrands.LENOVO)) {
            computer = new LenovoComputer();
        } else if (brand.equals(ComputerBrands.ASUS)) {
            computer = new AsusComputer();
        }
        return computer;
    }
}
