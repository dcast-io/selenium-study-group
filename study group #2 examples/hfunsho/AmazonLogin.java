//class containing login functionality for amazon.on
//converting the amazon login to page objects style

package com.selenium.tests.junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.selenium.tests.junit.Base;

/**
 * Created by hammidfunsho on 1/14/16.
 */
public class AmazonLogin extends Base {

    //declare the required variables, in this case the object locators
    //private WebElement ap_email;
    //private WebElement ap_password;
    //private WebElement signInSubmit;
    //private WebElement nav_link_yourAccount;



    By userNameLocator = By.id("ap_email");
    By passwordLocator = By.id("ap_password");
    By navLinkLocator = By.id("nav-link-yourAccount");
    By submitButtonLocator = By.id("signInSubmit");
    By successMessageLocator = By.cssSelector("/gp/flex/sign-out.html/ref=nav_youraccount_signout?ie=UTF8&action=sign-out&path=%2Fgp%2Fyourstore%2Fhome&signIn=1&useRedirectOnSuccess=1");



    //initiate the webdriver and navigate to the website
    public AmazonLogin(WebDriver driver){
        super(driver);
        //System.setProperty("webdriver.chrome.driver", "The path of your local chromedriver");
        visit("https://www.amazon.com");
    }

    //methods

    //click the login link
    public void with(String userName, String password){
        try {
            click(navLinkLocator);
            type(userName, userNameLocator);
            type(password, passwordLocator);
            click(submitButtonLocator);
            //assertTrue("Success message not present", driver.findElement(successMessageLocator).isDisplayed());
        }catch (Exception e){System.out.println(e);}
    }

    public boolean successMessage(){

        return isDisplayed(successMessageLocator);
    }


    //validate login (to be implemented at a later date
}
