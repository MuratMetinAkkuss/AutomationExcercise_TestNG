package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExcercisePage;
import utilities.Driver;

public class TestCase18ViewCategoryProducts {
    @Test
    public void test01(){
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");
        //3. Verify that categories are visible on left side bar
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollToElement(aEP.kidsOnLeftSideBarInHomePage).perform();
        Assert.assertTrue(aEP.leftSideBarInHomePage.isDisplayed());

        aEP.popUpAdsInEveryPage.click();// i put line 21 for pop-up ad

        //4. Click on 'Women' category
        aEP.womenOnLeftSideBarInHomePage.click();
        //5. Click on any category link under 'Women' category, for example: Dress
        aEP.dressUnderWomenOnLeftSideBarInHomePage.click();
        //6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        Assert.assertTrue(aEP.productsInWomenDressPage.isDisplayed());
        //7. On left side bar, click on any sub-category link of 'Men' category
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        aEP.menOnLeftSideBarInWomenPage.click();
        aEP.tshirtsUnderMenOnLeftSideBarInWomenPage.click();
        //8. Verify that user is navigated to that category page
        Assert.assertTrue(aEP.productsInMenTshirtsPage.isDisplayed());
        Driver.closeDriver();

    }
}
