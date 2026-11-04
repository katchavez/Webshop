package se.iths.katherine.webshop;

public class Main {
    //Main metod som kör automatiskt när program startar.
    public static void main(String[] args) {

        //produktlagring som använder textfil. (Interface som skapar objekt)
        ProductStorage storage = new ProductFileStorage();

        //Skapar hantering av kommunikation med användaren.
        OutInputHandler handler = new ConsoleOutInputHandler();

        //Skapar WebShopManager och skickar med produktlagring.
        WebShopManager manager = new WebShopManager(storage, handler);

        //Startar webbutiken och visar menyn.
        manager.startWebshop();
    }
}
