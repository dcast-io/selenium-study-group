//test the explicit waits for Dyamic elements

package com.selenium.tests.junit;

/**
 * Created by hammidfunsho on 1/18/16.
 */


import com.selenium.tests.junit.rules.DynamicLoading;
import com.selenium.tests.junit.tests.Base;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
//test

public class TestDynamicLogin  extends Base{

    //declare variables
    private DynamicLoading dynamicLogin;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "The path of your Chromedriver file");
        dynamicLogin = new DynamicLoading(driver);
    }

    //This method will call the Dynamic wait method and assert that it completes successfully
    @Test
    public void hiddenElements(){
        dynamicLogin.loadExample("1");
        assertTrue("finish text didn't display after loading",
        dynamicLogin.finishTextPresent());
    }

    @Test
    public void elementAppears(){
        dynamicLogin.loadExample("2");
        assertTrue("finish text didn't display after loading",
                dynamicLogin.finishTextPresent());
    }


}
