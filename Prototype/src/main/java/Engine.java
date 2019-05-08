public class Engine implements Cloneable {

    private Type type;
    private int power;

    public Engine(Type type) {
        this.type = type;
    }

    public Engine power(int power) {
        this.power = power;
        return this;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    protected Engine clone() {
        try {
            Engine engine = (Engine) super.clone();
            engine.type = type.clone();
            return engine;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "[Engine] type: " + type + "\n" + "power: " + power + "hp";
    }
}
