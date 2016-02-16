//filename: tests/TestLogin.java
package tests;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import pageobjects.Login;
import screenshots.Screenshotter;

/**
 * Created by Jennifer Galvin on 1/19/2016.
 */
public class TestLogin {
    private WebDriver driver;
    private Login login;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        //System .setProperty("webdriver.chrome.driver", "C:/Users/Jennifer/OneDrive/Documents/Meetup/D-CAST/chromedriver.exe");
        //driver = new ChromeDriver();
        login = new Login(driver);
    }
    @Test
    public void succeeded() throws Exception {
        try
        {
            login.with("tomsmith", "SuperSecretPassword!");
            assertTrue("success message not present", login.successMessagePresent());
        }
        catch (Exception e)
        {
           Screenshotter screenshotter = new Screenshotter();
           screenshotter.getScreenshot(driver, "E:\\SeleniumScreenshots");
        }
    }

    @Test
    public void failed() throws Exception {
        try
        {
            login.with("tomsmith", "badPassword");
            assertFalse("failure message not present", login.successMessagePresent());

            // Take a screenshot anyway
            Screenshotter screenshotter = new Screenshotter();
            screenshotter.getScreenshot(driver, "E:\\SeleniumScreenshots");
        }
        catch (Exception e)
        {
            // Take a screenshot if we excepted (for any reason)
            Screenshotter screenshotter = new Screenshotter();
            screenshotter.getScreenshot(driver, "E:\\SeleniumScreenshots");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
