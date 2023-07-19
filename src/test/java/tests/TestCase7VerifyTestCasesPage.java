package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExcercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class TestCase7VerifyTestCasesPage {
    @Test
    public void test01(){
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("automationExcerciseUrl"));

        //3. Verify that home page is visible successfully
        Assert.assertTrue(aEP.isHomePageVisible.isDisplayed());

        //4. Click on 'Test Cases' button
        aEP.onNavbarClickTestCase.click();

        //5. Verify user is navigated to test cases page successfully
        Assert.assertTrue(aEP.testCasePageText.isDisplayed());
        Driver.closeDriver();
    }
}
