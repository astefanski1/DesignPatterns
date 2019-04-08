import Computers.Computer;
import Computers.Dell.DellUltrabook;
import Computers.Utils.ComputerBrand;
import Computers.Utils.ComputerType;
import FactoryMethod.DependentComputerStore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactoryMethodTest {

    private DependentComputerStore dependentComputerStore = DependentComputerStore.getInstance();
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
        Computer computer = dependentComputerStore.orderComputer(ComputerBrand.APPLE, ComputerType.PREMIUM);

        //then
        assertEquals(computer.getBrand(), ComputerBrand.APPLE);
        assertEquals(computer.getComputerType(), ComputerType.PREMIUM);

        getTestResults();
    }

    @Test
    void shouldReturnAsusOfficeComputer() {
        //when
        Computer computer = dependentComputerStore.orderComputer(ComputerBrand.ASUS, ComputerType.OFFICE);

        //then
        assertEquals(computer.getBrand(), ComputerBrand.ASUS);
        assertEquals(computer.getComputerType(), ComputerType.OFFICE);

        getTestResults();
    }

    @Test
    void shouldReturnDellGamingComputer() {
        //when
        Computer computer = dependentComputerStore.orderComputer(ComputerBrand.DELL, ComputerType.GAMING);

        //then
        assertEquals(computer.getBrand(), ComputerBrand.DELL);
        assertEquals(computer.getComputerType(), ComputerType.GAMING);

        getTestResults();
    }

    @Test
    void shouldReturnLenovoUltrabookComputer() {
        //when
        Computer computer = dependentComputerStore.orderComputer(ComputerBrand.LENOVO, ComputerType.ULTRABOOK);

        //then
        assertEquals(computer.getBrand(), ComputerBrand.LENOVO);
        assertEquals(computer.getComputerType(), ComputerType.ULTRABOOK);

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
            computer = dependentComputerStore.orderComputer(ComputerBrand.LENOVO, ComputerType.ULTRABOOK);

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
