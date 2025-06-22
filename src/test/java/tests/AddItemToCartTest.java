package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;

/**
 * Verify the expected page state when we add a an item to the cart.
 * Given: We want to add an item to the cart and see it get dispalyed in the cart
 * When: We click 'Add to Cart'
 * Then: the 'Add to Cart' button should no longer be display.
 * Then: A new shopping cart badge icon should appear displaying the correct number of items in the cart.
 * Then: The 'Remove' button should replace the 'Add to Cart' button that was previously there.
 * @ShoppingCartBade - This is the span icon that gets displayed when an item is added to the cart.
 * The text value should be the number of items added to the cart
 **/
public class AddItemToCartTest extends BaseTest {
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @Parameters({"user", "pass", "baseUrl"})
    @BeforeMethod
    public void loginAsUser(String user, String pass, String baseUrl) {
        loginPage = new LoginPage(driver);
        loginPage.loginAs(user, pass);
    }

    @Test
    public void addItemToCart() {
        inventoryPage = new InventoryPage(driver, "/inventory.html");
        assert inventoryPage.isCartButtonDisplayed();
        WebElement item = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        inventoryPage.addItemToCart(item);
    }

    @Test
    public void cartIconDisplaysCorrectNumberOfItems() {
        addItemToCart();
        WebElement shoppingCartBadge = driver.findElement(By.cssSelector("[data-test='shopping-cart-badge']"));
        String itemCount = shoppingCartBadge.getText();
        assert itemCount.equals("1") : "Expected 1 item in the cart, but found " + itemCount;
    }
}
