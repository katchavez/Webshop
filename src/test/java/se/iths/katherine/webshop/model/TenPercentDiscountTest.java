package se.iths.katherine.webshop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TenPercentDiscountTest {

    //Markerar metod som ett test för JUnit att köra.
    @Test
    public void testCalculatePrice() {
        //Skapar objekt.
        TenPercentDiscount discount = new TenPercentDiscount();

        //Produktpris och beräkning efter rabatt.
        double price = 100.0;
        double discountedPrice = discount.calculatePrice(price);

        //Kontroll så att resultat blir 90kr med tillåten felmarginal på 0.001kr.
        assertEquals(90.0, discountedPrice, 0.001);
    }
}
