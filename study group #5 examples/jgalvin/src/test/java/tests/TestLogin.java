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

/**
 * Created by Jennifer Galvin on 1/19/2016.
 */
public class TestLogin {
    private WebDriver driver = null;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        //System .setProperty("webdriver.chrome.driver", "C:/Users/Jennifer/OneDrive/Documents/Meetup/D-CAST/chromedriver.exe");
        //driver = new ChromeDriver();
    }
    @Test
    public void succeeded() {
        driver.get("http://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button")).click();
        assertTrue("success message not present", driver.findElement(By.cssSelector(".flash.success")).isDisplayed());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
