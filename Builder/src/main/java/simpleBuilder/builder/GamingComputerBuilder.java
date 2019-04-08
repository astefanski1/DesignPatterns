package simpleBuilder.builder;

import simpleBuilder.Utils.ComputerBrand;
import simpleBuilder.Utils.ComputerType;
import simpleBuilder.model.Computer;

public class GamingComputerBuilder implements ComputerBuilder {

    Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
        computer.setComputerType(ComputerType.OFFICE);
    }

    @Override
    public void buildName() {
        computer.setName("Dell Enigma");
    }

    @Override
    public void buildPrice() {
        computer.setPrice(500.0);
    }

    @Override
    public void buildBrand() {
        computer.setBrand(ComputerBrand.DELL);
    }

    @Override
    public void buildType() {
        computer.setComputerType(ComputerType.GAMING);
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}
