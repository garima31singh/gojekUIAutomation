package org.gojek.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class HomePage {
    WebDriver driver;
    Properties pr;

    public HomePage(WebDriver driver, Properties pr){
        this.driver=driver;
        this.pr=pr;
    }
    @Test
    public void homePage() {
        //***adding Implicit wait of seven seconds
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        //***Clicking Buy now button
        WebElement buy_now = driver.findElement(By.xpath(pr.getProperty("buyNow")));
        buy_now.click();

        //***Clicking Checkout button
        WebElement checkout_button = driver.findElement(By.xpath(pr.getProperty("checkOut")));
        checkout_button.click();
    }
}
