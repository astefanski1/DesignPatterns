package observer;

import model.Car;

import java.util.ArrayList;

public class CustomerNotification implements Subject {

    private ArrayList<Observer> customersSubscibers = new ArrayList<>();
    private Car car;

    @Override
    public void registerObserver(Observer observer) {
        customersSubscibers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        customersSubscibers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        customersSubscibers.forEach(Observer::update);
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
