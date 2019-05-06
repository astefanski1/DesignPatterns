package mediator;

import model.Car;
import model.Worker;
import utils.WorkerType;

import java.util.ArrayList;

public class InformationHub implements Mediator {

    private ArrayList<Worker> workers = new ArrayList<>();

    public void workerLogIn(Worker worker) {
        workers.add(worker);
    }

    public void workerLogOut(Worker worker) {
        try {
            workers.remove(worker);
        } catch (Exception e) {
            System.out.println("Worker is already logged out.");
        }
    }

    @Override
    public void sendMessage(String message) {
        workers.forEach(worker -> worker.receiveMessage(message));
    }

    public void createMessage(String message, Worker worker) {
        sendMessage("(" + worker.getName() + ") " + message);
    }

    public void sendMessageAboutCar(Car car, String message, Worker worker) {
        if (worker.getWorkerType().equals(WorkerType.SALES)) {
            sendMessage("(" + worker.getName() + ") " + "Car ready to fix problems: " + message + " " + car.getModel() + " (" + car.getId() + ")");
            car.setDamaged(true);
        } else if (worker.getWorkerType().equals(WorkerType.SERVICE)) {
            sendMessage("(" + worker.getName() + ") " + "Car ready to pick up " + car.getModel() + " (" + car.getId() + ")");
            car.setDamaged(false);
        }

    }
}
