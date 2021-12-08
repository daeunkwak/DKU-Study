package championFactory;

public class DealerChampion extends Champion{
    ChampionFactory championFactory;

    public DealerChampion(ChampionFactory championFactory){
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
        return "Dealer Champion";
    }
}
