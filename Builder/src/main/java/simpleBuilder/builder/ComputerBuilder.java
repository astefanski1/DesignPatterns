package simpleBuilder.builder;

import simpleBuilder.model.Computer;

public interface ComputerBuilder {
    void buildName();
    void buildPrice();
    void buildBrand();
    void buildType();
    public Computer getComputer();
}
