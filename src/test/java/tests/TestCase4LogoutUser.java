package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExcercisePage;
import utilities.Driver;

public class TestCase4LogoutUser {
    @Test
    public void test03(){
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //Test Case 4: Logout User
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
        // i'am going to use Make Registration class
        MakeRegistration makeRegistration = new MakeRegistration();
        makeRegistration.makeRegistration();
        aEP.loginToYourAccountWiaEmail.sendKeys(makeRegistration.eMail);
        aEP.loginToYourAccountWiaPassword.sendKeys(makeRegistration.passWord);
        //7. Click 'login' button
        aEP.loginToYourAccountWiaLoginButton.click();
        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(aEP.loggedInAsUsername.isDisplayed());
        //9. Click 'Logout' button
        aEP.logOutButton.click();
        //10. Verify that user is navigated to login page
        Assert.assertTrue(aEP.loginToYourAccountTextElement.isDisplayed());
        Driver.closeDriver();
    }
}
