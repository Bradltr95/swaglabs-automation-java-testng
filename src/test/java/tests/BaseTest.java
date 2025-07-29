package tests;

import driver.DriverType;
import driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;

    @Parameters({"baseUrl"})
    @BeforeMethod
    public void setup(String baseUrl) {
        driver = WebDriverFactory.createDriver(DriverType.CHROME);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterMethod
    public void cleanup() {
        if (driver != null) { driver.quit(); }
    }
}
