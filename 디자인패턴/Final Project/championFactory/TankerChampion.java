package championFactory;

public class TankerChampion extends Champion{
    ChampionFactory championFactory;

    public TankerChampion(ChampionFactory championFactory){
        this.championFactory = championFactory;
    }

    void create(){
        System.out.println("I'm Creating");
        stamina = championFactory.createStamina();
        garment = championFactory.createGarment();
        weapon = championFactory.createWeapon();
    }

    @Override
    public String getDescription() {
        return "Tanker Champion";
    }
}
