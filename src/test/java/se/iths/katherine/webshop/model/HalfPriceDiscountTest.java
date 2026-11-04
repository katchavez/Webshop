package se.iths.katherine.webshop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HalfPriceDiscountTest {

    //Markerar metod som ett test för JUnit att köra.
    @Test
    public void testCalculatePrice() {
        //Skapar objekt.
        HalfPriceDiscount discount = new HalfPriceDiscount();

        //Produktpris och beräkning efter rabatt.
        double price = 100.0;
        double discountedPrice = discount.calculatePrice(price);

        //Kontroll så att resultat blir 90kr med tillåten felmarginal på 0.001kr.
        assertEquals(50.0, discountedPrice, 0.001);
    }
}
