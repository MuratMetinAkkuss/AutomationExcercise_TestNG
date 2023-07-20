package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExcercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TestCase12AddProductsinCart {
    @Test
    public void test01(){
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //Test Case 11: Verify Subscription in Cart page
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationExcerciseUrl"));
        //3. Verify that home page is visible successfully
        Assert.assertTrue(aEP.isHomePageVisible.isDisplayed());
        //4. Click 'Products' button
        aEP.onNavbarProductsButton.click();
        ReusableMethods.bekle(3);
        //5. Hover over first product and click 'Add to cart'
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions = new Actions(Driver.getDriver());
        actions.moveToElement(aEP.firstProductInProductPage).perform();
        actions = new Actions(Driver.getDriver());
        actions.click(aEP.clickAddToCartForFirstProduct).perform();
        //6. Click 'Continue Shopping' button
        aEP.continueShopping.click();
        //7. Hover over second product and click 'Add to cart'
        actions = new Actions(Driver.getDriver());
        actions.moveToElement(aEP.clickAddToCartForSecondProduct).perform();
        aEP.clickAddToCartForSecondProduct.click();
        //8. Click 'View Cart' button
        aEP.viewCartButtonAfterClickAddToCart.click();
        //9. Verify both products are added to Cart
        String firstItemQuantityStr =aEP.firstProductQuantityInCart.getText();
        String secondItemQuantityStr = aEP.secondProductQuantityInCart.getText();
        int firstItemQuantity = Integer.parseInt(firstItemQuantityStr);
        int secondItemIntQuantity = Integer.parseInt(secondItemQuantityStr);
        Assert.assertTrue(firstItemQuantity > 0);
        Assert.assertTrue(secondItemIntQuantity > 0);
        //Verify their prices, quantity and total price
        //i put quantity before this step so i wont create a new one
        String firstProductPriceStr = aEP.firstProductPriceInCart.getText().substring(4);
        String secondProductPriceStr = aEP.secondProductPriceInCart.getText().substring(4);
        int firstProductPrice = Integer.parseInt(firstProductPriceStr);
        int firstProductTotal = firstProductPrice*firstItemQuantity;
        int secondProductPrice = Integer.parseInt(secondProductPriceStr);
        int secondProductTotal = secondProductPrice*secondItemIntQuantity;

        int firstProductExpectedPrice =Integer.parseInt(ConfigReader.getProperty("firstProductPrice"));
        int secondProductExpectedPrice =Integer.parseInt(ConfigReader.getProperty("secondProductPrice"));

        Assert.assertEquals(firstProductPrice,firstProductExpectedPrice);//first product price will be checked
        Assert.assertEquals(secondProductPrice,secondProductExpectedPrice);//second one price will be checked

        int firstProductExpectedQuantity =Integer.parseInt(ConfigReader.getProperty("firstProductQuantity"));
        int secondProductExpectedQuantity =Integer.parseInt(ConfigReader.getProperty("secondProductQuantity"));

        Assert.assertEquals(firstItemQuantity,firstProductExpectedQuantity);//quantity will check here for first product
        Assert.assertEquals(secondItemIntQuantity,secondProductExpectedQuantity);//quantity will check here for second product

        int firstProductExpectedTotal =Integer.parseInt(ConfigReader.getProperty("firstProductTotal"));
        int secondProductExpectedTotal =Integer.parseInt(ConfigReader.getProperty("secondProductTotal"));

        Assert.assertEquals(firstProductTotal,firstProductExpectedTotal);
        Assert.assertEquals(secondProductTotal,secondProductExpectedTotal);




    }
}
