package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    // Page Locators
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    // Page Actions
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void enterUsername(String username) {
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public boolean isErrorDisplayed() {
        return !driver.findElements(errorMessage).isEmpty();
    }

    /** @Todo: IMRPOVEMENTS
     * Error Handling: Wrap element interactions in a try-catch block to handle exceptions gracefully.
     * Externalize Text: Use a constants file or resource bundle for the "Products" text.
     * Explicit Waits: Use explicit waits for better control over element visibility.
     */
    public boolean isLoginSuccessful(String baseUrl) {
        InventoryPage inventoryPage = new InventoryPage(driver, "/inventory.html");
        return inventoryPage.isPageValid(baseUrl);
    }
}
