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

public class TestCase8VerifyAllProductsAndProductDetailPage {
    @Test
    public void test01(){
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationExcerciseUrl"));
        //3. Verify that home page is visible successfully
        Assert.assertTrue(aEP.isHomePageVisible.isDisplayed());
        //4. Click on 'Products' button
        aEP.onNavbarProductsButton.click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        //6. The products list is visible
        Assert.assertTrue(aEP.allProductsInProductPage.isDisplayed());
        //7. Click on 'View Product' of first product
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);
        aEP.firstProductInProductPage.click();
        //8. User is landed to product detail page
        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        Assert.assertTrue(aEP.firstProductNameInFirstProductPage.isDisplayed());
        Assert.assertTrue(aEP.firstProductCategoryInFirstProductPage.isDisplayed());
        Assert.assertTrue(aEP.firstProductPriceInFirstProductPage.isDisplayed());
        Assert.assertTrue(aEP.firstProductAvailabilityInFirstProductPage.isDisplayed());
        Assert.assertTrue(aEP.firstProductConditionInFirstProductPage.isDisplayed());
        Assert.assertTrue(aEP.firstProductBrandInFirstProductPage.isDisplayed());
        Driver.closeDriver();
    }
}
