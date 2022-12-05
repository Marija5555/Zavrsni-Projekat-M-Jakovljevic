package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PaymentPage;

import static helpers.Strings.*;
import static helpers.URLs.PAYMENT;

public class PaymentTest extends BaseTest {
       PaymentPage payment;
    @BeforeMethod
    public void setUpPage() {
        homePage = new HomePage(driver);
        payment = new PaymentPage(driver);
        driver.navigate().to(PAYMENT);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void pageCleanUp() {
        driver.manage().deleteAllCookies();
    }

    @Test
    public void fillPayFormAndSubmit(){
        payment.inputNameOnCard(uname);
        payment.cardNumber(cardNum);
        payment.cvcNumber(cvcNum);
        payment.monthOnCard(monthNum);
        payment.yearOnCard(yearNum);
        payment.payAndCofirm();

        Assert.assertEquals(payment.getMesage().getText(),expectedMessageOrder);
        payment.backToHomePage();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");

    }
}
