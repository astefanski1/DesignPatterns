package fasterBuilder.factory;

import fasterBuilder.AirplaneBase;
import fasterBuilder.AirplaneBrand;

public class Airbus extends AirplaneBase {

    public Airbus() {
        this.brand = AirplaneBrand.AIRBUS;
        this.model = "Airbus A320";
        this.engine = "Rolls-Royce Trent 800";
        this.numberOfAirplaneCrashes = 23;
        this.productionYear = "1974 - 2019";
        this.weigth = 184000.0;
    }
}
