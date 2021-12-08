package championFactory;

import championFactory.garment.Garment;
import championFactory.stamina.Stamina;
import championFactory.weapon.Weapon;

public abstract class Champion{
    String name;

    public Stamina stamina;
    public Garment garment;
    public Weapon weapon;

    // 생성자..
    public Champion(Stamina stamina, Garment garment, Weapon weapon) {
        this.stamina = stamina;
        this.garment = garment;
        this.weapon = weapon;
    }

//    void setStamina(String stamina) {
//        this.stamina = stamina;
//    }
//    public void getStamina(){
//        return this.stamina;
//    }


    // 빨간줄 계속생겨서 기본생성자
    protected Champion() {
    }

    void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String getDescription();
}












