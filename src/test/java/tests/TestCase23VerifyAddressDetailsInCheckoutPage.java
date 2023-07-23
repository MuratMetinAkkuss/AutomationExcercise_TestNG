package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExcercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class TestCase23VerifyAddressDetailsInCheckoutPage {
    @Test
    public void test23() throws InterruptedException {
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationExcerciseUrl"));
        //3. Verify that home page is visible successfully
        Assert.assertTrue(aEP.isHomePageVisible.isDisplayed());
        //4. Click 'Signup / Login' button
        aEP.onNavbarSignUpLogInButton.click();
        //5. Fill all details in Signup and create account
        ReusableMethods.makeRegistration();
        //7. Verify ' Logged in as username' at top
        Assert.assertTrue(aEP.loggedInAsUsername.isDisplayed());

        //8. Add products to cart
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(4);
        aEP.firstProductAddToCartInHomePage.click();
        ReusableMethods.bekle(2);
        aEP.continueShopping.click();

        //9. Click 'Cart' button
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.bekle(2);
        aEP.onNavbarCartButton.click();

        //10. Verify that cart page is displayed
        Assert.assertTrue(aEP.verifyCartPage.isDisplayed());

        //11. Click Proceed To Checkout

        aEP.clickProceedToCheckOutInCartPage.click();

        //12. Verify that the delivery address is same address filled at the time registration of account
        Assert.assertTrue(aEP.firstNameLastNameInAdressDetails.getText().contains(ReusableMethods.name)&&aEP.firstNameLastNameInAdressDetails.getText().contains(ReusableMethods.lastName));
        Assert.assertTrue(aEP.companyNameInAdressDetails.getText().contains(ReusableMethods.companyName));
        Assert.assertTrue(aEP.adress1InAdressDetails.getText().contains(ReusableMethods.adress));
        Assert.assertTrue(aEP.adress2InAdressDetails.getText().contains(ReusableMethods.secondAdress));
        Assert.assertTrue(aEP.stateCityZipCodeInAdressDetails.getText().contains(ReusableMethods.state)&&aEP.stateCityZipCodeInAdressDetails.getText().contains(ReusableMethods.city)&&aEP.stateCityZipCodeInAdressDetails.getText().contains(ReusableMethods.zipCode));
        Assert.assertTrue(aEP.phoneInAdressDetails.getText().contains(ReusableMethods.phoneNumber));
        Assert.assertTrue(aEP.heading2InAdressDetails.isDisplayed());

        //13. Verify that the billing address is same address filled at the time registration of account
        Assert.assertTrue(aEP.firstNameLastNameInBillDetails.getText().contains(ReusableMethods.name)&&aEP.firstNameLastNameInAdressDetails.getText().contains(ReusableMethods.lastName));
        Assert.assertTrue(aEP.companyNameInBillDetails.getText().contains(ReusableMethods.companyName));
        Assert.assertTrue(aEP.adress1InBillDetails.getText().contains(ReusableMethods.adress));
        Assert.assertTrue(aEP.adress2InBillDetails.getText().contains(ReusableMethods.secondAdress));
        Assert.assertTrue(aEP.stateCityZipCodeInBillDetails.getText().contains(ReusableMethods.state)&&aEP.stateCityZipCodeInAdressDetails.getText().contains(ReusableMethods.city)&&aEP.stateCityZipCodeInAdressDetails.getText().contains(ReusableMethods.zipCode));
        Assert.assertTrue(aEP.phoneInBillDetails.getText().contains(ReusableMethods.phoneNumber));


        //14. Click 'Delete Account' button
        aEP.deleteAccount.click();
        //15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertTrue(aEP.accountDeletedAfterClickDeleteAccount.isDisplayed());
        aEP.continueButtonAfterClickDeleteAccount.click();
        Driver.closeDriver();

    }
}
