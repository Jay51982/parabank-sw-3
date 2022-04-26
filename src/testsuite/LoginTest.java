package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Find Username field and insert value
        getTextFromElement(By.xpath("//input[@type='text']"));
        sendTextToElement(By.xpath("//input[@type='text']"),"AbcXyz");


        //Find password field and insert value
        getTextFromElement(By.xpath("//input[@type='password']"));
        sendTextToElement(By.xpath("//input[@type='password']"),"abc123");

        //Find login button and click it
        clickOnElement(By.xpath("//input[@type='submit' ]"));

        // From requirement store value
        String expetedMessage = "Accounts Overview";

        String actualMessage = getTextFromElement(By.xpath("//h1[@class=\"title\"]"));

        // Verify actual message with expected message
        Assert.assertEquals("Login message not matched.",expetedMessage,actualMessage);
    }
    @Test
    public void verifyTheErrorMessage(){
        //Find Username field and invalid insert value
        getTextFromElement(By.xpath("//input[@type='text']"));
        sendTextToElement(By.xpath("//input[@type='text']"),"Abc");

        //Find password field and invalid insert value
        getTextFromElement(By.xpath("//input[@type='password']"));
        sendTextToElement(By.xpath("//input[@type='password']"),"abc");

        //Find login button and click it
        clickOnElement(By.xpath("//input[@type='submit' ]"));

        //From requirement store value
        String expetedMessage = "The username and password could not be verified.";

        String actualMessage = getTextFromElement(By.xpath("//p[@class=\"error\"]"));

        // Verify actual message with expected message

        Assert.assertEquals("Login message not matched.",expetedMessage,actualMessage);
    }
    @Test
    public void userShouldLogOutSuccessfully(){
        //Find Username field and insert value
        getTextFromElement(By.xpath("//input[@type='text']"));
        sendTextToElement(By.xpath("//input[@type='text']"),"AbcXyz");

        //Find password field and insert value
        getTextFromElement(By.xpath("//input[@type='password']"));
        sendTextToElement(By.xpath("//input[@type='password']"),"abc123");

        //Find login button and click it
        clickOnElement(By.xpath("//input[@type='submit']"));

        //Find log out button and click it

       clickOnElement(By.xpath("//a[@href='/parabank/logout.htm']"));

        //From requirement store value
        String expetedMessage = "Customer Login";

        String actualMessage = getTextFromElement(By.xpath("//h2[contains(text(),'Customer Login')]"));

        // Verify actual message with expected message
        Assert.assertEquals("Login message not matched.",expetedMessage,actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
