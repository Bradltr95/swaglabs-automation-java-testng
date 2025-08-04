package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
    static WebDriver driver = null;

    public static WebDriver createDriver(DriverType driverName) {
        switch(driverName) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
            default:
                // By default, we can fall back on the chrome driver. Replace the print with a proper logger.
                System.out.println("Issue finding compatible driver.. defaulting to ChromeDriver");
                driver = new ChromeDriver();
                break;
        }

        return driver;
    }
}
