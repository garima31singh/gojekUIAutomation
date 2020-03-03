package org.gojek.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public Properties pr;

    @BeforeSuite()
    @Parameters("browser")
    public void crossBrowser(String browser) throws Exception {
        if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("Webdriver.gecko.driver","/gojekUIAutomation/driver/geckodriver");
            driver= new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("WebDriver.Chrome.driver","./driver/chromedriver");
//            driver= new ChromeDriver();
        }
        else {
            throw new Exception("Browser is not correct");
        }

    }
    @BeforeMethod(alwaysRun = true)
    public void browserLaunch() throws IOException {

        //Loading properties file
        File f= new File("./properties/locators.properties");
        FileInputStream fi= new FileInputStream(f);
        pr= new Properties();
        pr.load(fi);

        //code to launch the browser
//        System.setProperty("WebDriver.Chrome.driver","./driver/chromedriver");
//        driver= new FirefoxDriver();
        driver= new ChromeDriver();
        driver.get("https://demo.midtrans.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }
    @AfterMethod(alwaysRun = true)
    public void browserClose(){
        driver.quit();
    }

}
