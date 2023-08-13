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

import java.time.Duration;

public class TestCase26VerifyScrollUpWithoutArrowButtonAndScrollDownFunctionality {
    @Test
    public void test26(){
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
        //6. Scroll up page to top
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.UP).perform();
        //7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOf(aEP.fullFledgedTextInHomePage));
        Assert.assertTrue(aEP.fullFledgedTextInHomePage.isDisplayed());
        Driver.closeDriver();
    }
}
