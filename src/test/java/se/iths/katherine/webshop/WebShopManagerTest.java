package se.iths.katherine.webshop;

import org.junit.jupiter.api.Test;
import se.iths.katherine.webshop.model.Product;

import static org.junit.jupiter.api.Assertions.*;

class WebShopManagerTest {

    @Test
    void saveProductToStorageShouldSaveTwoProducts() {

        //Skapar en testlagring som sparar produkter i en lista.
        ProductListStorage storage = new ProductListStorage();

        //Skapar en WebShopManager med testlagring.
        WebShopManager manager = new WebShopManager(storage, null);

        //Skapar två produkter.
        Product product1 = new Product("1001", "Dell", 1000, "Bärbar dator");
        Product product2 = new Product("1002", "Iphone", 5000, "Telefon");

        //Sparar produkterna.
        manager.saveProductToStorage(product1);
        manager.saveProductToStorage(product2);

        //Kontrollerar att dom har sparats.
        assertEquals(2, manager.getProductsFromStorage().size());
    }

    @Test
    void getProductFromStorageShouldReturnCorrectProduct() {

        //Skapar en testlagring.
        ProductListStorage storage = new ProductListStorage();

        //Skapar WebShopManager.
        WebShopManager manager = new WebShopManager(storage, null);

        //SKapa och spara en produkt.
        Product product = new Product("1001", "Dell", 1000, "Bärbar dator");
        manager.saveProductToStorage(product);

        //Hämtar produkt med artikelnummer.
        Product result = manager.getProductFromStorage("1001");

        //Kontrollerar att det är rätt artikelnummer som returneras.
        assertEquals("1001", result.getArticleNumber());
    }

    @Test
    void getProductFromStorageShouldReturnNullWhenNoProductFound() {

        ProductListStorage storage = new ProductListStorage();

        WebShopManager manager = new WebShopManager(storage, null);

        Product result = manager.getProductFromStorage("9999");

        assertNull(result);
    }
}

