package daeunkwak.decorator;

public abstract class Condiment extends Beverage{
    // Decorator와 Component의 연관관계 생성
    // association link를 갖는거지 객체를 생성할 수 없음 abstract라서
    protected Beverage beverage;
    // 하위에서 상속된 subclass에서 구현되는 getDescription들은
    // abstract의 getDescription을 먼저 만나게됨
    // -> 부모의 getDescription을 그대로 사용하게되는걸 끊어낸다.
    public abstract String getDescription();
}
