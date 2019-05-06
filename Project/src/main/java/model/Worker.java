package model;

import mediator.Mediator;
import observer.Observer;
import observer.WorkerNotification;
import utils.WorkerType;

public class Worker implements Observer {
    private String name;
    private Mediator mediator;
    private WorkerType workerType;
    private Car lastCarServiced;
    private WorkerNotification workerNotification;

    private static final String message = "Hi %s, new car to repair: \n%s";

    public Worker(String name, Mediator mediator, WorkerType workerType, WorkerNotification workerNotification) {
        this.name = name;
        this.workerType = workerType;
        this.mediator = mediator;
        this.workerNotification = workerNotification;
    }

    public Worker(String name, WorkerType workerType) {
        this.name = name;
        this.workerType = workerType;
    }

    public String getName() {
        return name;
    }

    public WorkerType getWorkerType() {
        return workerType;
    }

    public void receiveMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void update() {
        lastCarServiced = workerNotification.getCar();
        System.out.println(String.format(message, name, lastCarServiced));
    }
}
