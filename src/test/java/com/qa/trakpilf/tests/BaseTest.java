/**
 * 
 */
package com.qa.trakpilf.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.trakpilf.base.Base;
import com.qa.trakpilf.pages.HomePage;

/**
 * @author adarsh
 *
 */
public class BaseTest {
    public WebDriver driver;
    public Properties prop;
    public Base base;
    public HomePage homePage;
    
    @BeforeTest
    public void setUp() {
        base = new Base();
        prop = base.initProperties();
        driver = base.initDriver(prop);
        homePage = new HomePage(driver);
    }

    @AfterTest
    public void tearDown() {
//        driver.quit();
    }
}
