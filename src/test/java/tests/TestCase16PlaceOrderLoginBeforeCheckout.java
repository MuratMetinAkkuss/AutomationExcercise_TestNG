package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExcercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TestCase16PlaceOrderLoginBeforeCheckout {
    @Test
    public void test01(){
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(aEP.isHomePageVisible.isDisplayed());
        //4. Click 'Signup / Login' button
        aEP.onNavbarSignUpLogInButton.click();
        //5. Fill email, password and click 'Login' button
        ReusableMethods.makeRegistration();
        aEP.logOutButton.click(); // account must be logged out firstly
        aEP.loginToYourAccountWiaEmail.sendKeys(ReusableMethods.eMail);
        aEP.loginToYourAccountWiaPassword.sendKeys(ReusableMethods.passWord);
        aEP.loginToYourAccountWiaLoginButton.click();
        //6. Verify 'Logged in as username' at top
        Assert.assertTrue(aEP.loggedInAsUsername.isDisplayed());
        //7. Add products to cart
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        aEP.firstProductAddToCartInHomePage.click();
        aEP.continueShopping.click();

        //8. Click 'Cart' button
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).perform();
        aEP.onNavbarCartButton.click();

        //9. Verify that cart page is displayed
        Assert.assertTrue(aEP.verifyCartPage.isDisplayed());

        //10. Click Proceed To Checkout
        aEP.clickProceedToCheckOutInCartPage.click();

        //11. Verify Address Details and Review Your Order
        Assert.assertTrue(aEP.firstNameLastNameInAdressDetails.getText().contains(ReusableMethods.name)&&aEP.firstNameLastNameInAdressDetails.getText().contains(ReusableMethods.lastName));
        Assert.assertTrue(aEP.companyNameInAdressDetails.getText().contains(ReusableMethods.companyName));
        Assert.assertTrue(aEP.adress1InAdressDetails.getText().contains(ReusableMethods.adress));
        Assert.assertTrue(aEP.adress2InAdressDetails.getText().contains(ReusableMethods.secondAdress));
        Assert.assertTrue(aEP.stateCityZipCodeInAdressDetails.getText().contains(ReusableMethods.state)&&aEP.stateCityZipCodeInAdressDetails.getText().contains(ReusableMethods.city)&&aEP.stateCityZipCodeInAdressDetails.getText().contains(ReusableMethods.zipCode));
        Assert.assertTrue(aEP.phoneInAdressDetails.getText().contains(ReusableMethods.phoneNumber));
        Assert.assertTrue(aEP.heading2InAdressDetails.isDisplayed());

        //12. Enter description in comment text area and click 'Place Order'
        Faker faker = new Faker();
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        aEP.messageInOrderPage.sendKeys(faker.address().fullAddress());
        aEP.placeOrderInOrderPage.click();

        //in here, there is a google ads comes from page and we should go through it
        System.out.println(Driver.getDriver().getWindowHandle());
        Driver.getDriver().switchTo().newWindow(WindowType.TAB).get(ConfigReader.getProperty("newWindowAfterOrderedProduct"));
        System.out.println(Driver.getDriver().getWindowHandle());

        //13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        aEP.nameOnCarInOrderPage.sendKeys(faker.name().firstName());
        aEP.cardNumberInOrderPage.sendKeys(faker.business().creditCardNumber());
        aEP.cvcInOrderPage.sendKeys(faker.numerify(ConfigReader.getProperty("cardCVCNumber")));
        String expirationCard = faker.business().creditCardExpiry();
        String[] cardExp = expirationCard.split("-");
        aEP.expiryMonthInOrderPage.sendKeys(cardExp[1]);
        aEP.expiryYearInOrderPage.sendKeys(cardExp[0]);

        //14. Click 'Pay and Confirm Order' button
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
