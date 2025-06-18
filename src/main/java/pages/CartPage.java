package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
Cart Page Purpose:
- Display items in the cart.
- Remove items from the cart.
- Proceeding to checkout.
 */
// Navigate to cart from the inventory page.
// Checkout from cart.
// Continue shopping (This is a button that takes you back to the inventory page).
// THESE ELEMENTS ARE PART OF THE ITEM IN THE CART
// - Quantity, Remove Button, Price, Description, Page Header ("Your Cart")
// Select cart items (This is a link in the cart item header that takes you to the item description
public class CartPage {
    private final WebDriver driver;
    private String cartPath;

    private final By inventoryItemName = By.className("inventory_item_name");
    private final By inventoryItemDescription = By.className("inventory_item_description");
    private final By inventoryItemPrice = By.className("inventory_item_price");
    private final By removeSauceLabsBackpackButton = By.id("remove-sauce-labs-backpack");

    public CartPage(WebDriver driver, String cartPath) {
        this.driver = driver;
        this.cartPath = cartPath;
    }

    public boolean isItemNameDisplayed() { return  driver.findElement(inventoryItemName).isDisplayed(); }
    public boolean isItemDescriptionDisplayed() { return  driver.findElement(inventoryItemDescription).isDisplayed(); }
    public boolean isItemPriceDisplayed() { return  driver.findElement(inventoryItemPrice).isDisplayed(); }
    public boolean isRemoveBackpackDisplayed() { return  driver.findElement(removeSauceLabsBackpackButton).isDisplayed(); }

    public void removeCartItem(String item) {
        // We can use a unique identifier here such as the header of the item
    }

    public void proceedToCheckout() {
        // Click the checkout button and verify the page URL and an element on the page
    }
}
