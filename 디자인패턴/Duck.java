package headfirst.designpatterns.strategy;

// Inheritance, Realization, Override 모두 적용시킨 코드

public abstract class Duck{
    // -> Interface 인스턴스 생성 -> 메소드 호출
    // 부모클래스의 멤버 (인스턴스 변수, 메소드)는 자식클래스가 선언 없이 사용 가능하므로,
    // 인터페이스 인스턴스 또한 자식클래스가 모두 사용 가능함
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

     //생성자
    public Duck(){}

    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb){
        quackBehavior = qb;
    }

    abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("swim swim");
    }
}

// Strategy Pattern 1
interface FlyBehavior{
    public void fly();
}

class FlyWithWings implements FlyBehavior{
    @Override
    public void fly(){
        System.out.println("I can fly");
    }
}

class FlyNoWay implements FlyBehavior{
    @Override
    public void fly(){
        System.out.println("I can't fly");
    }
}

// Strategy Pattern 2
interface QuackBehavior{
    public void quack();
}

class Quack implements QuackBehavior{
    @Override
    public void quack(){
        System.out.println("quack quack");
    }
}

class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("squeak squeak");
    }
}

class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Mute Mute");
    }
}


class DecoyDuck extends Duck{
    public DecoyDuck() {
        // 못 날고 못 우는 오리
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new MuteQuack());
    }
    @Override
    void display() {
        System.out.println("I am Decoy Duck");
    }
}

class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}

class RubberDuck extends Duck {

    public RubberDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }

    public void display() {
        System.out.println("I'm a rubber duckie");
    }
}

class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("I'm a model duck");
    }
}

class MiniDuckSimulator {

    public static void main(String[] args) {

        MallardDuck	mallard = new MallardDuck();
        RubberDuck	rubberDuckie = new RubberDuck();
        DecoyDuck	decoy = new DecoyDuck();
        Duck        model = new ModelDuck();

        mallard.performQuack();
        rubberDuckie.performQuack();
        decoy.performQuack();

        model.performFly();
        model.setFlyBehavior(new FlyWithWings()); // 못 나는 오리 -> 나는 오리
        model.performFly();
    }
}























