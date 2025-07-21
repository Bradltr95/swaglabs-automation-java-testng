package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ElementChecker;

import java.time.Duration;
import java.util.logging.Logger;

public class BasePage {
    protected final WebDriver driver;
    protected final By pageHeader =  By.cssSelector("[data-test='title']");
    protected ElementChecker checkElement;
    private final String pathUrl;
    private String pageHeaderText;
    Logger logger = Logger.getLogger(getClass().getName());

    // Set the driver, pathUrl and pass the driver to the elementChecker object.
    public BasePage(WebDriver driver, String pathUrl) {
        this.driver = driver;
        this.pathUrl = pathUrl;
        checkElement = new ElementChecker(this.driver);
    }
    public boolean isHeaderTextDisplayed() { return checkElement.elementExists(pageHeader); }

    public String getPath() { return this.pathUrl; }

    public boolean isPageValid(String baseUrl, String pageHeaderText) {
        String expectedUrl = baseUrl + getPath();
        String currentUrl = driver.getCurrentUrl();
        this.pageHeaderText = pageHeaderText;

        boolean isDisplayed = checkElement.elementExists(pageHeader);
        boolean hasExpectedText = checkElement.textMatches(pageHeader, pageHeaderText);
        boolean titleMatches = currentUrl.equals(expectedUrl);

        if (!isDisplayed) {
            logger.info("Debug: header is not displayed.");
            System.out.print("Header is not displayed.");
        }
        if (!hasExpectedText) {
            logger.info("Debug: Header text does not match expected value.");
            System.out.print("Debug: Header text does not match expected value.");
        }
        if (!titleMatches) {
            logger.info("Debug: Current URL does not match expected URL. Expected: " + expectedUrl + ", Found: " + currentUrl);
            System.out.print("URL doesn't match. Expected: " + expectedUrl + " Found: " + currentUrl);
        }

        return isDisplayed && hasExpectedText && titleMatches;
    }
}
