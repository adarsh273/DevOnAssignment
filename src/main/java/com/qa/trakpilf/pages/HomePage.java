/**
 * 
 */
package com.qa.trakpilf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import com.qa.trakpilf.base.Base;
import com.qa.trakpilf.utils.ElementUtil;

/**
 * @author adarsh
 *
 */
public class HomePage extends Base {

    private WebDriver driver;
    private ElementUtil elementUtil;
    
    private String searchKey;

    // By objects

    By closeButton = By.xpath("//button[contains(text(),'✕')]");
    By searchField = By.name("q");
//    By searchButon = B

    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public void closeLoginPopUp() {
        elementUtil.getElement(closeButton).click();
    }

    public SearchResultsPage searchInHomePage(String searchKey) {
        this.searchKey = searchKey;
        elementUtil.getElement(searchField).sendKeys(searchKey);
        elementUtil.getElement(searchField).submit();

        return new SearchResultsPage(driver);
    }
    
    public String getSearchKey() {
        return this.searchKey;
    }
}
