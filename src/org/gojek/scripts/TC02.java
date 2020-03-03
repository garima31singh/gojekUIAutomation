package org.gojek.scripts;

import org.gojek.assertions.Asserts;
import org.gojek.base.Base;
import org.gojek.pages.FailurePayment;
import org.gojek.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC02 extends Base {
    @Test

    public void failureFlow(){

        //***Adding Soft assert to verify the URL
        String expected_url= "https://demo.midtrans.com/";
        String actual_url= driver.getCurrentUrl();
        Asserts.compareStrings(actual_url,expected_url);

        //***Calling Homepage method to perform action till check out button
        HomePage home_ref= new HomePage(driver,pr);
        home_ref.homePage();

        //***Calling failure Class Method
        FailurePayment fail_ref= new FailurePayment(driver,pr);
        fail_ref.negativeCreditCardValues();

    }
}
