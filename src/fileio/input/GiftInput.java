package fileio.input;

/**
 * Information about a gift, retrieved from parting the input files
 */
public class GiftInput {
    /**
     * the product's name
     */
    private String productName;
    /**
     * the product's price
     */
    private double price;
    /**
     * the product's category
     */
    private String category;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "GiftInput{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}
