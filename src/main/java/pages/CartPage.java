package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// The Cart Page Object Model
public class CartPage extends BasePage {
    // Element identifiers
    private final By inventoryItemName = By.className("inventory_item_name");
    private final By inventoryItemDescription = By.className("inventory_item_description");
    private final By inventoryItemPrice = By.className("inventory_item_price");
    private final By removeSauceLabsBackpackButton = By.id("remove-sauce-labs-backpack");

    public CartPage(WebDriver driver, String cartPath) {
        super(driver, cartPath);
    }

    public boolean isItemNameDisplayed() { return checkElement.elementExists(inventoryItemName); }
    public boolean isItemDescriptionDisplayed() { return checkElement.elementExists(inventoryItemDescription); }
    public boolean isItemPriceDisplayed() { return checkElement.elementExists(inventoryItemPrice); }
    public boolean isRemoveBackpackDisplayed() { return checkElement.elementExists(removeSauceLabsBackpackButton); }

    public void removeCartItem(String item) {
        // We can use a unique identifier here such as the header of the item
    }

    public void proceedToCheckout() {
        // Click the checkout button and verify the page URL and an element on the page
    }
}
