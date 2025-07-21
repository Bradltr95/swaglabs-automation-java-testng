package util;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.time.Duration;

// Returning WebElements come from the ExpectedConditions class functions and allow us to perform
// actions aftet the element
public class WaitUtil {
    WebDriver driver;
    WebDriverWait wait;

    public WaitUtil(WebDriver driver, Duration waitDuration) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, waitDuration);
    }

    // Wait for an element to be visible
    public WebElement waitForElementToBeVisible(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch(Exception e) {
            System.out.println("Timeout issue waiting for element to be visible.\n" + e);
            return null;
        }
    }

    // Wait for element to be clickable
    public WebElement waitForElementToBeClickable(By locator) {
        try{
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        }catch(Exception e) {
            System.out.println("Timeout issue waiting for element to be clickable.\n" + e);
            return null;
        }
    }

    // Wait for expected text to be present in web element
    public boolean waitForTextToBePresent(By locator, String text) {
        return wait.until(ExpectedConditions.textToBe(locator, text));
    }

    // Wait for a URL to match a specific value
    public boolean waitForUrlToBe(String url) {
        return wait.until(ExpectedConditions.urlToBe(url));
    }
}
