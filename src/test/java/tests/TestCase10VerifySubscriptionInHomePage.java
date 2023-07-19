package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExcercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class TestCase10VerifySubscriptionInHomePage {
    @Test
    public void test01(){
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationExcerciseUrl"));
        //3. Verify that home page is visible successfully
        Assert.assertTrue(aEP.isHomePageVisible.isDisplayed());
        //4. Scroll down to footer
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollToElement(aEP.footerElementInHomePage).perform();
        //5. Verify text 'SUBSCRIPTION'
        Assert.assertTrue(aEP.subscriptionTextIntFooter.isDisplayed());
        //6. Enter email address in input and click arrow button
        Faker faker = new Faker();
       aEP.subscriptionBoxInFooter.sendKeys(faker.internet().emailAddress());
       aEP.submitSubscriptionInFooter.click();
       //7. Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertTrue(aEP.successfullySubscribedInFooter.isDisplayed());
        Driver.closeDriver();
    }
}
