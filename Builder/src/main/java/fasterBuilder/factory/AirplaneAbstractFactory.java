package fasterBuilder.factory;

import fasterBuilder.AirplaneBase;
import fasterBuilder.AirplaneBrand;

public interface AirplaneAbstractFactory {
    AirplaneBase createAirplane(AirplaneBrand airplaneBrand);
}
