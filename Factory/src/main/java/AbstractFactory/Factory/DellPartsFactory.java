package AbstractFactory.Factory;

import AbstractFactory.Parts.Processors.Processor;
import AbstractFactory.Parts.Processors.i3;
import AbstractFactory.Parts.Rams.HyperX4;
import AbstractFactory.Parts.Rams.Ram;
import AbstractFactory.Parts.Storages.Storage;
import AbstractFactory.Parts.Storages.WD250;

public class DellPartsFactory implements PartsFactory {

    private static DellPartsFactory dellPartsFactory;

    private DellPartsFactory() {
    }

    public static DellPartsFactory getInstance() {
        if (dellPartsFactory == null) {
            synchronized (DellPartsFactory.class) {
                if (dellPartsFactory == null) {
                    dellPartsFactory = new DellPartsFactory();
                }
            }
        }
        return dellPartsFactory;
    }

    @Override
    public Processor createProcessor() {
        return new i3();
    }

    @Override
    public Ram createRam() {
        return new HyperX4();
    }

    @Override
    public Storage createStorage() {
        return new WD250();
    }
}
