package tests;

import com.fasterxml.jackson.databind.jsontype.impl.AsExistingPropertyTypeSerializer;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExcercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class TestCase9SearchProduct extends TestBaseReport {
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
        Assert.assertTrue(aEP.allProductsInProductPage.isDisplayed());
        //6. Enter product name 'Winter Top' in search input and click search button
        aEP.searchBoxInProductPage.sendKeys(ConfigReader.getProperty("WinterTopProduct"));
        aEP.submitSearchInProductPage.click();
        //7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(aEP.searchedProducts.isDisplayed());
        //8. Verify all the products related to search are visible
        Assert.assertTrue(aEP.allProductsRelatedToSearch.isDisplayed());
        Driver.closeDriver();
    }
}
