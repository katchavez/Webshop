package se.iths.katherine.webshop;

//Importerar Product för att använda klassen här nu.
import se.iths.katherine.webshop.model.Product;
//Importerar List för att hantera en lista med produkter.
import java.util.List;

//Interface som beskriver vilka metoder en klass för produktlagring måste innehålla.
public interface ProductStorage {

    //Sparar en produkt i lagringen.
    void saveProduct(Product product);

    //Här hämtas och returneras en lista med alla produkter.
    List<Product> getProducts();

    //Här hämtas och returneras en produkt med hjälp av artikelnummer.
    Product getProduct(String articleNumber);
}
