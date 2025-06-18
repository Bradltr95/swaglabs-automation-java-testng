package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CartTest extends BaseTest {

    @Parameters({"user", "pass", "baseUrl"})
    @BeforeMethod
    public void beforeMethod(String user, String pass, String baseUrl) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(user, pass);
        loginPage.isLoginSuccessful(baseUrl);
    }

    @Parameters({"inventoryUrl", "cartUrl"})
    @Test
    public void addItemAndVerifyCartContentsExist(String inventoryUrl, String cartUrl) {
        // Grab the Inventory POM to reuse the add-item-to-cart method
        InventoryPage inventoryPage = new InventoryPage(driver, inventoryUrl);
        // Get the backpack 'Add to Cart' button and pass it to the addItemToCart() method
        WebElement inventoryItem = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        inventoryPage.addItemToCart(inventoryItem);

        CartPage cartPage = new CartPage(driver, cartUrl);
        // Assert expected elements here
        assert cartPage.isItemNameDisplayed();
        assert cartPage.isItemDescriptionDisplayed();
        assert cartPage.isItemPriceDisplayed();
        assert cartPage.isRemoveBackpackDisplayed();
    }
}
