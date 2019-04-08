package simpleBuilder.builder;

import simpleBuilder.Utils.ComputerBrand;
import simpleBuilder.Utils.ComputerType;
import simpleBuilder.model.Computer;

public class PremiumComputerBuilder implements ComputerBuilder {

    Computer computer;

    public PremiumComputerBuilder() {
        this.computer = new Computer();
        computer.setComputerType(ComputerType.OFFICE);
    }

    public void buildName() {
        computer.setName("Apple MacBook Pro");
    }


    public void buildPrice() {
        computer.setPrice(300.0);
    }


    public void buildBrand() {
        computer.setBrand(ComputerBrand.APPLE);
    }


    public void buildType() {
        computer.setComputerType(ComputerType.PREMIUM);
    }


    public Computer getComputer() {
        return this.computer;
    }
}
