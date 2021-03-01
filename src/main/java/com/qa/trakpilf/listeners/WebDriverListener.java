/**
 * 
 */
package com.qa.trakpilf.listeners;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.qa.trakpilf.utils.TestUtil;
import com.qa.trakpilf.base.Base;

/**
 * @author adarsh
 *
 */
public class WebDriverListener extends Base implements WebDriverEventListener {

    @Override
    public void beforeAlertAccept(WebDriver driver) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void afterAlertAccept(WebDriver driver) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Trying to find Element By > " + by.toString());
        
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Found Element By > " + by.toString());
        
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Trying to click on > " + element.toString());
        
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicked on: " + element.toString());
        
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Value of the >> " + element.toString() + " << before any changes made. "
                + "chars sent are >> " + keysToSend.toString());
        
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Element value changed to >> " + element.toString()
        + "chars sent are >> " + keysToSend.toString());
        
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        System.out.println("Before script >> " +script);
        
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
        System.out.println("After script >>" +script);
        
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        System.out.println("Exception occured >> look for screenshot >> " + throwable);
        try {
            TestUtil.takeScreenShot();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        // TODO Auto-generated method stub
        
    }

}
