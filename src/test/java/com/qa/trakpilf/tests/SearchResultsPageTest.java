/**
 * 
 */
package com.qa.trakpilf.tests;

import static org.testng.Assert.assertTrue;

import org.junit.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.trakpilf.pages.HomePage;
import com.qa.trakpilf.pages.SearchResultsPage;

/**
 * @author adarsh
 *
 */
public class SearchResultsPageTest extends BaseTest {

    SearchResultsPage searchResultsPage;

    @BeforeTest
    public void searchPageSetUp() {
        if(homePage != null) {
            homePage.closeLoginPopUp();
            searchResultsPage = homePage.searchInHomePage("Mobiles");
        } else {
            homePage = new HomePage(driver);
//            homePage.backToHomePage();
            searchResultsPage =  homePage.searchInHomePage("Mobiles");
        }
    }

    @Test(priority = 1)
    public void validatePageTitle() {
        if (searchResultsPage.getSearchPageTitle().contains(homePage.getSearchKey())) {
            assertTrue(true);
        } else {
            System.out.println("Search Page title do not match with search key!!!");
        }
    }

    @Test(priority = 2)
    public void validateSetRAMFilter() {
        searchResultsPage.setRAMFilters("2 GB");
    }

    @Test(priority = 3)
    public void validateSelectBrandFilter() {
        searchResultsPage.selectBrand("Gionee");
    }

    @Test(dependsOnMethods = "validateSelectBrandFilter", priority = 4)
    public void validateClearFilter() {
        searchResultsPage.clearFilters("Gionee");
    }

    @Test(priority = 5)
    public void validateMultipleFilters() {

        searchResultsPage.selectBrand("Gionee");
        searchResultsPage.setRAMFilters("2 GB");
        searchResultsPage.getSearchResults();
        searchResultsPage.clearFilters("Gionee");

    }
}
