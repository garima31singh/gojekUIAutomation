package org.gojek.scripts;

import org.gojek.assertions.Asserts;
import org.gojek.base.Base;
import org.gojek.pages.HomePage;
import org.gojek.pages.SuccessPayment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class TC01 extends Base {
    @Test

    public void successFlow (){

        //*** Adding Soft assert to verify the URL
        String expected_url= "https://demo.midtrans.com/";
        String actual_url= driver.getCurrentUrl();
        Asserts.compareUrl(actual_url,expected_url);

        //*** Adding Soft assert to match text
        String actual_text= driver.findElement(By.xpath(pr.getProperty("buyNow"))).getText();
        String expected_text= "BUY NOW";
        Asserts.compareStrings(actual_text, expected_text);

        //*** Calling Home Page method to perform action till Check out button
        HomePage home_ref= new HomePage(driver,pr);
        home_ref.homePage();

        //***Calling payment screen method to perform action till success page
        SuccessPayment pay_ref= new SuccessPayment(driver,pr);
        pay_ref.creditCardPage();
    }
}
