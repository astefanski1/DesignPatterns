package fasterBuilder.factory;

import fasterBuilder.AirplaneBrand;
import fasterBuilder.AirplaneBase;

public class Boeing extends AirplaneBase {

    public Boeing() {
        this.brand = AirplaneBrand.BOEING;
        this.model = "Boeing 777";
        this.engine = "Rolls-Royce Trent 800";
        this.numberOfAirplaneCrashes = 53;
        this.productionYear = "1969 - 2019";
        this.weigth = 154000.0;
    }
}
