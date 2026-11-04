package se.iths.katherine.webshop.model;

public class Product {

    // Här lägger jag in 4 attribut.
    private String articleNumber;
    private String title;
    private double price;
    private String description;

    //Konstruktor i Product för att kunna skapa ett nytt objekt och lägga till ett startvärde.
    public Product(String articleNumber, String title, double price, String description) {
        this.articleNumber = articleNumber;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    //Använder setter för att ändra info i produktens attribut.
    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Produkt info omvandlas till text så att produkt kan sparas i fil.
    public String toFileLine() {
        return articleNumber + ";" + title + ";" + price + ";" + description;
    }

    //Sedan omvandlas texten från fil till nytt Product objekt.
    public static Product fromFileLine(String line) {
        String[] parts = line.split(";");

        String articleNumber = parts[0];
        String title = parts[1];
        double price = Double.parseDouble(parts[2]);
        String description = parts[3];

        return new Product(articleNumber, title, price, description);
    }
}

