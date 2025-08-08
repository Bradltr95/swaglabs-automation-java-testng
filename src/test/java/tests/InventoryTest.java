package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;

import static util.CookieLogin.loginWithCookie;

public class InventoryTest extends BaseTest {
    @BeforeMethod
    public void loginAsUser() {
        loginWithCookie(driver, "standard_user");
    }

    @Test
    public void testLabsBackPageTitleExists() {
        InventoryPage inventoryPage = new InventoryPage(driver, "/inventory.html");

        // Verify we are on the inventory page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory"), "User should be redirected to inventory page");

        Assert.assertTrue(inventoryPage.isTitleLinkDisplayed(), "Inventory Link Should be Displayed in Inventory");
        Assert.assertTrue(inventoryPage.isTitleTextDisplayed(), "Inventory Text Should be Displayed in Inventory");
        Assert.assertTrue(inventoryPage.isDescriptionDisplayed(), "The Sauce Labs Backpage Description should exists");
        Assert.assertTrue(inventoryPage.isCartButtonDisplayed(), "The 'Add to cart' button should be displayed");
    }
}
