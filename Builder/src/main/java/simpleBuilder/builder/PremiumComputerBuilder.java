package simpleBuilder.builder;

import simpleBuilder.Utils.ComputerBrand;
import simpleBuilder.Utils.ComputerType;

public class PremiumComputerBuilder extends ComputerBuilder {

    @Override
    public void buildName() {
        computer.setName("Apple MacBook Pro");
    }

    @Override
    public void buildPrice() {
        computer.setPrice(300.0);
    }

    @Override
    public void buildBrand() {
        computer.setBrand(ComputerBrand.APPLE);
    }

    @Override
    public void buildType() {
        computer.setComputerType(ComputerType.PREMIUM);
    }
}
