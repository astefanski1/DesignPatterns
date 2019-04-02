package AbstractFactory.Factory;

import AbstractFactory.Parts.Processors.Processor;
import AbstractFactory.Parts.Rams.Ram;
import AbstractFactory.Parts.Storages.Storage;

public interface PartsFactory {

    Processor createProcessor();
    Ram createRam();
    Storage createStorage();
}