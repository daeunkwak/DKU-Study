package champion;

import champion.garment.Garment;
import champion.garment.SleekGarment;
import champion.stamina.Stamina;
import champion.stamina.WeakStamina;
import champion.weapon.ArrowWeapon;
import champion.weapon.Weapon;

public class DealerChampionFactory implements ChampionFactory{
    @Override
    public Stamina createStamina() {
        return new WeakStamina();
    }

    @Override
    public Garment createGarment() {
        return new SleekGarment();
    }

    @Override
    public Weapon createWeapon() {
        return new ArrowWeapon();
    }

    @Override
    public String getDescription() {
        return "I'm a Dealer Champion!!";
    }
}
