package simpleBuilder.builder;

import simpleBuilder.model.Computer;

public abstract class ComputerBuilder {

    protected Computer computer;

    public Computer getComputer() {
        return this.computer;
    }

    public void createComputer() {
        this.computer = new Computer();
    }

    public abstract void buildName();
    public abstract void buildPrice();
    public abstract void buildBrand();
    public abstract void buildType();
}
