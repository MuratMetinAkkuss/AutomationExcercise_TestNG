package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExcercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TestCase13VerifyProductQuantityInCart {
    @Test
    public void test01(){
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //Test Case 11: Verify Subscription in Cart page
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationExcerciseUrl"));
        //3. Verify that home page is visible successfully
        Assert.assertTrue(aEP.isHomePageVisible.isDisplayed());
        //4. Click 'View Product' for any product on home page
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).moveToElement(aEP.firstProductViewProductButtonInHomePage).perform();
        actions = new Actions(Driver.getDriver());
        actions.click(aEP.firstProductViewProductButtonInHomePage).perform();
        //5. Verify product detail is opened
        Assert.assertTrue(aEP.firstProductInformationInProductPage.isDisplayed());
        //6. Increase quantity to 4
        aEP.increaseButtonInFirstProductPage.clear();
        aEP.increaseButtonInFirstProductPage.sendKeys(ConfigReader.getProperty("increaseQuantity"));
        //7. Click 'Add to cart' button
        aEP.addToCartButtonInFirstProductPage.click();
        //8. Click 'View Cart' button
        aEP.viewCartButtonAfterClickAddToCart.click();
        //9. Verify that product is displayed in cart page with exact quantity
        String expectedQuantity = ConfigReader.getProperty("increaseQuantity");
        String actualQuantity = aEP.firstProductQuantityInCart.getText();

        Assert.assertEquals(actualQuantity,expectedQuantity);

        Driver.closeDriver();
    }
}
