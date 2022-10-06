package com.seleniumtuto.functions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WebDriverFactory {

    private static Properties pro = new Properties();
    private static InputStream in = CreateDriver.class.getResourceAsStream("test.properties");
    private static String resourceFolder;

    private static Logger log = Logger.getLogger(WebDriverFactory.class);

    private static WebDriverFactory instance = null;

    private WebDriverFactory() {

    }

    public static WebDriverFactory getInstance() {
        if (instance == null) {
            instance = new WebDriverFactory();
        }
        return instance;
    }


    public static WebDriver createNewWebDriver(String browser, String os) throws IOException {
        WebDriver driver;
        pro.load(new FileReader("src/test/resources/test.properties"));
        //resourceFolder = prop.getProperty("resourceFolder");

        if ("FIREFOX".equalsIgnoreCase(browser)) {
            driver = new FirefoxDriver();
        } else if ("CHROME".equalsIgnoreCase(browser)) {

            //WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver","C:/driver/chromedriver.exe");
            driver = new ChromeDriver();
        } else if ("INTERNER EXPLORER".equalsIgnoreCase(browser)) {
            driver = new InternetExplorerDriver();
        } else {
            return null;
        }
        driver.manage().window().maximize();
        return driver;
    }
}
