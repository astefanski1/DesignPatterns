public class Car implements Cloneable {
    private String type;
    private Wheel wheel;
    private Engine engine;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Car (String type) {
        this.type = type;
    }

    public Car wheel(Wheel wheel) {
        this.wheel = wheel;
        return this;
    }

    public Car engine(Engine engine) {
        this.engine = engine;
        return this;
    }

    @Override
    protected Car clone() {
        try {
            Car car = (Car) super.clone();
            car.wheel = wheel.clone();
            car.engine = engine.clone();
            return car;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Car shallowCopy() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "[Car] type: " + type + "\n"
                +"wheel: " + wheel + "\n"
                +"engine: " + engine;
    }
}
