package se.iths.katherine.webshop;

//Klassen implementerar OutInPutHandler och hanterar kommunikationen via konsolen.
public class ConsoleOutInputHandler implements OutInputHandler {

    //Visar ett meddelande och returnerar användarens svar.
    @Override
    public String prompt(String message) {
        return IO.readln(message);
    }

    //Info skrivs ut till användaren.
    @Override
    public void info(String message) {
        IO.println(message);
    }

    //Menyn visas och returnerar användarens val.
    @Override
    public String menu() {
        IO.println("\n Webshop");
        IO.println("1.Lägg till produkt");
        IO.println("2. Lista alla produkter");
        IO.println("3. Visa information om en produkt");
        IO.println("4. Avsluta");

        return IO.readln("Välj ett alternativ: ");
    }
}
