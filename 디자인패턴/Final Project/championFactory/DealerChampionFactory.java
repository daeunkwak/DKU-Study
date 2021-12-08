package championFactory;

import championFactory.garment.Garment;
import championFactory.garment.SleekGarment;
import championFactory.stamina.Stamina;
import championFactory.stamina.WeakStamina;
import championFactory.weapon.ArrowWeapon;
import championFactory.weapon.Weapon;

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
