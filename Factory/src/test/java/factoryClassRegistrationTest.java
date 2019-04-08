import Computers.Apple.ApplePremium;
import Computers.Lenovo.LenovoGaming;
import Computers.Lenovo.LenovoUltrabook;
import Computers.Utils.ComputerBrand;
import Computers.Utils.ComputerType;
import factoryClassRegistration.Computer;
import factoryClassRegistration.ComputerFactory;
import factoryClassRegistration.GamingComputer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class factoryClassRegistrationTest {

    private ComputerFactory computerFactory = ComputerFactory.getInstance();
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
    void shouldReturnPremiumComputer() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //when
        computerFactory.registerComputer(ComputerType.PREMIUM, GamingComputer::new);
        Computer computer = computerFactory.createComputer(ComputerType.PREMIUM);

        //then
        assertEquals(computer.getComputerType(), ComputerType.GAMING);
        assertEquals(computer.getBrand(), ComputerBrand.APPLE);

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
            computerFactory.registerComputer(ComputerType.PREMIUM, GamingComputer::new);
            computer = computerFactory.createComputer(ComputerType.PREMIUM);

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
