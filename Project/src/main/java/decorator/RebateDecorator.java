package decorator;

public class RebateDecorator extends AbstractCarDecorator {
    private final int rebatePercent;

    public RebateDecorator(int rebatePercent, AbstractCar abstractCar) {
        super(abstractCar);
        this.rebatePercent = rebatePercent;
    }

    @Override
    public String toString() {
        StringBuilder display = new StringBuilder();
        display.append("---- ").append("REBATE").append(" ---- \n");
        display.append("Brand: ").append(carBrand).append("\n");
        display.append("Model: ").append(model).append("\n");
        display.append("Production year: ").append(productionYear).append("\n");
        return display.toString();
    }

    @Override
    public double getPrice() {
        int rebate = 100 - rebatePercent;
        return abstractCar.getPrice() * rebate / 100;
    }
}
