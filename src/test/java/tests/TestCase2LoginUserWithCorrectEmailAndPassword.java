package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExcercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class TestCase2LoginUserWithCorrectEmailAndPassword {
    @Test
    public void test01(){
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //Test Case 2: Login User with correct email and password
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(aEP.isHomePageVisible.isDisplayed());
        //4. Click on 'Signup / Login' button
        aEP.signUpLogInButton.click();
        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(aEP.loginToYourAccountTextElement.isDisplayed());
        //6. Enter correct email address and password
        aEP.loginToYourAccountWiaEmail.sendKeys(ConfigReader.getProperty("loginToYourAccountWiaEmail"));
        aEP.loginToYourAccountWiaPassword.sendKeys(ConfigReader.getProperty("loginToYourAccountWiaPassword"));
        //7. Click 'login' button
        aEP.loginToYourAccountWiaLoginButton.click();
        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(aEP.loggedInAsUsername.isDisplayed());
        //9. Click 'Delete Account' button
        aEP.deleteAccount.click();
        //10. Verify that 'ACCOUNT DELETED!' is visible
        Assert.assertTrue(aEP.accountDeletedAfterClickDeleteAccount.isDisplayed());

    }
}
