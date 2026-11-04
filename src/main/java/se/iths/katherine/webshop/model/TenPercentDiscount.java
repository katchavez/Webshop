package se.iths.katherine.webshop.model;

//Klassen ärver från Discount och får dens egenskaper och metoder.
public class TenPercentDiscount extends Discount {

    //Konstruktor som skapar rabatt på 10%
    public TenPercentDiscount() {

        //Här anropas konstruktorn i Discount och skickar beskrivningen på rabatten.
        super("10% rabatt");
    }

    //Metod som implementeras från Discount.
    @Override
    public double calculatePrice(double originalPrice) {

        //Räknar ut priset efter 10% rabatt.
        return originalPrice * 0.90;
    }
}
