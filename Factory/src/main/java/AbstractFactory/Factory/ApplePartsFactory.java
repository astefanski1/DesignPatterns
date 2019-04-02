package AbstractFactory.Factory;

import AbstractFactory.Parts.Processors.Processor;
import AbstractFactory.Parts.Processors.i7;
import AbstractFactory.Parts.Rams.HyperX16;
import AbstractFactory.Parts.Rams.Ram;
import AbstractFactory.Parts.Storages.Storage;
import AbstractFactory.Parts.Storages.WD1000;

public class ApplePartsFactory implements PartsFactory {

    private static ApplePartsFactory applePartsFactory;

    private ApplePartsFactory() {
    }

    public static ApplePartsFactory getInstance() {
        if (applePartsFactory == null) {
            synchronized (ApplePartsFactory.class) {
                if (applePartsFactory == null) {
                    applePartsFactory = new ApplePartsFactory();
                }
            }
        }
        return applePartsFactory;
    }

    @Override
    public Processor createProcessor() {
        return new i7();
    }

    @Override
    public Ram createRam() {
        return new HyperX16();
    }

    @Override
    public Storage createStorage() {
        return new WD1000();
    }
}
