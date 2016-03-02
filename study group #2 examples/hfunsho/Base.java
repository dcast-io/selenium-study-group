//Base class encompassing all basic page functionality (clicks etc)
//This class will be of the WebDriver type and will contain its getter methods

package com.selenium.tests.junit;

/**
 * Created by hammidfunsho on 1/16/16.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.selenium.tests.junit.tests.Config.*;

public class Base {

 public WebDriver driver;


    public Base(WebDriver driver){
        this.driver = driver;
    }


    public void visit(String url){

        if (url.contains("http")) {
            driver.get(url);
        }else { driver.get(baseUrl + url);}

        System.out.println("Navigating to " + url);
        System.out.println("Thread id = " + Thread.currentThread().getId());
        //try {
        //    driver.get(url);
        //}catch(Exception e){
        //    System.out.println("URL did not load " + e);
       // }
    }

    //getter method to find an element by locator
    public WebElement find(By locator){
        return driver.findElement(locator);
    }


    //getter method to click a button
    public void click(By locator)
    {
        find(locator).click();
    }


    //getter method to input data
    public void type(String input, By locator)
    {
        find(locator).sendKeys(input);
    }


    public String getPageTitle()
    {
        return driver.getTitle();
    }


    //getter method to validate an element is displayed
    public boolean isDisplayed(By locator) {
        //find the element by locator and return true if found, otherwise return false
        try {
            return find(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException exception) {
            return false;
        }
    }


//    method to wait for elements to load or timeout in a specified amount of time
//    This will build on seleniums built in wait functionality to create a custom wait method that is more intelligent

    public void waitFor(ExpectedCondition<WebElement>condition, Integer timeout){
        timeout = timeout != null ? timeout : 5;

            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(condition);

    }

    public Boolean waitForIsDisplayed(By locator, Integer... timeout){
        try
        {
            waitFor(ExpectedConditions.visibilityOfElementLocated(locator),(timeout.length > 0 ? timeout[0] : null));

        }catch (org.openqa.selenium.TimeoutException exception){
            return false;
        }
        return true;
}
}