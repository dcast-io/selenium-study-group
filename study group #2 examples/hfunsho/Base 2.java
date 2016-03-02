//This class will contain all the Setup and Teardown methods used in all Test execution

package com.selenium.tests.junit.tests;

/**
 * Created by hammidfunsho on 1/28/16.
 */

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import com.saucelabs.saucerest.SauceREST;

import static com.selenium.tests.junit.tests.Config.*;

public class Base {

    protected WebDriver driver;
    private String testName;
    private String sessionId;
    private SauceREST sauceClient;


    @Rule
    public ExternalResource resource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            if (host.equals("saucelabs")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("browsername", browser);
                capabilities.setCapability("version", browserVersion);
                capabilities.setCapability("platform", platform);
                capabilities.setCapability("name", testName);
                String sauceUrl = String.format("http://%s:%s@ondemand.saucelabs.com:80/wd/hub", sauceUser, sauceKey);
                driver = new RemoteWebDriver(new URL(sauceUrl), capabilities);
                sessionId = ((RemoteWebDriver) driver).getSessionId().toString();
                sauceClient = new SauceREST(sauceUser, sauceKey);
            } else if (host.equals("localhost")) {
                if (browser.equals("firefox")) {
                    driver = new FirefoxDriver();
                } else if (browser.equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver",
                            System.getProperty("user.dir") + "/vendor/chromedriver");
                    driver = new ChromeDriver();
                }
            }
        }

    @Override
    protected void after() {
        driver.quit();
    }

    };

    @Rule
    public TestRule watcher = new TestWatcher() {
        @Override
        public void starting(Description description) {
            testName = description.getDisplayName();
        }

        @Override
        protected void failed(Throwable throwable, Description description){
            if(host.equals("saucelabs")){
                sauceClient.jobFailed(sessionId);
                System.out.println(String.format("https://saucelabs.com/tests/%", sessionId));
            }
        }

        @Override
        protected void succeeded(Description description){
            if(host.equals("saucelabs")){
                sauceClient.jobPassed(sessionId);
            }
        }
    };

}
