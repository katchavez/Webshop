package se.iths.katherine.webshop;

import se.iths.katherine.webshop.model.Product;

import java.util.ArrayList;
import java.util.List;

//Testlagring som sparar produkter i en lista
public class ProductListStorage implements ProductStorage {

    //Lista som håller produkterna under denna test.
    private List<Product> products = new ArrayList<>();

    //Sparar en produkt i listan.
    @Override
    public void saveProduct(Product product) {
        products.add(product);
    }

    //Hämtar alla produkter från listan.
    @Override
    public List<Product> getProducts() {
        return products;
    }

    //Hämtar en produkt genom artikelnummer.
    @Override
    public Product getProduct(String articleNumber) {
        for (Product product : products) {
            if (product.getArticleNumber().equals(articleNumber)) {
                return product;
            }
        }
        return null;
    }
}
