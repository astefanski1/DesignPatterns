import decorator.AbstractCar;
import decorator.RebateDecorator;
import facade.CustomerBonuses;
import mediator.InformationHub;
import model.Car;
import model.Customer;
import model.Worker;
import observer.WorkerNotification;
import org.junit.jupiter.api.Test;
import utils.CarBrand;
import utils.CarFactory;
import utils.CustomerType;
import utils.WorkerType;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectTest {

    private CarFactory carFactory = new CarFactory();
    private CustomerBonuses customerBonuses = new CustomerBonuses();
    private WorkerNotification workerNotification = new WorkerNotification();
    private InformationHub informationHub = new InformationHub();

    private Car astra = carFactory.getCarPrototype("Astra");
    private Car insignia = carFactory.getCarPrototype("Insignia");
    private Car C200 = carFactory.getCarPrototype("C200");

    private Worker salesMan = new Worker("Alex", informationHub, WorkerType.SALES, workerNotification);
    private Worker salesMan2 = new Worker("Matthew", informationHub, WorkerType.SALES, workerNotification);
    private Worker serviceMan = new Worker("Peter", informationHub, WorkerType.SERVICE, workerNotification);
    private Worker serviceMan2 = new Worker("Andrew", informationHub, WorkerType.SERVICE, workerNotification);

    @Test
    void builderTest() {
        assertEquals(astra.getBrand(), CarBrand.OPEL);
        assertEquals(astra.getModel(), "Astra");
        assertEquals(astra.getPrice(), 78000.00);
        assertEquals(astra.getEngine(), "Benzyna 1.8");
        assertEquals(astra.getProductionYear(), "2018");
        assertEquals(astra.getWeight(), 2000);
        assertEquals(astra.getNumberOfSeats(), 5);

        System.out.println(astra);
    }

    @Test
    void prototypeTest() {
        Car astra2 = carFactory.getCarPrototype("Astra");

        assertNotSame(astra, astra2);

        astra.setDamaged(true);

        System.out.println(astra);
        System.out.println(astra2);
    }

    @Test
    void facadeTest() {
        Customer customer = new Customer.Builder()
                .name("Alex")
                .numberOfCarsBought(0)
                .customerType(CustomerType.NEW)
                .rebateAllowed(false)
                .bankApproved(false)
                .build();

        Customer customer2 = new Customer.Builder()
                .name("Matthew")
                .numberOfCarsBought(2)
                .customerType(CustomerType.BUISNESS)
                .rebateAllowed(true)
                .bankApproved(false)
                .build();

        assertEquals(customer.isBankApproved(), false);
        assertEquals(customer.isRebateAllowed(), false);

        assertEquals(customer2.isBankApproved(), false);
        assertEquals(customer2.isRebateAllowed(), true);

        System.out.println(customer);
        assertEquals(customerBonuses.isRabateAllowed(customer), false);
        assertEquals(customerBonuses.isLeasingAllowed(customer), false);

        System.out.println(customer2);
        assertEquals(customerBonuses.isRabateAllowed(customer2), true);
        assertEquals(customerBonuses.isLeasingAllowed(customer2), false);
    }

    @Test
    void decoratorTest() {
        AbstractCar astraRebate = new RebateDecorator(20, astra);

        assertNotEquals(astraRebate.getPrice(), astra.getPrice());

        System.out.println(astraRebate.getPrice());
        System.out.println(astra.getPrice());
    }

    @Test
    void mediatorTest() {
        astra.setId("GA 77005");
        informationHub.workerLogIn(salesMan);
        informationHub.workerLogIn(salesMan2);
        informationHub.workerLogIn(serviceMan);

        informationHub.createMessage("New car arrived, go check the parking", salesMan);

        informationHub.sendMessageAboutCar(astra, "Propably engine is to repair!", salesMan);

        informationHub.sendMessageAboutCar(astra, "Engine is fixed!", serviceMan);

        informationHub.workerLogOut(salesMan);
        informationHub.workerLogOut(serviceMan);

        informationHub.createMessage("New message", salesMan);
    }

    @Test
    void observerTest() {
        workerNotification.registerObserver(serviceMan);
        workerNotification.registerObserver(serviceMan2);

        workerNotification.setCar(astra);
        workerNotification.notifyObservers();

        workerNotification.registerObserver(salesMan);

        workerNotification.setCar(insignia);
        workerNotification.notifyObservers();

        workerNotification.unregisterObserver(salesMan);

        workerNotification.setCar(C200);
        workerNotification.notifyObservers();
    }
}