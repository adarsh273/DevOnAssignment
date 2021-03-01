/**
 * 
 */
package com.qa.trakpilf.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.trakpilf.pages.SearchResultsPage;

/**
 * @author adarsh
 *
 */
public class SearchResultsPageTest extends BaseTest {

    SearchResultsPage searchResultsPage;

    @BeforeTest
    public void searchPageSetUp() {
        homePage.closeLoginPopUp();
        searchResultsPage = homePage.searchInHomePage("Mobiles");
    }

    @Test
    public void validatePageTitle() {
        if (searchResultsPage.getSearchPageTitle().contains(homePage.getSearchKey())) {
            assertTrue(true);
        } else {
            System.out.println("Search Page title do not match with search key!!!");
        }
    }

    @Test
    public void validateSetRAMFilter() {
        searchResultsPage.setRAMFilters("2 GB");
    }

    @Test
    public void validateSelectBrandFilter() {
        searchResultsPage.selectBrand("Gionee");
    }

    @Test(dependsOnMethods = "validateSelectBrandFilter")
    public void validateClearFilter() {
        searchResultsPage.clearFilters("Gionee");
    }

    @Test
    public void validateMultipleFilters() {

        searchResultsPage.selectBrand("Gionee");
        searchResultsPage.setRAMFilters("2 GB");
        searchResultsPage.getSearchResults();
        searchResultsPage.clearFilters("Gionee");

    }
}
