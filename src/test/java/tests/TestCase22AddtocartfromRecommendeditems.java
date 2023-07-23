package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExcercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class TestCase22AddtocartfromRecommendeditems {
    @Test
    public void test22() throws InterruptedException {
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationExcerciseUrl"));
        //3. Scroll to bottom of page
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(4000);
        //4. Verify 'RECOMMENDED ITEMS' are visible
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP ).sendKeys(Keys.PAGE_UP).perform();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(aEP.recommendedItemsInHomePage));
        Assert.assertTrue(aEP.recommendedItemsInHomePage.isDisplayed());
        //5. Click on 'Add To Cart' on Recommended product
        aEP.popUpAdsInEveryPage.click();
        ReusableMethods.bekle(2);
        aEP.addToCarRecommendedProductInHomePage.click();
        //6. Click on 'View Cart' button
        aEP.viewCartButtonAfterClickAddToCart.click();
        //7. Verify that product is displayed in cart page
        Assert.assertTrue(aEP.firstProductInCartPage.isDisplayed());
        Driver.closeDriver();
    }
}
