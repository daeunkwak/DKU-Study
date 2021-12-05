package champion;

import champion.garment.Garment;
import champion.stamina.Stamina;
import champion.weapon.Weapon;

public abstract class Champion{
    String name;

    Stamina stamina;
    Garment garment;
    Weapon weapon;

    // 생성자..
    public Champion(Stamina stamina, Garment garment, Weapon weapon) {
        this.stamina = stamina;
        this.garment = garment;
        this.weapon = weapon;
    }

    // 빨간줄 계속생겨서 기본생성자
    protected Champion() {
    }

    void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

   // public abstract String getDescription();
}












