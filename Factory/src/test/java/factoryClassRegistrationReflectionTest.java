import Computers.Apple.ApplePremium;
import Computers.Computer;
import Computers.Dell.DellUltrabook;
import Computers.Lenovo.LenovoGaming;
import Computers.Utils.ComputerBrand;
import Computers.Utils.ComputerType;
import factoryClassRegistrationReflection.ComputerFactory;
import factoryClassRegistrationReflection.ComputerShop;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class factoryClassRegistrationReflectionTest {

    private ComputerFactory computerFactory = ComputerFactory.getInstance();
    private ComputerShop computerShop = new ComputerShop(computerFactory);
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
        computerFactory.registerComputer(ComputerType.PREMIUM, ApplePremium.class);
        Computer computer = computerShop.makeComputer(ComputerType.PREMIUM);

        //then
        assertEquals(computer.getComputerType(), ComputerType.PREMIUM);
        assertEquals(computer.getBrand(), ComputerBrand.APPLE);

        getTestResults();
    }

    @Test
    void shouldReturnGamingComputer() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //when
        computerFactory.registerComputer(ComputerType.GAMING, LenovoGaming.class);
        Computer computer = computerShop.makeComputer(ComputerType.GAMING);

        //then
        assertEquals(computer.getComputerType(), ComputerType.GAMING);
        assertEquals(computer.getBrand(), ComputerBrand.LENOVO);

        getTestResults();
    }

    @Test
    void shouldReturnUltrabookComputer() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //when
        computerFactory.registerComputer(ComputerType.ULTRABOOK, DellUltrabook.class);
        Computer computer = computerShop.makeComputer(ComputerType.ULTRABOOK);

        //then
        assertEquals(computer.getComputerType(), ComputerType.ULTRABOOK);
        assertEquals(computer.getBrand(), ComputerBrand.DELL);

        getTestResults();
    }

    @Test
    void factoryTime() throws IOException, InterruptedException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //given
        Thread.sleep(5000);
        Computer computer;
        List<Computer> computers = new ArrayList<>();

        //when
        for (int i = 0; i < 1000; i++) {
            computerFactory.registerComputer(ComputerType.ULTRABOOK, DellUltrabook.class);
            computer = computerShop.makeComputer(ComputerType.ULTRABOOK);

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
