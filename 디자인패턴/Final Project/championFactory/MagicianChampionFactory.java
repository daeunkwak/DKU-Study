package championFactory;

import championFactory.garment.CapeGarment;
import championFactory.garment.Garment;
import championFactory.stamina.AverageStamina;
import championFactory.stamina.Stamina;
import championFactory.weapon.WandWeapon;
import championFactory.weapon.Weapon;

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
