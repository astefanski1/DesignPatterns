package fasterBuilder.builder;

import fasterBuilder.AirplaneBase;
import fasterBuilder.AirplaneBrand;

public class Airplane extends AirplaneBase {

    private Airplane(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.engine = builder.engine;
        this.productionYear = builder.productionYear;
        this.numberOfAirplaneCrashes = builder.numberOfAirplaneCrashes;
        this.weigth = builder.weigth;
    }

    public static class Builder {
        private AirplaneBrand brand;
        private String model;
        private String engine;
        private String productionYear;
        private Integer numberOfAirplaneCrashes;
        private double weigth;

        public Builder brand(AirplaneBrand brand) {
            this.brand = brand;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder engine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder productionYear(String productionYear) {
            this.productionYear = productionYear;
            return this;
        }

        public Builder numberOfAirplaneCrashes(Integer numberOfAirplaneCrashes) {
            this.numberOfAirplaneCrashes = numberOfAirplaneCrashes;
            return this;
        }

        public Builder weigth(double weigth) {
            this.weigth = weigth;
            return this;
        }

        public Airplane build() {
            if (model.isEmpty()) {
                throw new IllegalStateException("Model cannot be empty");
            }

            return new Airplane(this);
        }
    }
}
