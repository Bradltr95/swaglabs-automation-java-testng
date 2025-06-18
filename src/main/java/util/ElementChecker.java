package util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ElementChecker {
    Logger logger = Logger.getLogger(getClass().getName());

    /**
     * Try to see if the element is displayed. If it's not found, findElement will throw a NoSuchElementException.
     * We are catching this and providing a message to the console.
     * @param element The By object we will use to check if the elemnt is displayed.
     * @return 'boolean:true' or 'boolean:false' if the element exists or not.
     */
    public boolean elementExists(WebDriver driver, By element) {
        try{
            return driver.findElement(element).isDisplayed();
        }catch(NoSuchElementException e){
            logger.log(Level.INFO, "Element cannot be found: " + e.getMessage());
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
    }
}
