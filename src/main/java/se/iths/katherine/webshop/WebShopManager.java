package se.iths.katherine.webshop;

import se.iths.katherine.webshop.model.Discount;
import se.iths.katherine.webshop.model.HalfPriceDiscount;
import se.iths.katherine.webshop.model.Product;
import se.iths.katherine.webshop.model.TenPercentDiscount;

import java.util.List;

public class WebShopManager {

    //Produktlagring som används för att spara och hämta produkter.
    private ProductStorage productStorage;

    //Hanterar kommunikation med användaren.
    private OutInputHandler outInputHandler;

    //Konstruktor som tar emot båda interfacen. (dependecy injection)
    public WebShopManager(ProductStorage productStorage, OutInputHandler outInputHandler) {
        this.productStorage = productStorage;
        this.outInputHandler = outInputHandler;
    }

    //Produkt skickas till ProductStorage.
    void saveProductToStorage(Product product) {
        productStorage.saveProduct(product);
    }

    //Hämtar produkt.
    public List<Product> getProductsFromStorage() {
        return productStorage.getProducts();
    }

    //Hämtar en produkt med artikelnummer.
    public Product getProductFromStorage(String articleNumber) {
        return productStorage.getProduct(articleNumber);
    }

    //startar webshop och meny visas.
    public void startWebshop() {

        String discountCode = outInputHandler.prompt("Skriv in rabattkod: ");

        Discount discount = null;

        //Rabatt kontrolleras. (Polymorfism)
        if (discountCode.equals("halfprice")) {
            discount = new HalfPriceDiscount();
        } else {
            discount = new TenPercentDiscount();
        }

        //Menyn visas tills man väljer att avsluta.
        while (true) {

            //Visar meny och hämtar val från användaren.
            String choice = outInputHandler.menu();

            // Här kommer alternativen som man väljer i menyn samt infon som man skriver in om produkten.
            if (choice.equals("1")) {
                String articleNumber = outInputHandler.prompt("Skriv in artikelnummer: ");
                String title = outInputHandler.prompt("Skriv in titel: ");
                double price = Double.parseDouble(outInputHandler.prompt("Skriv in pris: "));
                String description = outInputHandler.prompt("Lägg till beskrivning: ");

                //Skapar ett nytt Product-objekt.
                Product product = new Product(articleNumber, title, price, description);

                //Produkt sparas.
                saveProductToStorage(product);
                outInputHandler.info("Produkten har sparats!");

            } else if (choice.equals("2")) {

                //Hämtar alla produkter från lagringen.
                List<Product> products = getProductsFromStorage();

                //Går igenom alla produkter i listan.
                for (Product product : products) {

                    //Info skrivs om produkt.
                    outInputHandler.info("Artikelnummer: " + product.getArticleNumber());
                    outInputHandler.info("title: " + product.getTitle());
                    outInputHandler.info("Pris: " + product.getPrice());
                    outInputHandler.info("Beskrivning: " + product.getDescription());

                    //Beräknar pris efter rabatt.
                    double discountedPrice = discount.calculatePrice(product.getPrice());

                    //Här visas det rabatterade priset.
                    outInputHandler.info("Rabatterat pris: " + discountedPrice);
                }

            } else if (choice.equals("3")) {

                //Frågar om artikelnummer.
                String articleNumber = outInputHandler.prompt("Mata in artikelnummer: ");

                //Hämtar produkten.
                Product product = getProductFromStorage(articleNumber);

                //Kontrollerar om produkten hittades.
                if (product != null) {
                    //Skriver ut produktens info.
                    outInputHandler.info("Artikelnummer: " + product.getArticleNumber());
                    outInputHandler.info("title: " + product.getTitle());
                    outInputHandler.info("Pris: " + product.getPrice());
                    outInputHandler.info("Beskrivning: " + product.getDescription());
                } else {
                    outInputHandler.info("Produkten hittades inte!");
                }

                //alt för om man vill avsluta programmet.
            } else if (choice.equals("4")) {
                outInputHandler.info("Tack för besöket!");
                break;

            } else {
                outInputHandler.info("Ogiltigt val, försök igen!");
            }
        }
    }
}
