package org.gojek.assertions;

public class Asserts {
	
    public static void compareUrl(String actual_url,String expected_url){
        if(actual_url.contains(expected_url)){
            System.out.println("Soft assert passed as Actual url equals to Expected url " + actual_url + expected_url);
        }
        else{
            System.out.println("Soft assert failed as Actual url does not matches with Expected url " + actual_url + expected_url);
        }
    }
    public static void compareStrings(String actual_text,String expected_text){
        if(actual_text.equals(expected_text)){
            System.out.println("Assertion passed as Actual and Expected Text matches " + actual_text + expected_text);
        }
        else{
            System.out.println("Assertion failed as Actual does not matches Expected Text " + actual_text   + expected_text);

        }
    }
}
