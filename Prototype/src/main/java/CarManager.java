import java.util.HashMap;
import java.util.Map;

public class CarManager {

    private Map<String, Car> cars = new HashMap<>();

    {
        cars.put("astra",
                new Car("astra")
                        .wheel(new Wheel(16))
                        .engine(new Engine(
                                new Type("Benzyna 1.6"))
                                .power(120)));

        cars.put("insignia",
                new Car("insignia")
                        .wheel(new Wheel(20))
                        .engine(new Engine(
                                new Type("Benzyna 2.0"))
                                .power(200)));

        cars.put("vectra",
                new Car("vectra")
                        .wheel(new Wheel(18))
                        .engine(new Engine(
                                new Type("Benzyna 2.0"))
                                .power(170)));
    }

    public Car getCarPrototype(String type) {
        return cars.get(type).clone();
    }

    public Car getCarShallowCopy(String type) {
        return cars.get(type).shallowCopy();
    }
}
