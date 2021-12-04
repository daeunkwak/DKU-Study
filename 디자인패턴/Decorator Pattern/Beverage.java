package daeunkwak.decorator;

public abstract class Beverage {
    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    // 하위 클래스에서 cost를 꼭 구현하라라
   public abstract double cost();
}

// ConcreteComponent 4개가 있는 상황
class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    @Override
    public double cost() {
        return .99;
    }
}

class Decaf extends Beverage {
    public Decaf() {
        description = "Decaf Coffee";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}

class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}

class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}

class Main {
    public static void main(String[] args) {
        Beverage myBeverage = new HouseBlend();
        myBeverage = new Milk(myBeverage);
        // myBeverage를 감싸고있는 Milk에다 houseblend를 link
        // houseblend가 들어있는 Milk가 된다. 89 -> 99 cent,
        // Milk class의 getDescription을 받아서 Null (description사라짐)
        System.out.println(myBeverage.getDescription() + " $" + myBeverage.cost());

        // Open Close Principal을 매우 잘 지키는중
        Beverage yourBeverage = new DarkRoast();
        yourBeverage = new Mocha(yourBeverage);
        yourBeverage = new Whip(yourBeverage);
        System.out.println(yourBeverage.getDescription() + " $" + yourBeverage.cost());

        Beverage hisBeverage = new Tea();
        hisBeverage = new Soy(hisBeverage);
        System.out.println(hisBeverage.getDescription() + " $" + hisBeverage.cost());

        Beverage herBeverage = new Espresso();
        herBeverage = new Caramel(herBeverage);
        herBeverage = new Whip(herBeverage);
        System.out.println(herBeverage.getDescription() + " $" + herBeverage.cost());
    }
}