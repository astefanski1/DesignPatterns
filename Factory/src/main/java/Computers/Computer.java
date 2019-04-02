package Computers;

import java.util.ArrayList;

public abstract class Computer {

    protected String name;
    protected double price;
    protected String os;
    protected double weight;
    protected Enum brand;
    protected Enum computerType;
    protected ArrayList components = new ArrayList();

    public String getName() {
        return name;
    }

    public Enum getBrand() {
        return brand;
    }

    public Enum getComputerType() {
        return computerType;
    }

    public void orderAccepted() {
        System.out.println("Order accepted for " + name + " computer");
    }

    public void assembly() {
        System.out.println("Assembling " + name + " computer");
    }

    public void send() {
        System.out.println("Computer " + name + " is preparing to send ");
        System.out.println("Computer " + name + " sent ");
    }

    public String toString() {
        StringBuilder display = new StringBuilder();
        display.append("---- ").append(name).append(" ---- \n");
        display.append("Computer brand: ").append(brand.toString()).append("\n");
        display.append("Computer type: ").append(computerType.toString()).append("\n");
        display.append("Price: ").append(price).append("\n");
        display.append("OS: ").append(os).append("\n");
        display.append("Weight: ").append(weight).append("Kg\n");
        display.append("---- Components ----\n");
        components.forEach(component -> display.append(component.toString()).append("\n"));
        return display.toString();
    }
}