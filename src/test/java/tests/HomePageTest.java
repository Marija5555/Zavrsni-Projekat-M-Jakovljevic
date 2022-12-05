package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

import static helpers.URLs.*;

public class HomePageTest extends BaseTest {

    HomePage homePage;
    CartPage cartPage;

    @BeforeMethod
    public void setUpPage() {
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        driver.navigate().to(HOMEPAGE);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void pageCleanUp() {
        driver.manage().deleteAllCookies();
    }

    @Test
    public void testAddToShoppingCard() {

        homePage.goOnProductsPage();
        homePage.scrollToDress(2);
        homePage.hoverToDress(2);
        homePage.clickToAddCartButton();
        String Url= driver.getCurrentUrl();
        homePage.clickToViewCartButton();

    }




    @Test
    public void removeItemFromCart() {
        testAddToShoppingCard();
        cartPage.removeItemFromCart();
        WebElement product = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[2]/table[1]"));
        Assert.assertFalse(product.getCssValue("display").equals("none"));

    }


    @Test
    public void continueShoping() {
        homePage.goOnProductsPage();
        homePage.scrollToDress(2);
        homePage.hoverToDress(2);
        homePage.clickToAddCartButton();
        homePage.continueToShoping();
        String Url = driver.getCurrentUrl();
        Assert.assertEquals(Url, "https://www.automationexercise.com/products");

    }

    @Test
    public void checkNumberofSameProducts() {

        continueShoping();
        homePage.goOnCartPage();
        Assert.assertEquals(cartPage.numberOfProducts.getText(), "2");

    }

    @Test
    public void checkPlaceOrder() {
        checkNumberofSameProducts();
        cartPage.clickProcesToCheckout();
        cartPage.placeOrder();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationexercise.com/payment");

    }
}
