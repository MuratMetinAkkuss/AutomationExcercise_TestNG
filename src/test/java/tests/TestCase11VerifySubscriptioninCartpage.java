package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExcercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class TestCase11VerifySubscriptioninCartpage {
    @Test
    public void test01(){
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //Test Case 11: Verify Subscription in Cart page
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationExcerciseUrl"));
        //3. Verify that home page is visible successfully
        Assert.assertTrue(aEP.isHomePageVisible.isDisplayed());
        //4. Click 'Cart' button
        aEP.onNavbarCartButton.click();
        //5. Scroll down to footer
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollToElement(aEP.footerElementInHomePage).perform();
        //6. Verify text 'SUBSCRIPTION'
        Assert.assertTrue(aEP.subscriptionTextIntFooter.isDisplayed());
        //7. Enter email address in input and click arrow button
        Faker faker = new Faker();
        aEP.subscriptionBoxInFooter.sendKeys(faker.internet().emailAddress());
        aEP.submitSubscriptionInFooter.click();
        //8. Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertTrue(aEP.successfullySubscribedInFooter.isDisplayed());
        Driver.closeDriver();

    }
}
