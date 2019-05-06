package model;

import decorator.AbstractCar;
import utils.CarBrand;

public class Car extends AbstractCar implements Cloneable {
    private CarBrand brand;
    private String model;
    private String engine;
    private String productionYear;
    private double weight;
    private double price;
    private int numberOfSeats;
    private boolean isDamaged;
    private String id;
    private Customer customer;

    private Car(Builder builder) {
        this.id = builder.id;
        this.brand = builder.brand;
        this.model = builder.model;
        this.engine = builder.engine;
        this.productionYear = builder.productionYear;
        this.weight = builder.weigth;
        this.price = builder.price;
        this.numberOfSeats = builder.numberOfSeats;
        this.isDamaged = builder.isDamaged;
        this.customer = builder.customer;
    }

    @Override
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }

    public String getId() {
        return id;
    }

    public String getEngine() {
        return engine;
    }

    public double getWeight() {
        return weight;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDamaged(boolean damaged) {
        isDamaged = damaged;
    }

    public static class Builder {
        private String id;
        private CarBrand brand;
        private String model;
        private String engine;
        private String productionYear;
        private double weigth;
        private double price;
        private int numberOfSeats;
        private boolean isDamaged;
        private Customer customer;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder brand(CarBrand brand) {
            this.brand = brand;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder engine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder productionYear(String productionYear) {
            this.productionYear = productionYear;
            return this;
        }

        public Builder weigth(double weigth) {
            this.weigth = weigth;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder numberOfSeats(int numberOfSeats) {
            this.numberOfSeats = numberOfSeats;
            return this;
        }

        public Builder isDamaged(boolean isDamaged) {
            this.isDamaged = isDamaged;
            return this;
        }

        public Builder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Car build() {
            if (model.isEmpty()) {
                throw new IllegalStateException("Model cannot be empty");
            }

            return new Car(this);
        }
    }


    @Override
    public String toString() {
        return "---- " + brand.toString() + " ---- \n" +
                "ID: " + id + "\n" +
                "Model: " + model + "\n" +
                "Engine: " + engine + "\n" +
                "Production years: " + productionYear + "\n" +
                "Weigth: " + weight + " kg\n" +
                "Number of seats: " + numberOfSeats + " kg\n" +
                "Is damaged: " + isDamaged + "\n";
    }
}
