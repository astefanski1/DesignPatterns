package utils;

import model.Car;

import java.util.HashMap;
import java.util.Map;

public class CarFactory {

    Map<String, Car> cars = new HashMap<>();

    {
        cars.put("Astra",
                new Car.Builder()
                        .brand(CarBrand.OPEL)
                        .model("Astra")
                        .engine("Benzyna 1.8")
                        .productionYear("2018")
                        .weigth(2000)
                        .price(78000.00)
                        .numberOfSeats(5)
                        .build());

        cars.put("Insignia",
                new Car.Builder()
                        .brand(CarBrand.OPEL)
                        .model("Insignia")
                        .engine("Benzyna 2.0")
                        .productionYear("2019")
                        .weigth(2300)
                        .price(112000.00)
                        .numberOfSeats(5)
                        .build());

        cars.put("C200",
                new Car.Builder()
                        .brand(CarBrand.MERCEDES)
                        .model("C200")
                        .engine("Benzyna 2.4")
                        .productionYear("2019")
                        .weigth(2500)
                        .price(156000.00)
                        .numberOfSeats(5)
                        .build());
    }

    public Car getCarPrototype(String model) throws CloneNotSupportedException {
        return cars.get(model).clone();
    }
}
