package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExcercisePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.ObjectInputFilter;

public class TestCase3LoginUserWithIncorrectEmailAndPassword {
    @Test
    public void test01(){
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(aEP.isHomePageVisible.isDisplayed());
        //4. Click on 'Signup / Login' button
        aEP.signUpLogInButton.click();
        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(aEP.loginToYourAccountTextElement.isDisplayed());
        //6. Enter incorrect email address and password
        aEP.loginToYourAccountWiaEmail.sendKeys(ConfigReader.getProperty("incorrectMail"));
        aEP.loginToYourAccountWiaPassword.sendKeys(ConfigReader.getProperty("incorrectPassword"));
        //7. Click 'login' button
        aEP.loginToYourAccountWiaLoginButton.click();
        //8. Verify error 'Your email or password is incorrect!' is visible
        Assert.assertTrue(aEP.incorrectLogInSignText.isDisplayed());
        Driver.closeDriver();
    }
}
