package pages;

import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignInLogInPage extends BaseTest {

    public SignInLogInPage(WebDriver driver) {
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[3]/div[1]/form[1]/input[2]") public WebElement name;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[3]/div[1]/form[1]/input[3]") public WebElement email;

    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[3]/div[1]/form[1]/button[1]") public WebElement signUpButton;

    @FindBy(id = "id_gender2") public WebElement genderRadioButton;

    @FindBy(id = "password") public WebElement password;

    @FindBy(id = "days") public WebElement daysButton;

    @FindBy(id = "months") public WebElement monthsButton;

    @FindBy(id = "years") public WebElement yearButton;

    @FindBy(id = "first_name") public WebElement firstName;

    @FindBy(id = "last_name") public WebElement lastName;

    @FindBy(id = "address1") public WebElement address1;

    @FindBy(id = "address2") public WebElement address2;

    @FindBy(id = "country") public WebElement countryButton;
    @FindBy(id = "state") public WebElement stateButton;
    @FindBy(id = "city") public WebElement city;
    @FindBy(id = "zipcode") public WebElement zipcode;
    @FindBy(id = "mobile_number") public WebElement mobileNumber;
    @FindBy(xpath = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]") public WebElement createAccount;
    @FindBy (css = ".title.text-center") public WebElement notificationMessage;
    @FindBy(css = ".btn.btn-primary") public WebElement continueButtom;
    @FindBy(name = "email") public WebElement logInMail;
    @FindBy(name = "password") public WebElement logInPass;
    @FindBy(css = ".btn.btn-default") public WebElement logInButton;
    @FindBy(css = ".fa.fa-trash-o") public WebElement deleteAccount;
    @FindBy(css = ".title.text-center") public WebElement notificationMessageDelete;
    @FindBy(css = ".fa.fa-user") public WebElement logedInButton;
    @FindBy(css = ".btn.btn-primary") public WebElement continueButton;


    //------------------------------------

    public void insertName(String uname){
        name.clear();
        name.sendKeys(uname);
    }
    public void insertemail(String uemail) {
        email.clear();
        email.sendKeys(uemail);
    }
    public void clicksignUpButton() {
        signUpButton.click();

    }
    public void setGenderRadioButton(){
        genderRadioButton.click();
    }
    public void inputPassword(String pass){
        password.clear();
        password.sendKeys(pass);
    }
    public void setBDay(int value){
        Select dropdown = new Select(this.daysButton);
        dropdown.selectByValue(String.valueOf(value));
    }

    public void setBMonths(String month){
        Select dropdown = new Select(this.monthsButton);
        dropdown.selectByValue(String.valueOf(month));
    }
    public void setBYear(int year){
        Select dropdown = new Select(this.yearButton);
        dropdown.selectByValue(String.valueOf(year));
    }

    public void insertFirstName(String uname){
        firstName.clear();
        firstName.sendKeys(uname);
    }
    public void insertLastName(String ulastename){
        lastName.clear();
        lastName.sendKeys(ulastename);
    }
    public void insertAddress1(String address){
        address1.clear();
        address1.sendKeys(address);
    }
    public void insertAddress2(String addressSecond){
        address2.clear();
        address2.sendKeys(addressSecond);
    }
    public void setCountryButton(String country){
        Select dropdown = new Select(this.countryButton);
        dropdown.selectByVisibleText(country);
    }
    public void setState(String state){
        stateButton.clear();
        stateButton.sendKeys(state);
    }
    public void inputCity(String ucity) {
        city.clear();
        city.sendKeys(ucity);
    }

    public void inputZipcode(String uzipcode) {
        zipcode.clear();
        zipcode.sendKeys(uzipcode);
    }

    public void inputMobile(String number) {
        mobileNumber.clear();
        mobileNumber.sendKeys(number);
    }
    public void clickOnCreateAccount(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", this.createAccount);
        createAccount.click();
    }
    public String notificationMessage() {

        return notificationMessage.getText();
    }
    public void clikcContinue(){
        continueButtom.click();
    }
    public void inputEmail(String uemail){
        logInMail.clear();
        logInMail.sendKeys(uemail);
    }
    public void inputPass(String pass){
        logInPass.clear();
        logInPass.sendKeys();
    }
    public void clickOnLogIn(){
        logInButton.click();
    }
    public void setDeleteAccount(){
        deleteAccount.click();
    }
    public void clickOnContinueButton(){
        continueButtom.click();
    }

}
