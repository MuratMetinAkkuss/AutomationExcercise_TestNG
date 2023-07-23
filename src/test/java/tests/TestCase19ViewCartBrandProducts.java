package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExcercisePage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class TestCase19ViewCartBrandProducts {
    @Test
    public void test01() {
        //Test Case 19: View & Cart Brand Products
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");
        //3. Click on 'Products' button
        aEP.onNavbarProductsButton.click();
        //4. Verify that Brands are visible on left side bar
        Assert.assertTrue(aEP.brandsOnLeftSideBarInProductPage.isDisplayed());
        //5. Click on any brand name
        ReusableMethods.bekle(3);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",aEP.babyhugOnLeftSideBarInProductPage);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(aEP.babyhugOnLeftSideBarInProductPage)).click();
        //6. Verify that user is navigated to brand page and brand products are displayed
        Assert.assertTrue(aEP.babyhugProductsInBabyhugPage.isDisplayed());
        //7. On left side bar, click on any other brand link
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        aEP.popUpAdsInEveryPage.click();
        wait.until(ExpectedConditions.elementToBeClickable(aEP.madameOnLeftSideBarInBabyhugPage));
        aEP.madameOnLeftSideBarInBabyhugPage.click();
        //8. Verify that user is navigated to that brand page and can see products
        Assert.assertTrue(aEP.madameProductsInMadamePage.isDisplayed());
        Driver.closeDriver();

    }
}
