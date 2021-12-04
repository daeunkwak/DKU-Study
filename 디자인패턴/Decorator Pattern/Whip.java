package daeunkwak.decorator;

public class Whip extends Condiment{
    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return .30 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Whip";
    }
}

