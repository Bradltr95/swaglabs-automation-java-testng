package util;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

/**
 * Utility class for performing login in Selenium tests without using the UI.
 * <p>
 * This approach eliminates flakiness and speeds up test execution by bypassing
 * the login page entirely and injecting a valid session cookie directly into
 * the browser. It is especially useful for:
 * <ul>
 *   <li>Tests that require a logged-in state across multiple scenarios</li>
 *   <li>Bypassing repetitive or slow UI login steps</li>
 *   <li>Sites or environments where the login form may be unstable</li>
 * </ul>
 * <p>
 * Note: This example is tailored for the SauceDemo site, which stores a
 * "session-username" cookie to determine login state. Real applications may
 * require retrieving a session cookie or token via an API call before adding it
 * to the browser.
 */
public class CookieLogin {
    private static final String BASE_URL = "https://www.saucedemo.com";
    private static final String INVENTORY_URL = BASE_URL + "/inventory.html";

    // Prevent the class from being instantiated
    private CookieLogin() {
        throw new IllegalStateException("Utility class");
    }

    public static void loginWithCookie(WebDriver driver, String username) {
        // Load the base domain before adding the cookie
        driver.get(BASE_URL);

        // Create the cookie based on the desired username
        Cookie loginCookie = new Cookie.Builder("session-username", username)
                .domain("www.saucedemo.com")
                .path("/")
                .isHttpOnly(false)
                .isSecure(true)
                .build();

        // At the cookie to the driver
        driver.manage().addCookie(loginCookie);

        // Navigate directly to the inventory page now that we have the expected cookie
        driver.navigate().to(INVENTORY_URL);
    }
}
