package Adapter;

public class Main {
    // 옛날 코드를 활용해서 새로운 코드를 짤 때 활용한다
    public static void main(String[] args) {
        // Object Adapter
        Duck duck = new MallardDuck();
        // Duck으로 turkey를 만들어야함!
        // Duck으로 turkey를 붙일 수 있도록! 똑같이 Duck 사용하고
        //Duck turkey = new TurkeyAdapter(new WildTurkey());

        // Class Adapter
        Duck turkey = new WildTurkeyAdapter();
        // Turkey turkey = new WildTurkey();

        System.out.println("I am a duck");
        duck.quack();
        duck.fly();

        System.out.println("I am a turkey");
        turkey.quack();
        turkey.fly();
    }
}
