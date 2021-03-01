/**
 * 
 */
package com.qa.trakpilf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.qa.trakpilf.base.Base;
import com.qa.trakpilf.utils.ElementUtil;

/**
 * @author adarsh
 *
 */
public class HomePage extends Base {

    private final Logger LOGGER = Logger.getLogger(HomePage.class);

    private WebDriver driver;
    private ElementUtil elementUtil;

    private String searchKey;

    // By objects
    By logoTrakpilf = By.cssSelector("img[title='Flipkart']");
    By dotComEndOfPage = By.xpath("//span[text()='Flipkart.com']");
    By closeButton = By.xpath("//button[contains(text(),'✕')]");
    By searchField = By.name("q");
//    By searchButon = B

    public HomePage(WebDriver driver) {
        LOGGER.info("HomePage constructor...");
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
    }

    public void closeLoginPopUp() {
         WebElement elem = elementUtil.getElement(closeButton);
         System.out.println("inside closeLoginPopUp");
         if(elem.isDisplayed()) {
             elem.click();
         }
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public void backToHomePage() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        LOGGER.info("before (logoTrakpilf).click() ");
        elementUtil.getElement(logoTrakpilf).click();
//        elementUtil.scrollTillElementVisible(dotComEndOfPage);
//        elementUtil.waitForElementPresent(dotComEndOfPage, 3);
//        elementUtil.scrollPage("end");
//        elementUtil.scrollPage("start");
    }
    public SearchResultsPage searchInHomePage(String searchKey) {
        this.searchKey = searchKey;
        if(elementUtil.waitForElementPresent(searchField, 3)) {
            elementUtil.getElement(searchField).sendKeys(searchKey);
            elementUtil.getElement(searchField).submit();
        }
        

        return new SearchResultsPage(driver);
    }

    public String getSearchKey() {
        return this.searchKey;
    }
}
