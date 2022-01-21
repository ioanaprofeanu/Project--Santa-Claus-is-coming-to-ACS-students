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
    /**
     * The quantity of product
     */
    private int quantity;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
}
