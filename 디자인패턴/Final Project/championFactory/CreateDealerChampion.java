package championFactory;

// *****
public class CreateDealerChampion {
    public Champion createChampion(String type){
        Champion champion = null;
        ChampionFactory  championFactory = new DealerChampionFactory();

        champion = new DealerChampion(championFactory);
        champion.setName("long distance dealer");

//        ChampionFactory championFactory = null;
//        switch (type){
//            case "tanker" :
//                championFactory = new TankerChampionFactory();
//                break;
//            case "magician" :
//                championFactory = new MagicianChampionFactory();
//                break;
//            case "dealer" :
//                championFactory = new DealerChampionFactory();
//        }
//        championFactory.createStamina();
//        championFactory.createGarment();
//        championFactory.createWeapon();
        return champion;
    }
}
