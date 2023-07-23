package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExcercisePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TestCase20SearchProductsAndVerifyCartAfterLogin {
    @Test
    public void test20() throws InterruptedException {
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");
        //3. Click on 'Products' button
        aEP.onNavbarProductsButton.click();
        //4. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(aEP.brandsOnLeftSideBarInProductPage.isDisplayed());
        //5. Enter product name in search input and click search button
        aEP.searchBoxInProductPage.sendKeys(ConfigReader.getProperty("productName"));
        aEP.submitSearchInProductPage.click();
        //6. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(aEP.searchedProducts.isDisplayed());
        //7. Verify all the products related to search are visible
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(aEP.menOnLeftSideBarInWomenPage).perform();
        Assert.assertTrue(aEP.allProductsRelatedToSearch.isDisplayed());
        //8. Add those products to cart
        actions.moveToElement(aEP.addToCardProductInSearchPage).click().perform();
        //9. Click 'Cart' button and verify that products are visible in cart
        aEP.viewCartButtonAfterClickAddToCart.click();
        Driver.getDriver().navigate().refresh();// i add because of the web page doesnt show the product of cart page
        Assert.assertTrue(aEP.firstProductInCartPage.isDisplayed());
        //*[@href='/product_details/6']
        //10. Click 'Signup / Login' button and submit login details
        aEP.onNavbarSignUpLogInButton.click();
        ReusableMethods.makeRegistration();
        aEP.onNavbarLogOutButton.click();
        ReusableMethods.bekle(1);


        aEP.loginToYourAccountWiaEmail.sendKeys(ReusableMethods.eMail);
        aEP.loginToYourAccountWiaPassword.sendKeys(ReusableMethods.passWord);
        aEP.loginToYourAccountWiaLoginButton.click();

        //11. Again, go to Cart page
        aEP.onNavbarCartButton.click();
        //12. Verify that those products are visible in cart after login as well
        Assert.assertTrue(aEP.firstProductInCartPage.isDisplayed());
        Driver.closeDriver();
    }
}
