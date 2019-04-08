import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simpleBuilder.Utils.ComputerBrand;
import simpleBuilder.Utils.ComputerType;
import simpleBuilder.builder.PremiumComputerBuilder;
import simpleBuilder.builder.StandardComputerBuilder;
import simpleBuilder.model.Computer;
import simpleBuilder.store.ComputerStore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class SimpleFluentBuilderTest {

    @BeforeEach
    void setUpTest() {
        System.out.println("////////////////////////////////////////////////////");
        System.out.println("////                   TEST                     ////");
        System.out.println("////////////////////////////////////////////////////");
    }


    @Test
    void shouldReturnPremiumComputer() {
        //given
        Computer premiumComputer;

        //when
        ComputerStore computerStore = new ComputerStore();
        premiumComputer = computerStore.buildComputer(new PremiumComputerBuilder());

        //then
        assertEquals(premiumComputer.getBrand(), ComputerBrand.APPLE);
        assertEquals(premiumComputer.getComputerType(), ComputerType.PREMIUM);
        assertEquals(premiumComputer.getPrice(), 300.0);

        System.out.println(premiumComputer);
    }

    @Test
    void shouldReturnTwoPremiumComputers() {
        //given
        Computer premiumComputer, premiumComputer2;

        //when
        ComputerStore computerStore = new ComputerStore();
        premiumComputer = computerStore.buildComputer(new PremiumComputerBuilder());
        premiumComputer2 = computerStore.buildComputer(new PremiumComputerBuilder());

        //then
        assertEquals(premiumComputer.getBrand(), ComputerBrand.APPLE);
        assertEquals(premiumComputer.getComputerType(), ComputerType.PREMIUM);
        assertEquals(premiumComputer.getPrice(), 300.0);
        assertNotSame(premiumComputer.hashCode(), 123123);

        System.out.println("Computer 1: " + premiumComputer.hashCode());
        System.out.println("Computer 2: " + premiumComputer2.hashCode());
    }

    @Test
    void shouldReturnStandardComputer() {
        //given
        Computer standardComputer;

        //when
        ComputerStore computerStore = new ComputerStore();
        standardComputer = computerStore.buildComputer(new StandardComputerBuilder());

        //then
        assertEquals(standardComputer.getBrand(), ComputerBrand.ASUS);
        assertEquals(standardComputer.getComputerType(), ComputerType.OFFICE);
        assertEquals(standardComputer.getPrice(), 150.0);

        System.out.println(standardComputer);
    }
}
