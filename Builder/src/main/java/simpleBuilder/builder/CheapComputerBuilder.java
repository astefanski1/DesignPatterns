package simpleBuilder.builder;

import simpleBuilder.Utils.ComputerBrand;
import simpleBuilder.Utils.ComputerType;
import simpleBuilder.model.Computer;

public class CheapComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public CheapComputerBuilder() {
        this.computer = new Computer();
        computer.setComputerType(ComputerType.OFFICE);
    }


    public void buildName() {
        computer.setName("Lenovo x70");
    }


    public void buildPrice() {
        computer.setPrice(100.0);
    }


    public void buildBrand() {
        computer.setBrand(ComputerBrand.LENOVO);
    }


    public void buildType() {
        computer.setComputerType(ComputerType.OFFICE);
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }


}
