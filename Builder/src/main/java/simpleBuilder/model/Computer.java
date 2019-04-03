package simpleBuilder.model;

public class Computer {
    private String name;
    private double price;
    private Enum brand;
    private Enum computerType;

    public Computer() {
    }

    public Computer(String name, double price, Enum brand, Enum computerType) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.computerType = computerType;
    }

    public String getName() {
        return name;
    }

    public Enum getComputerType() {
        return computerType;
    }

    public double getPrice() {
        return price;
    }

    public Enum getBrand() {
        return brand;
    }

    public void setComputerType(Enum computerType) {
        this.computerType = computerType;
    }

    public void setBrand(Enum brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder display = new StringBuilder();
        display.append("---- ").append(name).append(" ---- \n");
        display.append("Computer brand: ").append(brand.toString()).append("\n");
        display.append("Computer type: ").append(computerType.toString()).append("\n");
        display.append("Price: ").append(price).append("\n");
        return display.toString();
    }
}