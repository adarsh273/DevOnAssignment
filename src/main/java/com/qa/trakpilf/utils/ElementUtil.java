/**
 * 
 */
package com.qa.trakpilf.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author adarsh
 *
 */
public class ElementUtil {

    private WebDriver driver;

    /**
     * @param driver
     * 
     */
    public ElementUtil(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By locator) {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
        } catch (Exception e) {
            System.out.println("No Such Element found using locator -> " + locator);
        }

        return element;
    }

    public List<WebElement> getElementsList(By locator) {
        List<WebElement> elementList = null;
        try {
            elementList = driver.findElements(locator);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementList;
    }

    public void selectElementFromList(By locator, String text) {
        List<WebElement> elementList = getElementsList(locator);
        for (WebElement elem : elementList) {
            if (elem.getText().trim().equalsIgnoreCase(text)) {
                elem.click();
            }
        }
    }

    // Actions class implementation
    /**
     * 
     */
    public void scrollToElementByActions(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement(locator)).perform();
    }

    public void moveToPosition() {
        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 25);
    }

    // JavaScript executor

    public void scrollTillElementVisible(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
        System.out.println("scroll success");
    }

    public void scrollToOffset() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

    }

    // waits
    // WebDriverWait

    public boolean waitForElementPresent(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        try {
            WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            if (elem.isDisplayed()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Exception in: waitForElementPresent");
        }
        return false;
    }
}
