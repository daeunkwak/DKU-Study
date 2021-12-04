package daeunkwak.decorator;

public class Milk extends Condiment{
    // 생성자 -> Beverage에 있었던 객체 반환하도록
    public Milk(Beverage beverage){
        // 부모로부터 상속받은 beverage에 대입
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " + Milk";
        // Houseblend Milk 출력
    }
}
