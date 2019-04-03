import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simpleBuilder.Utils.ComputerBrand;
import simpleBuilder.Utils.ComputerType;
import simpleBuilder.builder.PremiumComputerBuilder;
import simpleBuilder.builder.StandardComputerBuilder;
import simpleBuilder.model.Computer;
import simpleBuilder.store.ComputerStore;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleFluentBuilderTest {

    private ComputerStore computerStore = new ComputerStore();

    @BeforeEach
    void setUpTest() {
        System.out.println("////////////////////////////////////////////////////");
        System.out.println("////                   TEST                     ////");
        System.out.println("////////////////////////////////////////////////////");
    }


    @Test
    void shouldReturnPremiumComputer() {
        //when
        computerStore.setComputerBuilder(new PremiumComputerBuilder());
        computerStore.makeComputer();
        Computer premiumComputer = computerStore.getComputer();

        //then
        assertEquals(premiumComputer.getBrand(), ComputerBrand.APPLE);
        assertEquals(premiumComputer.getComputerType(), ComputerType.PREMIUM);
        assertEquals(premiumComputer.getPrice(), 300.0);

        System.out.println(premiumComputer);
    }

    @Test
    void shouldReturnStandardComputer() {
        //when
        computerStore.setComputerBuilder(new StandardComputerBuilder());
        computerStore.makeComputer();
        Computer standardComputer = computerStore.getComputer();

        //then
        assertEquals(standardComputer.getBrand(), ComputerBrand.ASUS);
        assertEquals(standardComputer.getComputerType(), ComputerType.OFFICE);
        assertEquals(standardComputer.getPrice(), 150.0);

        System.out.println(standardComputer);
    }
}
