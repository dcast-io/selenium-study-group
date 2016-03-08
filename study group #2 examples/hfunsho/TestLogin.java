package com.selenium.tests.junit.tests;


/**
 * Created by hf on 1/13/16.
 */

import com.selenium.tests.junit.tests.Base;
import org.junit.Before;
import org.junit.Test;
import com.selenium.tests.junit.Login;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestLogin extends Base {


    private Login login;

    @Before
     public void setUp(){
        //System.setProperty("webdriver.chrome.driver","The path of your Chromedriver file");
        login = new Login(driver);
    }

    //write a login method which calls the super login
    @Test
   public void succeded(){
        try{
       login.with("tomsmith", "SuperSecretPassword!");
        System.out.println("Page load successful:" + driver.getTitle());
    }catch (Exception e){System.out.println(e);}
        assertTrue("Success Message is not displayed", login.successMessagePresent());

   }
    @Test
    public void failed(){
        login.with("tomsmith", "SuperSecretPassword");
        assertFalse("Failure Message is not displayed", login.successMessagePresent());
    }

}