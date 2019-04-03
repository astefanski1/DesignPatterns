package simpleBuilder.store;

import simpleBuilder.builder.ComputerBuilder;
import simpleBuilder.model.Computer;

public class ComputerStore {

    private ComputerBuilder computerBuilder;

    public void setComputerBuilder(ComputerBuilder builder) {
        this.computerBuilder = builder;
    }

    public Computer getComputer() {
        return computerBuilder.getComputer();
    }

    public void makeComputer() {
        computerBuilder.createComputer();
        computerBuilder.buildBrand();
        computerBuilder.buildName();
        computerBuilder.buildPrice();
        computerBuilder.buildType();
    }
}
