package simpleBuilder.builder;

import simpleBuilder.Utils.ComputerBrand;
import simpleBuilder.Utils.ComputerType;

public class StandardComputerBuilder extends ComputerBuilder {

    @Override
    public void buildName() {
        computer.setName("Asus X300");
    }

    @Override
    public void buildPrice() {
        computer.setPrice(150.0);
    }

    @Override
    public void buildBrand() {
        computer.setBrand(ComputerBrand.ASUS);
    }

    @Override
    public void buildType() {
        computer.setComputerType(ComputerType.OFFICE);
    }
}
