package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExcercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class TestCase5RegisterUserWithExistingEmail extends TestBaseReport {
    @Test
    public void test01(){
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //Test Case 5: Register User with existing email
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(aEP.isHomePageVisible.isDisplayed());
        //4. Click on 'Signup / Login' button
        aEP.onNavbarSignUpLogInButton.click();
        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(aEP.isNewUserSignupSign.isDisplayed());
        //6. Enter name and already registered email address
        aEP.signupName.sendKeys(ConfigReader.getProperty("existingName"));
        aEP.signupEmail.sendKeys(ConfigReader.getProperty("existingMail"));
        //7. Click 'Signup' button
        aEP.signUpButton.click();
        //8. Verify error 'Email Address already exist!' is visible
        Assert.assertTrue(aEP.accountAlreadyExsist.isDisplayed());
        Driver.closeDriver();

    }
}
