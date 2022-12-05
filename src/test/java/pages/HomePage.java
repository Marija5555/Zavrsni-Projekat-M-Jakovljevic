package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static helpers.URLs.VIEWCART;

public class HomePage extends BaseTest {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "/html[1]/body[1]/a[1]")
    public WebElement scrollUpButton;
    @FindBy(xpath = "/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]")
    public WebElement productsPage;
    @FindBy(xpath = "/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")
    public WebElement cartPage;
    @FindBy(xpath = "/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]")
    public WebElement logIn_SignUpPage;
    @FindBy(xpath = "/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[8]/a[1]")
    public WebElement contactUsPage;
    @FindBy(xpath = "/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")
    public WebElement homePageIcon;
    @FindBy(xpath = "/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[10]/a[1]/b[1]")
    public WebElement logName;
    @FindBy(xpath = "/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]")
    public WebElement logOut;
    @FindBy(xpath = "/html[1]/body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]")
    public WebElement addCartButton;
    @FindBy(css = ".fa.fa-shopping-cart") public WebElement addCartButton1;
    //@FindBy(xpath = "//u[contains(text(),'View Cart')]") public WebElement viewCart;
    private final String VIEW_CART = "/html[1]/body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/p[2]/a[1]/u[1]";
    private final String ADD_TO_CART = "/html[1]/body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]";

    //---------------------------------------------

    public void clickOnScrollUpButton(){
        if( scrollUpButton.getCssValue("display").equals("block")){
            scrollUpButton.click();
        }

    }
    public void clickOnHomePageIcon(){
        homePageIcon.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/");
    }
    public void goOnProductsPage(){
        productsPage.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/products");
    }
    public WebElement getDress(int dressNumber) {
        if (dressNumber < 2 || dressNumber > 35) {
            throw new IllegalArgumentException(String.format("The dress number %d is not available", dressNumber));
        }
        return driver.findElement(By.xpath("/html[1]/body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[" + dressNumber + "]"));
    }
    public void scrollToDress(){
     ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,300)");
    }

    public void hoverToDress(int dressNumber) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getDress(dressNumber)).perform();
    }

    public void clickToAddCartButton() {
        WebElement addToCard = driver.findElement(By.xpath(ADD_TO_CART));
        addToCard.click();
    }
    public void clickToViewCartButton() {
        WebElement viewCard = driver.findElement(By.xpath(VIEW_CART));
        viewCard.click();
    }
    public void goOnCartPage(){
        cartPage.click();
        Assert.assertEquals(driver.getCurrentUrl(),VIEWCART);
    }
    public void goOnLogIn_SignUpPage(){
        logIn_SignUpPage.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/login");
    }
    public void goOnContactUsPage(){
        contactUsPage.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.automationexercise.com/contact_us");
    }
    public String logedName (){
        return logName.getText();
    }

    public void scrollToDress(int dressNumber) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", getDress(dressNumber));
    }


    public void continueToShoping(){
        WebElement addToCard = driver.findElement(By.xpath("/html[1]/body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/button[1]"));
        addToCard.click();
    }

}
