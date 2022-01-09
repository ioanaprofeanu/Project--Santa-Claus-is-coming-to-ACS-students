package entities;

import fileio.input.GiftInput;

/**
 * Information about gifts
 */
public final class Gift {
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

    public Gift(final GiftInput giftInput) {
        this.productName = giftInput.getProductName();
        this.price = giftInput.getPrice();
        this.category = giftInput.getCategory();
    }

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
        return "Gift{"
                + "productName='" + productName + '\''
                + ", price=" + price
                + ", category='" + category + '\''
                + '}';
    }
}
