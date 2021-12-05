package champion;

import champion.garment.CapeGarment;
import champion.garment.Garment;
import champion.stamina.AverageStamina;
import champion.stamina.Stamina;
import champion.weapon.WandWeapon;
import champion.weapon.Weapon;

public class MagicianChampionFactory implements ChampionFactory{
    @Override
    public Stamina createStamina() {
        return new AverageStamina();
    }

    @Override
    public Garment createGarment() {
        return new CapeGarment();
    }

    @Override
    public Weapon createWeapon() {
        return new WandWeapon();
    }

    @Override
    public String getDescription() {
        return null;
    }
}
