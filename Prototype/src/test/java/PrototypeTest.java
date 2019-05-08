import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

public class PrototypeTest {

    private CarManager carManager = new CarManager();

    @Test
    void deepClonePrototype() {
        Car car1 = carManager.getCarPrototype("astra");
        Car car2 = carManager.getCarPrototype("astra");

        System.out.println("---- DEEP CLONE ----");
        System.out.println("Car 1: " + car1);
        System.out.println("Car 2: " + car2);

        System.out.println("\nCar 1 hashcode: " + car1.hashCode());
        System.out.println("Car 2 hashcode: " + car2.hashCode() + "\n");

        assertNotSame(car1, car2);
        assertNotSame(car1.getEngine(), car2.getEngine());
        assertNotSame(car1.getWheel(), car2.getWheel());
        assertNotSame(car1.getEngine().getType(), car2.getEngine().getType());
        assertNotSame(car1.hashCode(), car2.hashCode());

        car1.getEngine().setPower(300);
        car1.getEngine().getType().setName("Diesel");
        car1.getWheel().setSize(22);
        car1.setType("SPORT");

        System.out.println("Car 1: " + car1);
        System.out.println("Car 2: " + car2);
    }

    @Test
    void shallowCopyPrototype() {
        Car car1 = carManager.getCarShallowCopy("astra");
        Car car2 = carManager.getCarShallowCopy("astra");

        System.out.println("---- DEEP CLONE ----");
        System.out.println("Car 1: " + car1);
        System.out.println("Car 2: " + car2);

        System.out.println("\nCar 1 hashcode: " + car1.hashCode());
        System.out.println("Car 2 hashcode: " + car2.hashCode() + "\n");

        assertNotSame(car1, car2);
        assertSame(car1.getEngine(), car2.getEngine());
        assertSame(car1.getWheel(), car2.getWheel());
        assertSame(car1.getEngine().getType(), car2.getEngine().getType());
        assertNotSame(car1.hashCode(), car2.hashCode());

        car1.getEngine().setPower(300);
        car1.getEngine().getType().setName("Diesel");
        car1.getWheel().setSize(22);
        car1.setType("SPORT");

        System.out.println("Car 1: " + car1);
        System.out.println("Car 2: " + car2);
    }
}
