package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisterTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay() {
        // register name link and click on register link
        clickOnElement(By.linkText("Register"));

        //This message from requirement
        String expectedMessage = "Signing up is easy!";

        //Find elememnt on web and get actual message
        String actualMessage = getTextFromElement(By.xpath("//h1[@class='title']"));


        //Verify actual and expected message
        Assert.assertEquals("Error Message Not Displayed", expectedMessage, actualMessage);
    }

    @Test
    public void verifyShouldRegisterAccountsSuccessfully() {
        //Find log in link and click on login link
        clickOnElement(By.linkText("Register"));

        // Find the first name and enter first name
        getTextFromElement(By.id("customer.firstName"));
        sendTextToElement(By.id("customer.firstName"),"Abc");


        // Find the last name and enter last name
        getTextFromElement(By.id("customer.lastName"));
        sendTextToElement(By.id("customer.lastName"),"Xyz");


        //Find the address and enter the address
        getTextFromElement(By.id("customer.address.street"));
        sendTextToElement(By.id("customer.address.street"),"54 Canary Warf");


        // Find the city and enter the city name
        getTextFromElement(By.id("customer.address.city"));
        sendTextToElement(By.id("customer.address.city"),"London");

        // Find the state name and enter the state name
        getTextFromElement(By.id("customer.address.state"));
        sendTextToElement(By.id("customer.address.state"),"Westminster");

        // Find the zip code and enter the zip code
        getTextFromElement(By.id("customer.address.zipCode"));
        sendTextToElement(By.id("customer.address.zipCode"),"E14 1DA");


        //Find the phone number and enter the phone number
        getTextFromElement(By.id("customer.phoneNumber"));
        sendTextToElement(By.id("customer.phoneNumber"),"07121213344");

        //Find the ssn number end enter the ssn number
        getTextFromElement(By.id("customer.ssn"));
        sendTextToElement(By.id("customer.ssn"),"AB-25-35-45-C");

        //Find the username and enter the username
        getTextFromElement(By.id("customer.username"));
        sendTextToElement(By.id("customer.username"),"AbcXyz1");


        //Find the password field and enter the password
        getTextFromElement(By.id("customer.password"));
        sendTextToElement(By.id("customer.password"), "abc1231");

        //Find the confirm password and enter the confirm password
        getTextFromElement(By.id("repeatedPassword"));
        sendTextToElement(By.id("repeatedPassword"),"abc1231");

        //Find the register field and click on register field
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));

        //This message from requirement
        String expectedMessage = "Your account was created successfully. You are now logged in.";

        String actualMessage = getTextFromElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        System.out.println("Actual Message : " + actualMessage);

        //Verify actual and expected message
        Assert.assertEquals("Cannot Register", expectedMessage, actualMessage);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
