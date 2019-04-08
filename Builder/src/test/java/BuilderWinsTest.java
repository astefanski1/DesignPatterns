import fasterBuilder.AirplaneBase;
import fasterBuilder.AirplaneBrand;
import fasterBuilder.builder.Airplane;
import fasterBuilder.factory.AirplaneFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuilderWinsTest {

    private Long testDuration;
    private Long startTime;

    @BeforeEach
    void setUpTest() {
        System.out.println("////////////////////////////////////////////////////");
        System.out.println("////                   TEST                     ////");
        System.out.println("////////////////////////////////////////////////////");
        testDuration = 0L;
        startTime = System.nanoTime();
    }


    @Test
    void shouldReturnAirplaneFromBuilder() {
        //when
        AirplaneBase boeing = new Airplane.Builder()
                .brand(AirplaneBrand.BOEING)
                .model("Boeing 777")
                .engine("Rolce Royce 800")
                .numberOfAirplaneCrashes(33)
                .productionYear("1960 - 2001")
                .weigth(1800000.0)
                .build();
        //then
        assertEquals(boeing.brand, AirplaneBrand.BOEING);
        assertEquals(boeing.model, "Boeing 777");

        System.out.println(boeing);
    }

    @Test
    void shouldReturnAirplaneFromFactory() {
        //given
        AirplaneFactory airplaneFactory = AirplaneFactory.getInstance();

        //when
        AirplaneBase boeing = airplaneFactory.createAirplane(AirplaneBrand.BOEING);

        //then
        assertEquals(boeing.brand, AirplaneBrand.BOEING);
        assertEquals(boeing.model, "Boeing 777");

        System.out.println(boeing);
    }

    @Test
    void builderTimeReturn() {
        //given
        AirplaneBase boeing;
        List<AirplaneBase> airplanes = new ArrayList<>();

        //when
        for (int i = 0; i < 1000; i++) {
            boeing = new Airplane.Builder()
                    .brand(AirplaneBrand.BOEING)
                    .model("Boeing 777")
                    .engine("Rolce Royce 800")
                    .numberOfAirplaneCrashes(33)
                    .productionYear("1960 - 2001")
                    .weigth(1800000.0)
                    .build();
            airplanes.add(boeing);
        }

        //then
        assertEquals(airplanes.get(0).brand, AirplaneBrand.BOEING);
        assertEquals(airplanes.get(0).model, "Boeing 777");
        assertEquals(airplanes.size(), 1000);

        getTestResults();
    }

    @Test
    void factoryTimeReturn() {
        //given
        AirplaneBase boeing;
        List<AirplaneBase> airplanes = new ArrayList<>();
        AirplaneFactory airplaneFactory = AirplaneFactory.getInstance();

        //when
        for (int i = 0; i < 1000; i++) {
            boeing = airplaneFactory.createAirplane(AirplaneBrand.BOEING);
            airplanes.add(boeing);
        }


        //then
        assertEquals(airplanes.get(0).brand, AirplaneBrand.BOEING);
        assertEquals(airplanes.get(0).model, "Boeing 777");
        assertEquals(airplanes.size(), 1000);

        getTestResults();
    }

    private Long getTestDuration() {
        Long endTime = System.nanoTime();
        testDuration = TimeUnit.NANOSECONDS.toMicros(endTime - startTime);
        return testDuration;
    }

    private void getTestResults() {
        System.out.println("\nTime duration to get object: " + getTestDuration()/1000 + " (micro seconds)");
    }
}