/**
 * 
 */
package com.qa.trakpilf.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.trakpilf.testdata.Constants;

/**
 * @author adarsh
 *
 */
public class HomePageTest extends BaseTest {
    @Test(priority = 1)
    public void verifyHomePageTitle() {
        Assert.assertEquals(homePage.getHomePageTitle(), Constants.HOME_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void searchInPage() {
        homePage.closeLoginPopUp();
        homePage.searchInHomePage("Mobiles");
        homePage.backToHomePage();
    }

}
