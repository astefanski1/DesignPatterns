import SimpleFactory.Computer;
import SimpleFactory.ComputerBrands.ComputerBrands;
import SimpleFactory.ComputerStore;
import SimpleFactory.SimpleComputerFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleFactoryTest {

    private static ComputerStore computerStore;

    @BeforeAll
    static void setUpClass() {
        SimpleComputerFactory factory = SimpleComputerFactory.getInstance();
        computerStore = new ComputerStore(factory);
    }

    @BeforeEach
    void setUpTest() {
        System.out.println("////////////////////////////////////////////////////");
        System.out.println("////                   TEST                     ////");
        System.out.println("////////////////////////////////////////////////////");
    }


    @Test
    @DisplayName("AppleComputerTest")
    void shouldReturnAppleComputer() {

        //when
        Computer computer = computerStore.orderComputer(ComputerBrands.APPLE);
        System.out.println("We ordered a " + computer.getName() + "\n");

        //then
        System.out.println(computer.toString());
        assertEquals(computer.getBrand(), ComputerBrands.APPLE);
    }

    @Test
    @DisplayName("LenovoComputerTest")
    void shouldReturnLenovoComputer() {

        //when
        Computer computer = computerStore.orderComputer(ComputerBrands.LENOVO);
        System.out.println("We ordered a " + computer.getName() + "\n");

        //then
        System.out.println(computer.toString());
        assertEquals(computer.getBrand(), ComputerBrands.LENOVO);
    }

    @Test
    @DisplayName("AsusComputerTest")
    void shouldReturnAsusComputer() {

        //when
        Computer computer = computerStore.orderComputer(ComputerBrands.ASUS);
        System.out.println("We ordered a " + computer.getName() + "\n");

        //then
        System.out.println(computer.toString());
        assertEquals(computer.getBrand(), ComputerBrands.ASUS);
    }

    @Test
    @DisplayName("DellComputerTest")
    void shouldReturnDellComputer() {

        //when
        Computer computer = computerStore.orderComputer(ComputerBrands.DELL);
        System.out.println("We ordered a " + computer.getName() + "\n");

        //then
        System.out.println(computer.toString());
        assertEquals(computer.getBrand(), ComputerBrands.DELL);
    }
}