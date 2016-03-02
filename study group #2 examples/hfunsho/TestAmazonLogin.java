package com.selenium.tests.junit;

/**
 * Created by hammidfunsho on 1/24/16.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.selenium.tests.junit.AmazonLogin;

public class TestAmazonLogin {

    private AmazonLogin amaLogin;
    private WebDriver driver;
    private By successLogin = By.cssSelector("./gp/flex/sign-out.html/ref=nav_youraccount_signout?ie=UTF8&action=sign-out&path=%2Fgp%2Fyourstore%2Fhome&signIn=1&useRedirectOnSuccess=1");

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","The path of your local chromedriver");
        driver = new ChromeDriver();
        amaLogin = new AmazonLogin(driver);
    }
    @Test
    public void success() {
        amaLogin.with("yourAmazonUsername", "yourAmazonPassword");
            //assertTrue("Success element not found", amaLogin.successMessage());
    }

    @Test
    public void failed(){
        amaLogin.with("youramazonUsername", "youramazonPassword");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
