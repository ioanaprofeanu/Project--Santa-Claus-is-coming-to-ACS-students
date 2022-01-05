package entities;

import fileio.input.GiftInput;

/**
 * Information about gifts
 */
public final class Gift {
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

    public Gift(GiftInput giftInput) {
        this.productName = giftInput.getProductName();
        this.price = giftInput.getPrice();
        this.category = giftInput.getCategory();
    }

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
        return "Gift{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}
