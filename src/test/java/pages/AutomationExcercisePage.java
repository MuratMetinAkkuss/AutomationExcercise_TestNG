package pages;

import org.openqa.selenium.WebElement;
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
    public WebElement onNavbarSignUpLogInButton;
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
    @FindBy(xpath = "//*[text()='Login to your account']")
    public WebElement loginToYourAccountTextElement;
    @FindBy(xpath = "//*[@data-qa='login-email']")
    public WebElement loginToYourAccountWiaEmail;
    @FindBy(xpath = "//*[@data-qa='login-password']")
    public WebElement loginToYourAccountWiaPassword;
    @FindBy(xpath = "//*[@data-qa='login-button']")
    public WebElement loginToYourAccountWiaLoginButton;
    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement onNavbarLogOutButton;
    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    public WebElement incorrectLogInSignText;
    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    public WebElement accountAlreadyExsist;
    @FindBy(xpath = "//a[@href='/contact_us']")
    public  WebElement contactUs;
    @FindBy(xpath = "//h2[text()='Get In Touch']")
    public WebElement getInTouchText;
    @FindBy(xpath = "//input[@data-qa='name']")
    public WebElement contactUsFormName;
    @FindBy(xpath = "//input[@data-qa='email']")
    public WebElement contactUsFormEmail;
    @FindBy(xpath = "//input[@data-qa='subject']")
    public WebElement contactUsFormSubject;
    @FindBy(xpath = "//textarea[@data-qa='message']")
    public WebElement contactUsFormMessage;
    @FindBy(xpath = "//input[@name='upload_file']")
    public WebElement contactUsFormUploadImg;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement contactUsFormSubmit;
    @FindBy(xpath = "//div[@class='status alert alert-success']")
    public WebElement contactUsFormSuccesMessage;
    @FindBy(xpath = "//a[@class='btn btn-success']")
    public WebElement onNavbarHomeButton;
    @FindBy(xpath = "//a[text()=' Test Cases']")
    public WebElement onNavbarClickTestCase;
    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement testCasePageText;
    @FindBy(xpath = "//a[@href='/products']")
    public WebElement onNavbarProductsButton;
    @FindBy(xpath = "//h2[text()='All Products']")
    public WebElement allProductsInProductPage;
    @FindBy(xpath = "//a[@href='/product_details/1']")
    public WebElement firstProductInProductPage;
    @FindBy(xpath = "//h2[text()='Blue Top']")
    public WebElement firstProductNameInFirstProductPage;
    @FindBy(xpath = "//p[text()='Category: Women > Tops']")
    public WebElement firstProductCategoryInFirstProductPage;
    @FindBy(xpath = "//span[text()='Rs. 500']")
    public WebElement firstProductPriceInFirstProductPage;
    @FindBy(xpath = "//p[text()=' In Stock']")
    public WebElement firstProductAvailabilityInFirstProductPage;
    @FindBy(xpath = "//p[text()=' New']")
    public WebElement firstProductConditionInFirstProductPage;
    @FindBy(xpath = "//p[text()=' Polo']")
    public WebElement firstProductBrandInFirstProductPage;
    @FindBy(xpath = "//input[@name='search']")
    public WebElement searchBoxInProductPage;
    @FindBy(id = "submit_search")
    public WebElement submitSearchInProductPage;
    @FindBy(xpath = "//h2[text()='Searched Products']")
    public WebElement searchedProducts;
    @FindBy(xpath = "//*[@class='product-image-wrapper']")
    public WebElement allProductsRelatedToSearch;
    @FindBy(xpath = "//footer[@id='footer']")
    public WebElement footerElementInHomePage;
    @FindBy(xpath = "//h2[text()='Subscription']")
    public WebElement subscriptionTextIntFooter;
    @FindBy(id = "susbscribe_email")
    public WebElement subscriptionBoxInFooter;
    @FindBy(id = "subscribe")
    public WebElement submitSubscriptionInFooter;
    @FindBy(id = "success-subscribe")
    public WebElement successfullySubscribedInFooter;
    @FindBy(xpath = "(//*[@href='/view_cart'])[2]")
    public WebElement onPopUpCartButton;
    @FindBy(xpath = "(//*[@href='/view_cart'])[1]")
    public WebElement onNavbarCartButton;
    @FindBy(xpath = "(//*[@class='btn btn-default add-to-cart'])[1]")
    public WebElement clickAddToCartForFirstProduct;
    @FindBy(xpath = "//*[@class='btn btn-success close-modal btn-block']")
    public WebElement continueShopping;
    @FindBy(xpath = "(//*[@class='btn btn-default add-to-cart'])[3]")
    public WebElement clickAddToCartForSecondProduct;
    @FindBy(xpath = "(//*[@href='/view_cart'])[2]")
    public WebElement viewCartButtonAfterClickAddToCart;
    @FindBy(xpath = "(//*[@class='disabled'])[1]")
    public WebElement firstProductQuantityInCart;
    @FindBy(xpath = "(//*[@class='disabled'])[2]")
    public WebElement secondProductQuantityInCart;
    @FindBy(xpath = "(//*[@class='cart_price'])[1]")
    public WebElement firstProductPriceInCart;
    @FindBy(xpath = "(//*[@class='cart_price'])[2]")
    public WebElement secondProductPriceInCart;
    @FindBy(xpath = "(//*[text()='View Product'])[1]")
    public WebElement firstProductViewProductButtonInHomePage;
    @FindBy(xpath = "//div[@class='product-information']")
    public WebElement firstProductInformationInProductPage;
    @FindBy(xpath = "//input[@name='quantity']")
    public WebElement increaseButtonInFirstProductPage;
    @FindBy(xpath = "//button[@class='btn btn-default cart']")
    public WebElement addToCartButtonInFirstProductPage;
    @FindBy(xpath = "//*[@class='product_image']")
    public WebElement firstProductInCartPage;
    @FindBy(xpath = "//*[@class='btn btn-default check_out']")
    public WebElement clickProceedToCheckOutInCartPage;
    @FindBy(xpath = "(//*[@class='btn btn-default add-to-cart'])[1]")
    public WebElement firstProductAddToCartInHomePage;
    @FindBy(xpath = "//*[text()='Register / Login']")
    public WebElement registerLoginAfterProceed;
    @FindBy(xpath = "(//*[@class='address_firstname address_lastname'])[1]")
    public WebElement firstNameLastNameInAdressDetails;
    @FindBy(xpath = "(//*[@class='address_address1 address_address2'])[1]")
    public WebElement companyNameInAdressDetails;
    @FindBy(xpath = "(//*[@class='address_address1 address_address2'])[2]")
    public WebElement adress1InAdressDetails;
    @FindBy(xpath = "(//*[@class='address_address1 address_address2'])[3]")
    public WebElement adress2InAdressDetails;
    @FindBy(xpath = "(//*[@class='address_city address_state_name address_postcode'])[1]")
    public WebElement stateCityZipCodeInAdressDetails;
    @FindBy(xpath = "(//*[@class='address_phone'])[1]")
    public WebElement phoneInAdressDetails;
    @FindBy(xpath = "(//*[@class='heading'])[2]")
    public WebElement heading2InAdressDetails;
    @FindBy(xpath = "//*[text()='Place Order']")
    public WebElement placeOrderInOrderPage;
    @FindBy(xpath = "//*[@name='name_on_card']")
    public WebElement nameOnCarInOrderPage;
    @FindBy(xpath = "//*[@name='card_number']")
    public WebElement cardNumberInOrderPage;
    @FindBy(xpath = "//*[@name='cvc']")
    public WebElement cvcInOrderPage;
    @FindBy(xpath = "//*[@name='expiry_month']")
    public WebElement expiryMonthInOrderPage;
    @FindBy(xpath = "//*[@name='expiry_year']")
    public WebElement expiryYearInOrderPage;
    @FindBy(xpath = "//*[@data-qa='pay-button']")
    public WebElement payAndConfirmInOrderPage;
    @FindBy(xpath = "//*[text()='Congratulations! Your order has been confirmed!']")
    public WebElement yourOrderHasBeenConfirmedAfterOrderPage;
    @FindBy(xpath = "//*[text()='Shopping Cart']")
    public WebElement verifyCartPage;
    @FindBy(xpath = "//*[@name='message']")
    public WebElement messageInOrderPage;
    @FindBy(xpath = "//*[@class='cart_quantity_delete']")
    public WebElement xButtonInCartPage;
    @FindBy(xpath = "//*[@href='#Kids']")
    public WebElement kidsOnLeftSideBarInHomePage;
    @FindBy(xpath = "//*[@class='left-sidebar']")
    public WebElement leftSideBarInHomePage;
    @FindBy(xpath = "//*[@href='#Women']")
    public WebElement womenOnLeftSideBarInHomePage;
    @FindBy(xpath = "//*[@href='/category_products/1']")
    public WebElement dressUnderWomenOnLeftSideBarInHomePage;
    @FindBy(xpath = "//*[text()='Women - Dress Products']")
    public WebElement productsInWomenDressPage;
    @FindBy(xpath = "//*[@href='#Men']")
    public WebElement menOnLeftSideBarInWomenPage;
    @FindBy(xpath = "//*[@href='/category_products/3']")
    public WebElement tshirtsUnderMenOnLeftSideBarInWomenPage;
    @FindBy(xpath = "//*[text()='Men - Tshirts Products']")
    public WebElement productsInMenTshirtsPage;
    @FindBy(xpath = "//*[@class='brands_products']")
    public WebElement brandsOnLeftSideBarInProductPage;
    @FindBy(xpath = "//*[@href='/brand_products/Babyhug']")
    public WebElement babyhugOnLeftSideBarInProductPage;
    @FindBy(xpath = "//*[text()='Brand - Babyhug Products']")
    public WebElement babyhugProductsInBabyhugPage;
    @FindBy(xpath = "//*[@href='/brand_products/Madame']")
    public WebElement madameOnLeftSideBarInBabyhugPage;
    @FindBy(xpath = "//*[text()='Brand - Madame Products']")
    public WebElement madameProductsInMadamePage;
    @FindBy(xpath = "(//*[@class='btn btn-default add-to-cart'])[1]")
    public WebElement addToCardProductInSearchPage;
    @FindBy(xpath = "//*[@href='#reviews']")
    public WebElement writeYourReviewInFirstProductPage;
    @FindBy(xpath = "//*[@placeholder='Your Name']")
    public WebElement nameBoxWriteYourReviewInFirstProductPage;
    @FindBy(xpath = "//*[@placeholder='Email Address']")
    public WebElement eMailBoxWriteYourReviewInFirstProductPage;
    @FindBy(xpath = "//*[@placeholder='Add Review Here!']")
    public WebElement addReviewHereBoxWriteYourReviewInFirstProductPage;
    @FindBy(xpath = "//*[@id='button-review']")
    public WebElement reviewButtonWriteYourReviewInFirstProductPage;
    @FindBy(xpath = "//*[text()='Thank you for your review.']")
    public WebElement thankYouForYourReviewAfterSendInFirstProductPage;
    @FindBy(xpath = "//*[text()='recommended items']")
    public WebElement recommendedItemsInHomePage;
    @FindBy(xpath = "//*[@id='recommended-item-carousel']/div/div[1]/div[2]/div/div/div/a")
    public WebElement addToCarRecommendedProductInHomePage;

















}
