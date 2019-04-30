package decorator;

import utils.CarBrand;

public abstract class AbstractCar {
    public CarBrand carBrand;
    public String model;
    public String productionYear;

    public abstract double getPrice();
}
