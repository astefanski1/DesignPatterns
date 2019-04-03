package simpleBuilder.builder;

import simpleBuilder.Utils.ComputerBrand;
import simpleBuilder.Utils.ComputerType;

public class GamingComputerBuilder extends ComputerBuilder {

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
}
