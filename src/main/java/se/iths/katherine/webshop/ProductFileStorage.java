package se.iths.katherine.webshop;

import se.iths.katherine.webshop.model.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

//Här implementerar ProductStorage klassen och ansvarar för att spara och hämta produkter från en textfil.
public class ProductFileStorage implements ProductStorage {

    //Anger sökvägen till filen dör produkterna sparas.
    private Path file = Path.of("products.txt");

    //Här sparas en produkt i textfilen.
    @Override
    public void saveProduct(Product product) {
        try {
            Files.writeString(
                    file,
                    //Produkt görs till text radbrytning läggs till.
                    product.toFileLine() + System.lineSeparator(),
                    //CREATE skapar filen om den inte redan finns. APPEND lägger till den nya produkten sist i filen.
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND

            );
        } catch (IOException e) {
            System.out.println("Kunde inte spara produkten" + e.getMessage());
        }
    }

    //Produkter hämtas från textfilen.
    @Override
    public List<Product> getProducts() {
        //En tom lista skapas för produkter läggs till.
        List<Product> products = new ArrayList<>();

        //Kontrollerar om filen finns och returnerar tom lista om den inte finns.
        if (!Files.exists(file)) {
            return products;
        }

        try {
            //Läser rader från textfil.
            List<String> lines = Files.readAllLines(file);

            //Går igenom varje rad i filen.
            for (String line : lines) {

                //Ändring jag lagt till för att den ska hoppa över tomma rader.
                if (line.isBlank()) {
                    continue;
                }

                //Kontroll om raden innehåller fyra delar.
                String[] parts = line.split(";", -1);

                if (parts.length != 4) {
                    System.out.println("Felaktig produktrad; " + line);
                    continue;
                }

                //GÖr om text till Product-objekt och lägger till produkten i lista.
                try {
                    products.add(Product.fromFileLine(line));
                } catch (NumberFormatException e) {
                    continue;
                }
            }

        } catch (IOException e) {
            System.out.println("Kunde inte läsa produkterna: " + e.getMessage());
        }

        return products;
    }

    //Här hämtas en specifik produkt med hjälp av artikelnumret.
    @Override
    public Product getProduct(String articleNumber) {
        //Produkter hämtas från filen.
        List<Product> products = getProducts();

        //Går igenom alla produkter i listan.
        for (Product product : products) {

            //Kontrollerar så att artikelnummer matchar de sökta.
            if (product.getArticleNumber().equals(articleNumber)) {
                //Sedan returneras produkten om den matchar artikelnumret.
                return product;
            }
        }

        //Om ingen produkt hittas så returneras null.
        return null;
    }
}
