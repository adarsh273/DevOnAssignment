/**
 * 
 */
package com.qa.trakpilf.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.trakpilf.base.Base;

/**
 * @author adarsh
 *
 */
public class TestUtil extends Base {

    public static String takeScreenShot() throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
        File dest = new File(path);
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    // log4j date setup
    public static void setDateForLog4j() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy hhmmss");
        System.setProperty("current_date", dateFormat.format(new Date()));
        PropertyConfigurator.configure("./src/main/java/com/qa/trakpilf/config/config.properties");
    }
}
