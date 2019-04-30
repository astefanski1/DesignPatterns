package decorator;

public abstract class AbstractCarDecorator extends AbstractCar {

    protected AbstractCar abstractCar;

    public AbstractCarDecorator(AbstractCar abstractCar) {
        this.abstractCar = abstractCar;
    }
}
