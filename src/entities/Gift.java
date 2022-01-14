package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fileio.input.GiftInput;

/**
 * Information about gifts
 */
public final class Gift {
    /**
     * The product's name
     */
    private final String productName;
    /**
     * The product's price
     */
    private final double price;
    /**
     * The product's category
     */
    private final String category;
    /**
     * The quantity of product
     */
    @JsonIgnore
    private int quantity;

    public Gift(final GiftInput giftInput) {
        this.productName = giftInput.getProductName();
        this.price = giftInput.getPrice();
        this.category = giftInput.getCategory();
        this.quantity = giftInput.getQuantity();
    }

    public void decreaseQuantity() {
        if (quantity == 0) {
            throw new IllegalCallerException("Gift " + productName + " out of stock!");
        }
        quantity--;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }
}
