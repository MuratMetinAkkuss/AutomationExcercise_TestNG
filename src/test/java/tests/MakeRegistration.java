package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.AutomationExcercisePage;
import utilities.ConfigReader;
import utilities.ReusableMethods;

public class MakeRegistration {
    public Faker faker = new Faker();
    public String passWord = faker.internet().password();
    public String eMail = faker.internet().emailAddress();
    public void makeRegistration(){
        AutomationExcercisePage aEP = new AutomationExcercisePage();
        //6. Enter name and email address


        String name = faker.name().firstName();
        aEP.signupName.sendKeys(name);

        aEP.signupEmail.sendKeys(eMail);

        //7. Click 'Signup' button

        aEP.signUpButton.click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible

        Assert.assertTrue(aEP.enterAccountInformation.isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        aEP.popUpAdsInEveryPage.click();


        aEP.passWord.sendKeys(passWord + Keys.PAGE_DOWN);


        Select selectDay = new Select(aEP.daysOfBirth);
        selectDay.selectByValue(ConfigReader.getProperty("selectDay"));


        Select selectMonth = new Select(aEP.monthOfBirth);
        selectMonth.selectByValue(ConfigReader.getProperty("selectMonth"));


        Select selectYear = new Select(aEP.yearOfBirth);
        selectYear.selectByValue(ConfigReader.getProperty("selectYear"));




        //10. Select checkbox 'Sign up for our newsletter!'

        aEP.popUpAdsInEveryPage.click();

        aEP.signUpForOurNewsletter.click();

        //11. Select checkbox 'Receive special offers from our partners!'

        aEP.receiveSpecialOffersInsideSignPage.click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

        aEP.firstNameInSignPage.sendKeys(name);

        aEP.lastNameInSignPage.sendKeys(faker.name().lastName());


        aEP.companyInSignPage.sendKeys(faker.company().name());


        aEP.address1InSignPage.sendKeys(faker.address().fullAddress());

        aEP.address2InSignPage.sendKeys(faker.address().secondaryAddress() + Keys.PAGE_DOWN);


        Select selectCountry = new Select(aEP.countryInSignPage);
        selectCountry.selectByValue(ConfigReader.getProperty("selectCountry"));

        ReusableMethods.bekle(3);

        aEP.stateInSignPage.sendKeys(faker.address().country());

        aEP.cityInSignPage.sendKeys(faker.address().city());

        aEP.zipcodeInSignPage.sendKeys(faker.address().zipCode());

        aEP.mobileNumberInSignPage.sendKeys(faker.phoneNumber().cellPhone());

        //13. Click 'Create Account button'
        aEP.createAccountButtonInSignPage.click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(aEP.accountCreatedAfterSignPage.isDisplayed());

        //15. Click 'Continue' button
        aEP.accountContinueButtonAfterSignPage.click();
        aEP.logOutButton.click();
    }
}
