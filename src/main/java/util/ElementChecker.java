package util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ElementChecker {
    Logger logger = Logger.getLogger(getClass().getName());
    private final WebDriver driver;

    public ElementChecker(WebDriver driver) {
        this.driver = driver;
    }
    /**
     * Try to see if the element is displayed. If it's not found, findElement will throw a NoSuchElementException.
     * We are catching this and providing a message to the console.
     * @param element The By object we will use to check if the elemnt is displayed.
     * @return 'boolean:true' or 'boolean:false' if the element exists or not.
     * @exception NoSuchElementException We are handling and catchign this exception from the findElement function.
     */
    public boolean elementExists(By element) {
        try{
            return driver.findElement(element).isDisplayed();
        }catch(NoSuchElementException e){
            logger.log(Level.INFO, "Element cannot be found: " + e.getMessage());
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
    }

    /***
     * Using a locator and an expected text string, verify if the
     * @param elementLocator The element locater we are going to find and get the text for.
     * @param expectedText The expected text of the element as a String.
     * @return true if the expected text parameter equals the element's text. Otherwise, false is returned.
     * @exception NoSuchElementException We are handling and catchign this exception from the findElement function.
     */
    public boolean textMatches(By elementLocator, String expectedText) {
        try{
            String elementText = driver.findElement(elementLocator).getText();
            return elementText.equals(expectedText);
        }catch(NoSuchElementException e){
            logger.log(Level.INFO, "Element cannot be found: " + e.getMessage());
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
    }
}
