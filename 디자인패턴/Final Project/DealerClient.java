package champion;

public class DealerClient extends Client{
    @Override
    public Champion createChampionClient(String type) {
        Champion champion = null;
        ChampionFactory championFactory = new DealerChampionFactory();
        champion = new DealerChampion(championFactory);
        champion.setName("long distance dealer");

        System.out.println("Creating Dealer Champion...");
        return champion;
    }
}
