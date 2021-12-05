package champion;

import champion.garment.ArmorGarment;
import champion.garment.Garment;
import champion.stamina.Stamina;
import champion.stamina.StrongStamina;
import champion.weapon.ShieldWeapon;
import champion.weapon.Weapon;

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
