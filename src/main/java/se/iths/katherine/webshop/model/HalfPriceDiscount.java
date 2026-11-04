package se.iths.katherine.webshop.model;

//(samma som på TenPercentDiscount)
//Klassen ärver från Discount och får dens egenskaper och metoder.
public class HalfPriceDiscount extends Discount {

    //Konstruktor som skapar rabatt på 50%
    public HalfPriceDiscount() {

        //Här anropas konstruktorn i Discount och skickar beskrivningen på rabatten.
        super("50% rabatt");
    }

    //Metod som implementeras från Discount.
    @Override
    public double calculatePrice(double originalPrice) {

        //Räknar ut priset efter 50% rabatt.
        return originalPrice * 0.50;
    }
}
