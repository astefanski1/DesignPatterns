package fasterBuilder;

public class AirplaneBase {
    public AirplaneBrand brand;
    public String model;
    public String engine;
    public String productionYear;
    public Integer numberOfAirplaneCrashes;
    public double weigth;


    @Override
    public String toString() {
        StringBuilder display = new StringBuilder();
        display.append("---- ").append(brand.toString()).append(" ---- \n");
        display.append("Model: ").append(model).append("\n");
        display.append("Engine: ").append(engine).append("\n");
        display.append("Production years: ").append(productionYear).append("\n");
        display.append("Number of airplane crashes: ").append(numberOfAirplaneCrashes).append("\n");
        display.append("Weigth: ").append(weigth).append(" kg\n");
        return display.toString();
    }
}