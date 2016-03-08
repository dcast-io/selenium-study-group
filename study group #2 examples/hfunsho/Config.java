//Config class to hold the base url

package com.selenium.tests.junit.tests;

/**
 * Created by hammidfunsho on 1/28/16.
 */
public class Config {

    public static final String baseUrl = System.getProperty("baseUrl", "http://the-internet.herokuapp.com");

    public static final String browser = System.getProperty("browser", "chrome");

    public static final String host = System.getProperty("host", "localhost");

    public static final String browserVersion = System.getProperty("browserVersion", "47");

    public static final String platform = System.getProperty("platform", "Mac");

    public static final String sauceUser = "your saucelabs url";

    public static final String sauceKey = "your saucelabs key";


}
