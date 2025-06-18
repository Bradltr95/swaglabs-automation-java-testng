package util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

/**
 * The purpose of the element checker class is to abstract the try()catch() block
 * from the POM's when checking if elements are displayed/exist. This reduces a ton of duplicate code.
 */
public class ElementChecker {
    Logger logger = Logger.getLogger(getClass().getName());

    /**
     * The purpose of this fucntion is to catch any exceptions when trying to find an element and log them to the Logger.
     * It makes use of the WebElements isDisplayed() function to return a boolean if the item exists.
     * @param element the WebElement that is checked for isDisplayed().
     * @return Returns `true` if the item is displayed and returns `false` with an Exception logged otherwise.
     */
    public boolean elementExists(WebDriver driver, By element) {
        try{
            return driver.findElement(element).isDisplayed();
        }catch(NoSuchElementException e){
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
    }
}
