package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
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

public class TestCase15PlaceOrderRegisterBeforeCheckout {
    @Test
    public void test01(){
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        Faker faker = new Faker();
        //Test Case 15: Place Order: Register before Checkout
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationExcerciseUrl"));

        //3. Verify that home page is visible successfully
        Assert.assertTrue(aEP.isHomePageVisible.isDisplayed());

        //4. Click 'Signup / Login' button
        aEP.signUpLogInButton.click();
        //5. Fill all details in Signup and create account
        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        ReusableMethods.makeRegistration();

        //7. Verify ' Logged in as username' at top
        ReusableMethods.bekle(2);
        Assert.assertTrue(aEP.loggedInAsUsername.isEnabled());

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

        //12. Verify Address Details and Review Your Order
        Assert.assertTrue(aEP.firstNameLastNameInAdressDetails.getText().contains(ReusableMethods.name)&&aEP.firstNameLastNameInAdressDetails.getText().contains(ReusableMethods.lastName));
        Assert.assertTrue(aEP.companyNameInAdressDetails.getText().contains(ReusableMethods.companyName));
        Assert.assertTrue(aEP.adress1InAdressDetails.getText().contains(ReusableMethods.adress));
        Assert.assertTrue(aEP.adress2InAdressDetails.getText().contains(ReusableMethods.secondAdress));
        Assert.assertTrue(aEP.stateCityZipCodeInAdressDetails.getText().contains(ReusableMethods.state)&&aEP.stateCityZipCodeInAdressDetails.getText().contains(ReusableMethods.city)&&aEP.stateCityZipCodeInAdressDetails.getText().contains(ReusableMethods.zipCode));
        Assert.assertTrue(aEP.phoneInAdressDetails.getText().contains(ReusableMethods.phoneNumber));
        Assert.assertTrue(aEP.heading2InAdressDetails.isDisplayed());
        //13. Enter description in comment text area and click 'Place Order'
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        aEP.messageInOrderPage.sendKeys(faker.address().fullAddress());
        aEP.placeOrderInOrderPage.click();

        //burada order'a basildi ve google ads geldi ekrana
        System.out.println(Driver.getDriver().getWindowHandle());
        Driver.getDriver().switchTo().newWindow(WindowType.TAB).get(ConfigReader.getProperty("newWindowAfterOrderedProduct"));
        System.out.println(Driver.getDriver().getWindowHandle());



        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        aEP.nameOnCarInOrderPage.sendKeys(faker.name().firstName());
        aEP.cardNumberInOrderPage.sendKeys(faker.business().creditCardNumber());
        aEP.cvcInOrderPage.sendKeys(faker.numerify(ConfigReader.getProperty("cardCVCNumber")));
        String expirationCard = faker.business().creditCardExpiry();
        String[] cardExp = expirationCard.split("-");
        aEP.expiryMonthInOrderPage.sendKeys(cardExp[1]);
        aEP.expiryYearInOrderPage.sendKeys(cardExp[0]);

        //15. Click 'Pay and Confirm Order' button
        aEP.payAndConfirmInOrderPage.click();

        //16. Verify success message 'Your order has been placed successfully!'
        Assert.assertTrue(aEP.yourOrderHasBeenConfirmedAfterOrderPage.isDisplayed());

        //17. Click 'Delete Account' button
        aEP.deleteAccount.click();

        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertTrue(aEP.accountDeletedAfterClickDeleteAccount.isDisplayed());
        aEP.continueButtonAfterClickDeleteAccount.click();
        Driver.quitDriver();
    }
}