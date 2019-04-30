package model;

import mediator.Mediator;
import utils.WorkerType;

public class Worker {
    private String name;
    private Mediator mediator;
    private WorkerType workerType;

    public Worker(String name, Mediator mediator, WorkerType workerType) {
        this.name = name;
        this.workerType = workerType;
        this.mediator = mediator;
    }


    public void sendMessage(String message) {
        this.mediator.sendMessage("(" + name + ") " + message);
    }

    public void sendMessageAboutCar(Car car, String message) {
        if (workerType.equals(WorkerType.SALES)) {
            this.mediator.sendMessage("(" + name + ") " + "Car ready to fix problems: " + message + "\n" + car.getModel() + " (" + car.getId() + ")");
            car.setDamaged(true);
        } else if (workerType.equals(WorkerType.SERVICE)) {
            this.mediator.sendMessage("(" + name + ") " + "Car ready to pick up" + "\n" + car.getModel() + " (" + car.getId() + ")");
            car.setDamaged(false);
        }

    }

    public void receiveMessage(String message) {
        System.out.println(message);
    }
}
