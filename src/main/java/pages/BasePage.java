package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ElementChecker;

import java.time.Duration;
import java.util.logging.Logger;

public class BasePage {
    protected final WebDriver driver;
    protected final String pathUrl;
    Logger logger = Logger.getLogger(getClass().getName());
    protected final By pageHeader =  By.cssSelector("[data-test='title']");
    protected ElementChecker checkElement = new ElementChecker();

    public BasePage(WebDriver driver, String pathUrl) {
        this.driver = driver;
        this.pathUrl = pathUrl;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public String getPath() { return this.pathUrl; }
}
