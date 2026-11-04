package se.iths.katherine.webshop;

//Interface som beskriver hur programmet kommunicerar med användaren.
public interface OutInputHandler {

    //Visar en fråga och ger användaren ett svar tillbaka.
    String prompt(String message);

    //Info visas för användaren.
    void info(String message);

    //Meny visas och returnerar användarens val.
    String menu();
}
