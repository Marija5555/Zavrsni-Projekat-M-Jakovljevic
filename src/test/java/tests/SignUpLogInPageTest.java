package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignInLogInPage;

import static helpers.Strings.*;
import static helpers.URLs.*;

public class SignUpLogInPageTest extends BaseTest {
    SignInLogInPage signInLogIn;
    @BeforeMethod
    public void setUpPage(){
        signInLogIn = new SignInLogInPage(driver);
        driver.navigate().to(SIGNUPPAGE);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void pageCleanUp(){
        driver.manage().deleteAllCookies();
    }
    @Test(priority = 10)
    public void signInWithValideCredentials(){
        signInLogIn.insertName(uname);
        signInLogIn.insertemail(uemail);
        signInLogIn.clicksignUpButton();
        signInLogIn.setGenderRadioButton();
        signInLogIn.inputPassword(pass);
        signInLogIn.setBDay(4);
        signInLogIn.setBMonths("5");
        signInLogIn.setBYear(1990);
        signInLogIn.insertFirstName(uname);
        signInLogIn.insertLastName(ulastename);
        signInLogIn.insertAddress1(address);
        signInLogIn.insertAddress2(addressSecond);
        signInLogIn.setCountryButton("India");
        signInLogIn.setState(state);
        signInLogIn.inputCity(ucity);
        signInLogIn.inputZipcode(uzipcode);
        signInLogIn.inputMobile(number);
        signInLogIn.clickOnCreateAccount();
        Assert.assertEquals(driver.getCurrentUrl(), ACCOUNTCREATE);
        Assert.assertEquals(signInLogIn.notificationMessage(), expectedMessageSignin);
        signInLogIn.clikcContinue();
        Assert.assertEquals(driver.getCurrentUrl(), HOMEPAGE );
    }
    @Test(priority = 20)
    public void logInWithValideCredentials(){
        signInLogIn.inputEmail(uemail);
        signInLogIn.inputPass(pass);
        signInLogIn.clickOnLogIn();
        Assert.assertTrue(signInLogIn.logedInButton.isDisplayed());
        signInLogIn.setDeleteAccount();
        Assert.assertEquals(signInLogIn.notificationMessage(), expectedMessageLogin);
        signInLogIn.clickOnContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), HOMEPAGE );
    }

    @Test(priority = 30)
    public void logInWithInValideCredentials(){
        //String invalidEmail = excelReader.getStringData("LogP", 1, 1);
        //signInLogIn.inputEmail(invalidEmail);
        signInLogIn.inputPass(pass);
        signInLogIn.clickOnLogIn();
        Assert.assertTrue(signInLogIn.logedInButton.isDisplayed());
        Assert.assertEquals(signInLogIn.notificationMessage(), expectedMessageLogin);
        signInLogIn.clickOnContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), HOMEPAGE );
    }




}
