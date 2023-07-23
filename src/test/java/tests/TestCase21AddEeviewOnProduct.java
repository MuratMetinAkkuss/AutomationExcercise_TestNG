package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExcercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class TestCase21AddEeviewOnProduct {
    @Test
    public void test21(){
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationExcerciseUrl"));
        //3. Click on 'Products' button
        aEP.onNavbarProductsButton.click();
        //4. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(aEP.allProductsInProductPage.isDisplayed());
        //5. Click on 'View Product' button
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        aEP.firstProductInProductPage.click();
        //6. Verify 'Write Your Review' is visible
        Assert.assertTrue(aEP.writeYourReviewInFirstProductPage.isDisplayed());
        //7. Enter name, email and review
        Faker faker = new Faker();
        aEP.nameBoxWriteYourReviewInFirstProductPage.sendKeys(faker.name().firstName());
        aEP.eMailBoxWriteYourReviewInFirstProductPage.sendKeys(faker.internet().emailAddress());
        aEP.addReviewHereBoxWriteYourReviewInFirstProductPage.sendKeys(faker.book().title());
        //8. Click 'Submit' button
        aEP.reviewButtonWriteYourReviewInFirstProductPage.click();
        //9. Verify success message 'Thank you for your review.'
        Assert.assertTrue(aEP.thankYouForYourReviewAfterSendInFirstProductPage.isDisplayed());
        Driver.closeDriver();
    }
}
