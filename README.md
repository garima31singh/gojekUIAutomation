#UI Automation Framework 
 
##Project Title
Automation framework for "Website Testing" which includes Payment Success and Failure case and Cross Browser testing such as Firefox and Chrome.  

## Getting Started

##Code Style
Standard

##Technology/Framework Used
```
Technology Used: Java,TestNG, Selenium, Maven
```
```
Framework Used: Page Object Model
```

##Running the tests
In order to Run the scripts,just Right-click on "testng.xml" file. 

##About the framework
The framework consists of three packages named as:

* org.gojek.assertions
* org.gojek.base
* org.gojek.pages
* org.gojek.scripts

####org.gojek.base
This package consists of one java class named: `Base` in which ``@BeforeSuite`` ``@BeforeMethod`` and ``@afterMethod`` are defined.

``@Beforesuite`` : This method is being used to pass the browser name as parameters,initialising the browser driver and defining the conditions to run scripts on multiple browsers. 

``@BeforeMethod`` : This method consists the code to load the properties file,hitting URL after browser launch and maximising the window.

``@AfterMethod``: This method consists the code to close the browser. 

####org.gojek.pages
The package consists three classes named:  ``FailurePayment.java`` ``HomePage.java`` and ``SuccessPayment.java``

``HomePage.java`` : Here, I have passed two global variables Webdriver & properties file and defined two parameterised constructor which later on will be used to call the method directly using class name. There is one testNG annotation ``@Test`` under which a method named ``homePage()``consists the code to click "Buy now" and "check out" button.

``SuccessPayment.java`` : This class consists a method ``creditCardPage()`` where I have written the whole code starting from going to payment gateway method till making payment successful.

``FailurePayment.java`` : This class consists a method ``negativeCreditCardValues()`` where code for failing the payment by entering wrong card details is being written.

####org.gojek.scripts
This package consists two classes ``TC01.java`` and `TC02.java``

``TC01.java`` : This class is extending Base class to launch the browser and has one method defined ``successFlow()`` in which I have firstly added soft assertion to check for URl & Text being displayed and return followed which I have created an object of classes ``HomePage.java`` and ``SuccessPayment.java`` to call respective methods.

`TC02.java`` : This class is extending Base class to launch the browser and has one method defined ``failureFlow``() in which I have firstly added soft assertion to check for URl & Text being displayed and return followed which I have created an object of classes ``HomePage.java`` and ``FailurePayment.java`` to call respective methods.

Methods of both the classes are defined under ``@Test`` annotations.

####org.gojek.Assertions
This package contains one java class ``Asserts.java`` where two static methods are defined to check soft assertion for URL and Texts respectively.

###locators.properties
There is one directory named as ``properties`` under which there is one file ``locators.properties``. I have defined all the elements that have been used to identify web element and stored them in key:value pair.This way, it would be easier to make changes in elements in future. 




 