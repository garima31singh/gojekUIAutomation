package org.gojek.pages;

import org.gojek.assertions.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SuccessPayment {
    WebDriver driver;
    Properties pr;

    public SuccessPayment(WebDriver driver, Properties pr){
        this.driver=driver;
        this.pr=pr;
    }
    @Test
    public void creditCardPage(){

        //***adding Implicit wait of seven seconds
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        //***Click Continue Button
        driver.switchTo().frame("snap-midtrans");
        WebElement click_button= driver.findElement(By.xpath(pr.getProperty("continueButton")));
        click_button.click();

        //***Choose Credit card as Payment method
        WebElement credit_card= driver.findElement(By.xpath(pr.getProperty("creditCard")));
        credit_card.click();

        //***Enter Credit Card Details
        WebElement card_number=driver.findElement(By.xpath(pr.getProperty("cardNum")));
        card_number.sendKeys("4811 1111 1111 1114");

        WebElement expiry_date= driver.findElement(By.xpath(pr.getProperty("expiryDate")));
        expiry_date.sendKeys("0221");

        WebElement cvv_num= driver.findElement(By.xpath(pr.getProperty("cvvNum")));
        cvv_num.sendKeys("123");

        WebElement pay_now= driver.findElement(By.xpath(pr.getProperty("payNow")));
        pay_now.click();

        //***Enter Bank's OTP
        WebDriverWait wait= new WebDriverWait(driver,20);
        WebElement iFrame= driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrame);

        WebElement pass= wait.until(ExpectedConditions.presenceOfElementLocated((By.id(pr.getProperty("passwordButton")))));
        pass.sendKeys("112233");
        driver.manage().timeouts().implicitlyWait(30000,TimeUnit.MILLISECONDS);

        WebElement submit_ok= driver.findElement(By.xpath(pr.getProperty("submitOKButton")));
        submit_ok.click();

        //***Soft assertion to compare texts
        String actual_text= "Thank you for your purchase.";
        driver.switchTo().defaultContent();
        String expected_text= driver.findElement(By.xpath(pr.getProperty("expectedText"))).getText();
        System.out.println(expected_text);
        Asserts.compareStrings(actual_text,expected_text);

    }

}
