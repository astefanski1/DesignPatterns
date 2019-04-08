package simpleBuilder.store;

import simpleBuilder.builder.ComputerBuilder;
import simpleBuilder.model.Computer;

public class ComputerStore {

    public Computer buildComputer(ComputerBuilder computerBuilder) {
        computerBuilder.buildBrand();
        computerBuilder.buildName();
        computerBuilder.buildPrice();
        computerBuilder.buildType();

        return computerBuilder.getComputer();
    }
}