package championFactory;

public class Clientt {
    public Champion createChampionClient(String type) {
        Champion champion = null;
        ChampionFactory championFactory = null;

        switch (type){
            case "tanker" :
                championFactory = new TankerChampionFactory();
                champion = new TankerChampion(championFactory);
                champion.setName("tanker!!");
                System.out.println("Creating Tanker Champion...");
                break;
            case "magician" :
                championFactory = new MagicianChampionFactory();
                champion = new MagicianChampion(championFactory);
                champion.setName("magician");
                System.out.println("Creating Magician Champion...");
                break;
            case "dealer" :
                championFactory = new DealerChampionFactory();
                champion = new DealerChampion(championFactory);
                champion.setName("long distance dealer");
                System.out.println("Creating Dealer Champion...");

        }

        // championFactory championFactory = new DealerChampionFactory();
//        champion = new DealerChampion(championFactory);
//        champion.setName("long distance dealer");
//        System.out.println("Creating Dealer Champion...");
        return champion;
    }
}
