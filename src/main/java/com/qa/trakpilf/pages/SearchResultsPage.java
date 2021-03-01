/**
 * 
 */
package com.qa.trakpilf.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.trakpilf.base.Base;
import com.qa.trakpilf.utils.ElementUtil;

/**
 * @author adarsh
 *
 */
public class SearchResultsPage extends Base {
    private WebDriver driver;
    private ElementUtil elementUtil;

    // variables
    private String byVariables;

    // By objects
    // Filter
    By filtersText = By.xpath("//span[normalize-space()='Filters']");
    By filterSelectionElements = By
            .xpath("//span[normalize-space()='Filters']//ancestor::section/div/following-sibling::div//*[contains(text(),'" + byVariables + "')]");
    // Mobile
    By mobileCategory = By.xpath("//a[@title='Mobiles']");
    By ramElement = By.xpath("//section/div/div[contains(text(),'RAM')]");
    By ramFilterElements = By.xpath("//section/div/div[contains(text(),'RAM')]/../../div[2]/div/div");
    By ramClearFilter = By.xpath("//section/div/div[contains(text(),'RAM')]/ancestor::section/div//span[contains(text(),'Clear')]");
    // Brand
    By brandElement = By.xpath("//div[text()='Brand']");
    By searchBrand = By.xpath("//input[@placeholder=\"Search Brand\"]");
    By brandToSelect = By.xpath("//div[@title=\"" + byVariables + "\"]"); // //div[@title="Gionee"]

    // Search Results
    By seacrhResults = By.xpath("//span[.='Showing 1 – 22 of 22 results for \"Mobiles\"']/../../../../div");

    /**
     * @param driver
     */
    public SearchResultsPage(WebDriver driver) {
        System.out.println("SearchResultsPage object created");
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    public String getSearchPageTitle() {
        return driver.getTitle();
    }

    public void setRAMFilters(String ram) {
        try {
//            Thread.sleep(3000);
            if (elementUtil.waitForElementPresent(ramElement, 3)) {
                elementUtil.selectElementFromList(ramFilterElements, ram);
            } else {
                System.out.println("Something wrong > setRAMFilters");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void selectBrand(String brand) {
        this.byVariables = brand;
        try {
            elementUtil.waitForElementPresent(mobileCategory, 3);
            elementUtil.scrollTillElementVisible(this.brandElement);
            if (elementUtil.waitForElementPresent(brandElement, 2)) {
                elementUtil.getElement(searchBrand).sendKeys(brand);
                elementUtil.getElement(getBrandToSelectXPath(brand)).click();
                elementUtil.moveToPosition();
            } else {
                System.out.println("Something wrong > setRAMFilters");
            }
//            try {
//            Thread.sleep(3000);
//            elementUtil.scrollTillElementVisible(this.brandElement);
//           Thread.sleep(3000); 
//            elementUtil.getElement(searchBrand).sendKeys(brand);
//              Thread.sleep(3000);
//              elementUtil.getElement(getBrandToSelectXPath(brand)).click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectMultipleFiltersForMobile() {

    }

    public void clearRamFilter() {
        elementUtil.moveToPosition();
        WebElement elem = elementUtil.getElement(ramClearFilter);
        if (elem.isDisplayed()) {
            elem.click();
        } else {
            System.out.println("RAM filter not selected to clear!!!");
        }
    }

    public void clearFilters(String... strings) {
        elementUtil.moveToPosition();
        if (strings.length != 0) {
            for (String str : strings) {
                elementUtil.getElement(getFilterElement(str)).click();
            }
        } else {
            System.out.println("Pass filters as argument to clear");
        }
    }

    // get the search results
    
    public void getSearchResults() {
        List<WebElement> resultList = elementUtil.getElementsList(seacrhResults);
        System.out.println(resultList.size());
        for(WebElement res : resultList) {
            System.out.println(res.getText());
        }
    }
    
    
    private By getBrandToSelectXPath(String var) {
        if (var != null) {
            this.brandToSelect = By.xpath("//div[@title=\"" + var + "\"]");
        }
        return brandToSelect;
    }

    private By getFilterElement(String var) {
        if (!var.isBlank()) {
            this.filterSelectionElements = By
                    .xpath("//span[normalize-space()='Filters']//ancestor::section/div/following-sibling::div//*[contains(text(),'" + var + "')]");
        }
        return filterSelectionElements;
    }

}
