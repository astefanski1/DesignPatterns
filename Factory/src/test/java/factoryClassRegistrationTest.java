import Computers.Apple.AppleGaming;
import Computers.Apple.ApplePremium;
import Computers.Computer;
import Computers.Dell.DellUltrabook;
import Computers.Lenovo.LenovoGaming;
import Computers.Lenovo.LenovoUltrabook;
import Computers.Utils.ComputerBrand;
import Computers.Utils.ComputerType;
import factoryClassRegistration.ComputerFactory;
import factoryClassRegistration.NewComputer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class factoryClassRegistrationTest {

    private ComputerFactory computerFactory = ComputerFactory.getInstance();
    private Long testDuration, startTime, endTime;

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
        NewComputer computer = (NewComputer) computerFactory.createComputer(ComputerType.PREMIUM);

        //then
        assertEquals(computer.getComputerType(), ComputerType.PREMIUM);
        assertEquals(computer.getBrand(), ComputerBrand.APPLE);

        getTestResults();
    }

    @Test
    void shouldReturnGamingComputer() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //when
        computerFactory.registerComputer(ComputerType.GAMING, LenovoGaming.class);
        NewComputer computer = (NewComputer) computerFactory.createComputer(ComputerType.GAMING);

        //then
        assertEquals(computer.getComputerType(), ComputerType.GAMING);
        assertEquals(computer.getBrand(), ComputerBrand.LENOVO);

        getTestResults();
    }

    @Test
    void shouldReturnUltrabookComputer() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //when
        computerFactory.registerComputer(ComputerType.ULTRABOOK, LenovoUltrabook.class);
        NewComputer computer = (NewComputer) computerFactory.createComputer(ComputerType.ULTRABOOK);

        //then
        assertEquals(computer.getComputerType(), ComputerType.ULTRABOOK);
        assertEquals(computer.getBrand(), ComputerBrand.LENOVO);

        getTestResults();
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
