import AbstractFactory.Computers.Computer;
import AbstractFactory.store.AppleComputerStore;
import AbstractFactory.store.DellComputerStore;
import AbstractFactory.store.LenovoComputerStore;
import Computers.Utils.ComputerBrand;
import Computers.Utils.ComputerType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbstractFactoryTest {

    private AppleComputerStore appleComputerStore = new AppleComputerStore();
    private DellComputerStore dellComputerStore = new DellComputerStore();
    private LenovoComputerStore lenovoComputerStore = new LenovoComputerStore();
    private Long testDuration, startTime, endTime;

    @BeforeAll
    static void setUpClass() throws InterruptedException, IOException {
        Thread.sleep(5000);

    }

    @BeforeEach
    void setUpTest() {
        System.out.println("////////////////////////////////////////////////////");
        System.out.println("////                   TEST                     ////");
        System.out.println("////////////////////////////////////////////////////");
        testDuration = 0L;
        startTime = System.nanoTime();
    }

    @Test
    void shouldReturnApplePremiumComputer() {
        //when
        Computer computer = appleComputerStore.orderComputer(ComputerType.PREMIUM);

        //then
        assertEquals(computer.getBrand(), ComputerBrand.APPLE);
        assertEquals(computer.getComputerType(), ComputerType.PREMIUM);

        getTestResults();
    }

    @Test
    void shouldReturnDellGamingComputer() {
        //when
        Computer computer = dellComputerStore.orderComputer(ComputerType.GAMING);

        //then
        assertEquals(computer.getBrand(), ComputerBrand.DELL);
        assertEquals(computer.getComputerType(), ComputerType.GAMING);

        getTestResults();
    }

    @Test
    void shouldReturnLenovoUltrabookComputer() {
        //when
        Computer computer = lenovoComputerStore.orderComputer(ComputerType.ULTRABOOK);
        Computer computer2 = lenovoComputerStore.orderComputer(ComputerType.ULTRABOOK);

        //then
        assertEquals(computer.getBrand(), ComputerBrand.LENOVO);
        assertEquals(computer.getComputerType(), ComputerType.ULTRABOOK);

        System.out.println(computer.hashCode());

        getTestResults();
    }

    @Test
    void factoryTime() throws IOException, InterruptedException {
        //given
        Thread.sleep(5000);
        Computer computer;
        List<Computer> computers = new ArrayList<>();

        //when
        for (int i = 0; i < 1000; i++) {
            computer = appleComputerStore.orderComputer(ComputerType.ULTRABOOK);

            computers.add(computer);
        }

        Long time = getTestDuration();
        System.out.println("\nTest time duration: " + time/1000 + " (micro seconds)");
    }

    private Long getTestDuration() {
        endTime = System.nanoTime();
        testDuration = TimeUnit.NANOSECONDS.toMicros(endTime - startTime);
        return testDuration;
    }

    private void getTestResults() {
        System.out.println("\nTest time duration: " + getTestDuration() + " (micro seconds)");
        System.out.println("Memory used for test: ");
    }
}
