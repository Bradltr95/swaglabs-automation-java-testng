package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class InventoryPage {
    private final WebDriver driver;

    private final By backpackTitleLink = By.id("item_4_title_link");
    private final By backpackTitleText = By.cssSelector("[data-test='inventory-item-name']");
    private final By backpackCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By backpackDescription = By.cssSelector("[data-test='inventory-item-desc']");
    private final By backpackPrice = By.cssSelector("[data-test='inventory-item-price']");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
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

    public boolean isCartButtonDisplayed() {
        return driver.findElement(backpackCartButton).isDisplayed();
    }

    public boolean isPriceDisplayed() {
        return driver.findElement(backpackPrice).isDisplayed();
    }

    public void addItemToCart(WebElement cartItem) {
        cartItem.click();
    }
}
