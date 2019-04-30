package mediator;

import model.Worker;

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
}
