package fasterBuilder.factory;

import fasterBuilder.AirplaneBase;
import fasterBuilder.AirplaneBrand;

public class AirplaneFactory implements AirplaneAbstractFactory {

    private static AirplaneFactory airplaneFactory;

    private AirplaneFactory() {
    }

    public static AirplaneFactory getInstance() {
        if (airplaneFactory == null) {
            synchronized (AirplaneFactory.class) {
                if (airplaneFactory == null) {
                    airplaneFactory = new AirplaneFactory();
                }
            }
        }
        return airplaneFactory;
    }

    @Override
    public AirplaneBase createAirplane(AirplaneBrand airplaneBrand) {
        if (airplaneBrand.equals(AirplaneBrand.AIRBUS)) {
            return new Airbus();
        } else if (airplaneBrand.equals(AirplaneBrand.BOEING)) {
            return new Boeing();
        } else if (airplaneBrand.equals(AirplaneBrand.EMBRAER)) {
            return new Embraer();
        } else return null;
    }
}
