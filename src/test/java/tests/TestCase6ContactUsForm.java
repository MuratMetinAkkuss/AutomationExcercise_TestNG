package tests;

import com.github.javafaker.Faker;
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
import utilities.TestBaseReport;

import java.util.List;

public class TestCase6ContactUsForm extends TestBaseReport {
    @Test
    public void test01(){
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //Test Case 6: Contact Us Form
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationExcerciseUrl"));
        //3. Verify that home page is visible successfully
        Assert.assertTrue(aEP.isHomePageVisible.isDisplayed());
        //4. Click on 'Contact Us' button
        aEP.contactUs.click();
        //5. Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(aEP.getInTouchText.isDisplayed());
        //6. Enter name, email, subject and message
        Faker faker = new Faker();
        aEP.contactUsFormName.sendKeys(faker.name().firstName());
        aEP.contactUsFormEmail.sendKeys(faker.internet().emailAddress());
        aEP.contactUsFormSubject.sendKeys(faker.book().title());
        aEP.contactUsFormMessage.sendKeys(faker.address().fullAddress());
        //7. Upload file
        String filePath = System.getProperty("user.home") + "\\Downloads\\example.png";
        aEP.contactUsFormUploadImg.sendKeys(filePath);
        aEP.contactUsFormMessage.sendKeys(Keys.PAGE_DOWN);
        //8. Click 'Submit' button
        ReusableMethods.bekle(2);
        aEP.contactUsFormSubmit.click();
        ReusableMethods.bekle(2);
        //9. Click OK button
        Driver.getDriver().switchTo().alert().accept();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.bekle(1);
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        Assert.assertTrue(aEP.contactUsFormSuccesMessage.isDisplayed());
        //11. Click 'Home' button and verify that landed to home page successfully
        aEP.onNavbarHomeButton.click();
        Assert.assertTrue(aEP.isHomePageVisible.isDisplayed());
        Driver.closeDriver();
    }
}
