package champion;

import champion.garment.Garment;
import champion.stamina.Stamina;
import champion.weapon.Weapon;

public interface ChampionFactory {
    public Stamina createStamina();
    public Garment createGarment();
    public Weapon createWeapon();

    public String getDescription();
}
