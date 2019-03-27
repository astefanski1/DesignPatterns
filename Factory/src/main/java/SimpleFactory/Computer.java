package SimpleFactory;

public abstract class Computer {

    protected String name;
    protected double price;
    protected String processor;
    protected String os;
    protected Integer ram;
    protected double weight;
    protected Enum brand;

    public String getName() {
        return name;
    }

    public Enum getBrand() {
        return brand;
    }

    public String toString() {
        StringBuilder display = new StringBuilder();
        display.append("---- " + name + " ---- \n");
        display.append("Price: " + price + "\n");
        display.append("Processor: " + processor + "\n");
        display.append("OS: " + os + "\n");
        display.append("RAM: " + ram + "GB\n");
        display.append("Weight: " + weight + "Kg\n");
        return display.toString();
    }
}