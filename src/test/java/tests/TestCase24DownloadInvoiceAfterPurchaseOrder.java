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

public class TestCase24DownloadInvoiceAfterPurchaseOrder {
    @Test
    public void test24(){
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationExcerciseUrl"));
        //3. Verify that home page is visible successfully
        Assert.assertTrue(aEP.isHomePageVisible.isDisplayed());
        //4. Add products to cart
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(4);
        aEP.firstProductAddToCartInHomePage.click();
        ReusableMethods.bekle(2);
        aEP.continueShopping.click();

        //5. Click 'Cart' button
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.bekle(2);
        aEP.onNavbarCartButton.click();

        //6. Verify that cart page is displayed
        Assert.assertTrue(aEP.verifyCartPage.isDisplayed());

        //7. Click Proceed To Checkout
        aEP.clickProceedToCheckOutInCartPage.click();

        //8. Click 'Register / Login' button
        aEP.registerLoginAfterProceed.click();
        //9. Fill all details in Signup and create account
        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        ReusableMethods.makeRegistration();

        //11. Verify ' Logged in as username' at top
        Assert.assertTrue(aEP.loggedInAsUsername.isDisplayed());

        //12.Click 'Cart' button
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).perform();
        aEP.onNavbarCartButton.click();

        //13. Click 'Proceed To Checkout' button
        aEP.clickProceedToCheckOutInCartPage.click();

        //14. Verify Address Details and Review Your Order
        Assert.assertTrue(aEP.firstNameLastNameInAdressDetails.getText().contains(ReusableMethods.name)&&aEP.firstNameLastNameInAdressDetails.getText().contains(ReusableMethods.lastName));
        Assert.assertTrue(aEP.companyNameInAdressDetails.getText().contains(ReusableMethods.companyName));
        Assert.assertTrue(aEP.adress1InAdressDetails.getText().contains(ReusableMethods.adress));
        Assert.assertTrue(aEP.adress2InAdressDetails.getText().contains(ReusableMethods.secondAdress));
        Assert.assertTrue(aEP.stateCityZipCodeInAdressDetails.getText().contains(ReusableMethods.state)&&aEP.stateCityZipCodeInAdressDetails.getText().contains(ReusableMethods.city)&&aEP.stateCityZipCodeInAdressDetails.getText().contains(ReusableMethods.zipCode));
        Assert.assertTrue(aEP.phoneInAdressDetails.getText().contains(ReusableMethods.phoneNumber));
        Assert.assertTrue(aEP.heading2InAdressDetails.isDisplayed());
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Faker faker = new Faker();
        //15. Enter description in comment text area and click 'Place Order'
        aEP.formTextBoxInOrderingProcess.sendKeys(faker.address().fullAddress());
        aEP.formTextButtonInOrderingProcess.click();
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        aEP.nameOnCarInOrderPage.sendKeys(faker.name().fullName());
        aEP.cardNumberInOrderPage.sendKeys(faker.business().creditCardNumber());
        aEP.cvcInOrderPage.sendKeys(faker.numerify(ConfigReader.getProperty("cardCVCNumber")));
        String expirationCard = faker.business().creditCardExpiry();
        String[] cardExp = expirationCard.split("-");
        aEP.expiryMonthInOrderPage.sendKeys(cardExp[1]);
        aEP.expiryYearInOrderPage.sendKeys(cardExp[0]);

        //17. Click 'Pay and Confirm Order' button
        aEP.popUpAdsInEveryPage.click();
        ReusableMethods.bekle(2);
        aEP.payAndConfirmInOrderPage.click();

        //18. Verify success message 'Your order has been placed successfully!'
        Assert.assertTrue(aEP.yourOrderHasBeenConfirmedAfterOrderPage.isDisplayed());

        //19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
        aEP.downloadInvoiceAfterOrdering.click();
        //20. Click 'Continue' button
        aEP.continueButtonAfterOrdering.click();
        //21. Click 'Delete Account' button
        aEP.deleteAccount.click();
        //22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertTrue(aEP.accountDeletedAfterClickDeleteAccount.isDisplayed());
        aEP.continueButtonAfterClickDeleteAccount.click();
        Driver.closeDriver();

    }
}
