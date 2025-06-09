package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;

public class AddItemToCartTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void loginAsUser() {
        loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");
    }

    @Test
    public void addItemAndCheckCart() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        WebElement item = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        inventoryPage.addItemToCart(item);
    }
}
