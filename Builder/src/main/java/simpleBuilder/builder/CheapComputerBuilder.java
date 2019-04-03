package simpleBuilder.builder;

import simpleBuilder.Utils.ComputerBrand;
import simpleBuilder.Utils.ComputerType;

public class CheapComputerBuilder extends ComputerBuilder {

    @Override
    public void buildName() {
        computer.setName("Lenovo x70");
    }

    @Override
    public void buildPrice() {
        computer.setPrice(100.0);
    }

    @Override
    public void buildBrand() {
        computer.setBrand(ComputerBrand.LENOVO);
    }

    @Override
    public void buildType() {
        computer.setComputerType(ComputerType.OFFICE);
    }
}
