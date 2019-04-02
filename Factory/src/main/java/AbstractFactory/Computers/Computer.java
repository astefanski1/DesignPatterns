package AbstractFactory.Computers;

import AbstractFactory.Parts.Processors.Processor;
import AbstractFactory.Parts.Rams.Ram;
import AbstractFactory.Parts.Storages.Storage;

public abstract class Computer {
    protected String name;
    protected double price;
    protected String os;
    protected double weight;
    protected Enum brand;
    protected Enum computerType;
    protected Processor processor;
    protected Ram ram;
    protected Storage storage;

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
        display.append("Processor: ").append(processor.getType());
        display.append("Ram: ").append(ram.getType());
        display.append("Storage: ").append(storage.getType());
        return display.toString();
    }

    public String getOs() {
        return os;
    }

    public String getName() {
        return name;
    }

    public Storage getStorage() {
        return storage;
    }

    public Ram getRam() {
        return ram;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Enum getComputerType() {
        return computerType;
    }

    public double getWeight() {
        return weight;
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

    public void setOs(String os) {
        this.os = os;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
