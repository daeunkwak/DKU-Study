package championFactory;

import championFactory.garment.ArmorGarment;
import championFactory.garment.Garment;
import championFactory.stamina.Stamina;
import championFactory.stamina.StrongStamina;
import championFactory.weapon.ShieldWeapon;
import championFactory.weapon.Weapon;

public class TankerChampionFactory implements ChampionFactory{

    @Override
    public Stamina createStamina() {
        return new StrongStamina();
    }

    @Override
    public Garment createGarment() {
        return new ArmorGarment();
    }

    @Override
    public Weapon createWeapon() {
        return new ShieldWeapon();
    }

    @Override
    public String getDescription() {
        return null;
    }
}
