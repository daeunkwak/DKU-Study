package champion;

public abstract class Client {
    public abstract Champion createChampionClient(String type);

//    public Champion createChampionn(String type){
//        Champion champion = createChampionClient();
//        System.out.println("--- Creating a " + type + " champion");
//        return champion;
//    }
}
