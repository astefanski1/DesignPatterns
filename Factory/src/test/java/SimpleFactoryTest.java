import Computers.Computer;
import Computers.Utils.ComputerBrand;
import Computers.ComputerStore;
import Computers.Utils.ComputerType;
import SimpleFactory.SimpleComputerFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleFactoryTest {

    private static ComputerStore computerStore;
    private Long testDuration, startTime, endTime;

    @BeforeAll
    static void setUpClass() throws InterruptedException {
        SimpleComputerFactory factory = SimpleComputerFactory.getInstance();
        computerStore = new ComputerStore(factory);
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
    @DisplayName("AppleComputerTest")
    void shouldReturnAppleComputer() {

        //when
        Computer computer = computerStore.orderComputer(ComputerBrand.APPLE);
        System.out.println("We ordered a " + computer.getName() + "\n");

        //then
        System.out.println(computer.toString());
        assertEquals(computer.getBrand(), ComputerBrand.APPLE);

        getTestResults(computer);
    }

    @Test
    @DisplayName("LenovoComputerTest")
    void shouldReturnLenovoComputer() {

        //when
        Computer computer = computerStore.orderComputer(ComputerBrand.LENOVO);
        System.out.println("We ordered a " + computer.getName() + "\n");

        //then
        System.out.println(computer.toString());
        assertEquals(computer.getBrand(), ComputerBrand.LENOVO);

        getTestResults(computer);
    }

    @Test
    @DisplayName("AsusComputerTest")
    void shouldReturnAsusComputer() {

        //when
        Computer computer = computerStore.orderComputer(ComputerBrand.ASUS);
        System.out.println("We ordered a " + computer.getName() + "\n");

        //then
        System.out.println(computer.toString());
        assertEquals(computer.getBrand(), ComputerBrand.ASUS);

        getTestResults(computer);
    }

    @Test
    @DisplayName("DellComputerTest")
    void shouldReturnDellComputer() {

        //when
        Computer computer = computerStore.orderComputer(ComputerBrand.DELL);
        System.out.println("We ordered a " + computer.getName() + "\n");

        //then
        System.out.println(computer.toString());
        assertEquals(computer.getBrand(), ComputerBrand.DELL);

        getTestResults(computer);
    }

    @Test
    void factoryTime() throws IOException, InterruptedException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //given
        Thread.sleep(5000);
        Computer computer;
        List<Computer> computers = new ArrayList<>();

        //when
        for (int i = 0; i < 1000; i++) {
            computer = computerStore.orderComputer(ComputerBrand.DELL);

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

    private void getTestResults(Computer computer) {
        System.out.println("\nTest time duration: " + getTestDuration() + " (micro seconds)");
    }
}