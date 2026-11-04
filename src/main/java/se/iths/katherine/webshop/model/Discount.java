package se.iths.katherine.webshop.model;

public abstract class Discount {

    protected String description;

    //Konstruktor som tar emot en beskrivning av rabatten.
    public Discount(String description) {
        //Här sparas beskrivningen i objektets variabel.
        this.description = description;
    }

    //Här hämtas och returneras rabattens beskrivning med getter.
    public String getDescription() {
        return description;
    }

    //Abstrakt metod som beräknar priset efter rabatt. Dock måste varje subklass själv skriva beräkningen.
    public abstract double calculatePrice(double originalPrice);
}
