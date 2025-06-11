package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @Test
    @Parameters({"user", "pass"})
    public void testSuccessfulLogin(String user, String pass) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(user, pass);

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory"), "User should be redirected to inventory page");
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("invalid_user", "wrong_password");

        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message should be displayed for invalid login");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service");
    }
}
