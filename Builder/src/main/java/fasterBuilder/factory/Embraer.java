package fasterBuilder.factory;

import fasterBuilder.AirplaneBase;
import fasterBuilder.AirplaneBrand;

public class Embraer extends AirplaneBase {

    public Embraer() {
        this.brand = AirplaneBrand.EMBRAER;
        this.model = "Embraer 190";
        this.engine = "Rolls-Royce Trent 800";
        this.numberOfAirplaneCrashes = 100;
        this.productionYear = "1970 - 2001";
        this.weigth = 160000.0;
    }
}
