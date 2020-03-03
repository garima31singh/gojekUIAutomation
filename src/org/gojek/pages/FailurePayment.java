package org.gojek.pages;

import org.gojek.assertions.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class FailurePayment {
    WebDriver driver;
    Properties pr;

    public FailurePayment(WebDriver driver,Properties pr){
        this.driver=driver;
        this.pr=pr;
    }
    @Test
    public void negativeCreditCardValues(){
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
        card_number.sendKeys("4911 1111 1111 1113");

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

        WebElement submit_ok= driver.findElement(By.xpath(pr.getProperty("submitOKButton")));
        submit_ok.click();

        //***Clicking Retry button to go back to Payment method page
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.switchTo().parentFrame();
        WebElement retry_button= driver.findElement(By.xpath(pr.getProperty("retryButton")));
        retry_button.click();

        //***Soft assertion to compare texts
        String actual= "Transaction failed";
        String expected= driver.findElement(By.xpath(pr.getProperty("expected"))).getText();
        System.out.println(expected);
        Asserts.compareStrings(actual,expected);

    }

}
