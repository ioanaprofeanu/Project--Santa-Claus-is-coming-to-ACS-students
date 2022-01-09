package fileio.input;

/**
 * Information about a gift, retrieved from parsing the input files
 */
public final class GiftInput {
    /**
     * The product's name
     */
    private String productName;
    /**
     * The product's price
     */
    private double price;
    /**
     * The product's category
     */
    private String category;

    public String getProductName() {
        return productName;
    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "GiftInput{"
                + "productName='" + productName + '\''
                + ", price=" + price
                + ", category='" + category + '\''
                + '}';
    }
}
