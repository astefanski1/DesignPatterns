package AbstractFactory.Factory;

import AbstractFactory.Parts.Processors.Processor;
import AbstractFactory.Parts.Processors.i5;
import AbstractFactory.Parts.Rams.HypeX8;
import AbstractFactory.Parts.Rams.Ram;
import AbstractFactory.Parts.Storages.Storage;
import AbstractFactory.Parts.Storages.WD500;

public class LenovoPartsFactory implements PartsFactory {

    private static LenovoPartsFactory lenovoPartsFactory;

    private LenovoPartsFactory() {
    }

    public static LenovoPartsFactory getInstance() {
        if (lenovoPartsFactory == null) {
            synchronized (LenovoPartsFactory.class) {
                if (lenovoPartsFactory == null) {
                    lenovoPartsFactory = new LenovoPartsFactory();
                }
            }
        }
        return lenovoPartsFactory;
    }

    @Override
    public Processor createProcessor() {
        return new i5();
    }

    @Override
    public Ram createRam() {
        return new HypeX8();
    }

    @Override
    public Storage createStorage() {
        return new WD500();
    }
}
