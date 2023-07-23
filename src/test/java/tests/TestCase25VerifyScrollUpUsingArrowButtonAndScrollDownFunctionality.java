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

public class TestCase25VerifyScrollUpUsingArrowButtonAndScrollDownFunctionality {
    @Test
    public void test25() throws InterruptedException {
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationExcerciseUrl"));
        //3. Verify that home page is visible successfully
        Assert.assertTrue(aEP.isHomePageVisible.isDisplayed());
        //4. Scroll down page to bottom
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        //5. Verify 'SUBSCRIPTION' is visible
        Assert.assertTrue(aEP.subscriptionTextIntFooter.isDisplayed());
        //6. Click on arrow at bottom right side to move upward
        ReusableMethods.bekle(2);
        aEP.popUpAdsInEveryPage.click();
        ReusableMethods.bekle(2);
        aEP.arrowToMoveUpwarInHomePage.click();
        //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        Assert.assertTrue(aEP.fullFledgedTextInHomePage.isDisplayed());
        Driver.closeDriver();
    }
}
