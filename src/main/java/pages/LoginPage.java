package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.annotation.ParametersAreNonnullByDefault;
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
     * Decouple Logic: Move the validation logic to the InventoryPage class to reduce coupling.
     * Explicit Waits: Use explicit waits for better control over element visibility.
     */
    public boolean isLoginSuccessful(String baseUrl) {
        String expectedUrl = baseUrl + "/inventory.html";
        String currentUrl = driver.getCurrentUrl();
        InventoryPage inventoryPage = new InventoryPage(driver);

        WebElement productsHeader = driver.findElement(inventoryPage.getProductsHeader());

        boolean isDisplayed = productsHeader.isDisplayed();
        boolean hasExpectedText = productsHeader.getText().equals("Products");
        boolean titleMatches = currentUrl.equals(expectedUrl);

        return isDisplayed && hasExpectedText && titleMatches;
    }
}
