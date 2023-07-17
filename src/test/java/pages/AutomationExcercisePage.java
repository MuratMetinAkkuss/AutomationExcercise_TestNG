package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExcercisePage {
    public AutomationExcercisePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@class='grippy-host']")
    public WebElement popUpAdsInEveryPage;
    @FindBy(xpath = "//img[@alt='Website for automation practice']")
    public WebElement isHomePageVisible;
    @FindBy(xpath = "//a[@href='/login']")
    public WebElement signUpLogInButton;
    @FindBy(xpath = "//h2[text()='New User Signup!']")
    public WebElement isNewUserSignupSign;
    @FindBy(xpath = "//input[@placeholder='Name']")
    public WebElement signupName;
    @FindBy(xpath = "(//input[@placeholder='Email Address'])[2]")
    public WebElement signupEmail;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signUpButton;
    @FindBy(xpath = "//b[text()='Enter Account Information']")
    public WebElement enterAccountInformation;
    @FindBy(id = "password")
    public WebElement passWord;
    @FindBy(id = "days")
    public WebElement daysOfBirth;
    @FindBy(id = "months")
    public WebElement monthOfBirth;
    @FindBy(id = "years")
    public WebElement yearOfBirth;
    @FindBy(id = "newsletter")
    public WebElement signUpForOurNewsletter;
    @FindBy(id = "optin")
    public WebElement receiveSpecialOffersInsideSignPage;
    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement firstNameInSignPage;
    @FindBy(xpath = "//input[@id='last_name']")
    public WebElement lastNameInSignPage;
    @FindBy(xpath = "//input[@id='company']")
    public WebElement companyInSignPage;
    @FindBy(id = "address1")
    public WebElement address1InSignPage;
    @FindBy(id = "address2")
    public WebElement address2InSignPage;
    @FindBy(id = "country")
    public WebElement countryInSignPage;
    @FindBy(xpath = "//input[@data-qa='state']")
    public WebElement stateInSignPage;
    @FindBy(xpath = "//input[@id='city']")
    public WebElement cityInSignPage;
    @FindBy(xpath = "//input[@id='zipcode']")
    public WebElement zipcodeInSignPage;
    @FindBy(xpath = "//input[@id='mobile_number']")
    public WebElement mobileNumberInSignPage;
    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement createAccountButtonInSignPage;
    @FindBy(xpath = "//h2[@data-qa='account-created']")
    public WebElement accountCreatedAfterSignPage;
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement accountContinueButtonAfterSignPage;
    @FindBy(xpath = "//i[@class='fa fa-user']")
    public WebElement loggedInAsUsername;
    @FindBy(xpath = "//*[@href='/delete_account']")
    public WebElement deleteAccount;
    @FindBy(xpath = "//*[text()='Account Deleted!']")
    public WebElement accountDeletedAfterClickDeleteAccount;
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueButtonAfterClickDeleteAccount;














}
