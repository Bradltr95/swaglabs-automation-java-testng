package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.logging.Logger;

import java.time.Duration;

public class InventoryPage {
    private final WebDriver driver;

    Logger logger = Logger.getLogger(getClass().getName());

    private final By backpackTitleLink = By.id("item_4_title_link");
    private final By backpackTitleText = By.cssSelector("[data-test='inventory-item-name']");
    private final By backpackCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By backpackDescription = By.cssSelector("[data-test='inventory-item-desc']");
    private final By backpackPrice = By.cssSelector("[data-test='inventory-item-price']");
    private final By shoppingCartBadge =  By.id("add-to-cart-sauce-labs-backpack");
    private final By productsHeader =  By.cssSelector("[data-test='title']");
    private String inventoryPath;

    public InventoryPage(WebDriver driver, String inventoryPath) {
        this.driver = driver;
        this.inventoryPath = inventoryPath;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public boolean isTitleLinkDisplayed() {
        return driver.findElement(backpackTitleLink).isDisplayed();
    }

    public boolean isTitleTextDisplayed() {
        return driver.findElement(backpackTitleText).isDisplayed();
    }

    public boolean isDescriptionDisplayed() {
        return driver.findElement(backpackDescription).isDisplayed();
    }

    public boolean isCartButtonDisplayed() { return driver.findElement(backpackCartButton).isDisplayed(); }

    public boolean isPriceDisplayed() {
        return driver.findElement(backpackPrice).isDisplayed();
    }

    public boolean isProductsHeaderDisplayed() { return driver.findElement(productsHeader).isDisplayed(); }

    public boolean isShoppingCartBadgeDisplayed() { return driver.findElement(shoppingCartBadge).isDisplayed(); }

    public boolean verifyProductsHeaderText() { return driver.findElement(productsHeader).getText().equals("Products"); }

    public boolean isPageValid(String baseUrl) {
        String expectedUrl = baseUrl + getPath();
        String currentUrl = driver.getCurrentUrl();

        boolean isDisplayed = isProductsHeaderDisplayed();
        boolean hasExpectedText = verifyProductsHeaderText();
        boolean titleMatches = currentUrl.equals(expectedUrl);

        if (!isDisplayed) {
            logger.info("Debug: Products header is not displayed.");
        }
        if (!hasExpectedText) {
            logger.info("Debug: Products header text does not match expected value.");
        }
        if (!titleMatches) {
            logger.info("Debug: Current URL does not match expected URL. Expected: " + expectedUrl + ", Found: " + currentUrl);
        }

        return isDisplayed && hasExpectedText && titleMatches;
    }

    public void addItemToCart(WebElement cartItem) {
        cartItem.click();
    }

    public String getPath() { return this.inventoryPath; }
}
