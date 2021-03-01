/**
 * 
 */
package com.qa.trakpilf.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.trakpilf.listeners.WebDriverListener;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author adarsh
 *
 */
public class Base {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Base.class));
    public static WebDriver driver;
    EventFiringWebDriver e_driver; // to be implemented, WebDriverEventListener
    WebDriverListener eventListener;
    Properties prop;

    public WebDriver initDriver(Properties prop) {
        String browser = prop.getProperty("browser");

        LOGGER.info("Browser: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            System.out.println(browser + " not found!!!");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

        // Event firing WebDriver to capture all WebDriver logs
        e_driver = new EventFiringWebDriver(driver);
        // object of EventListenerHandler to register it with EventFiringWebDriver
        eventListener = new WebDriverListener();
        e_driver.register(eventListener);
        driver = e_driver;

        return driver;
    }

    public Properties initProperties() {

        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("./src/main/java/com/qa/trakpilf/config/config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    /**
     * Take the screenshot
     *  to be placed in utils?
     * @return path
     */
    public String getScreenshot() {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
