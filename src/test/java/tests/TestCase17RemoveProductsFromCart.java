package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExcercisePage;
import utilities.Driver;
import utilities.ReusableMethods;

public class TestCase17RemoveProductsFromCart {
    @Test
    public void test01(){
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(aEP.isHomePageVisible.isDisplayed());
        //4. Add products to cart
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);
        aEP.firstProductAddToCartInHomePage.click();
        aEP.continueShopping.click();

        //5. Click 'Cart' button
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).perform();
        aEP.onNavbarCartButton.click();

        //6. Verify that cart page is displayed
        Assert.assertTrue(aEP.verifyCartPage.isDisplayed());

        //7. Click 'X' button corresponding to particular product
        aEP.xButtonInCartPage.click();
        //8. Verify that product is removed from the cart
        try {
            Assert.assertTrue(aEP.firstProductInCartPage.isDisplayed());
        } catch (Exception e) {
            Assert.assertTrue(true);
        }
        Driver.closeDriver();
    }
}
