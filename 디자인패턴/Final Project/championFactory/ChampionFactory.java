package championFactory;

import championFactory.garment.Garment;
import championFactory.stamina.Stamina;
import championFactory.weapon.Weapon;

public interface ChampionFactory {
    Stamina createStamina();
    Garment createGarment();
    Weapon createWeapon();

    String getDescription();
}
