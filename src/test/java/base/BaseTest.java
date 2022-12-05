package base;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.CartPage;
import pages.HomePage;
import pages.SignInLogInPage;

import java.io.IOException;
import java.time.Duration;

    public class BaseTest {

        public static WebDriver driver;
        public static WebDriverWait wdwait;
        public static SignInLogInPage logInPage;
        public static HomePage homePage;
        public static CartPage catrPage;
        //public static ExcelReader excelReader;

        @BeforeClass
        public void setUp() throws IOException {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
            logInPage = new SignInLogInPage(driver);
            homePage = new HomePage(driver);
            //excelReader = new ExcelReader("C:\\Users\\marij\\OneDrive\\Radna površina\\projekatPodatci.xlsx");

        }


        public void scrollIntoView(WebElement webElement){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", webElement);
        }

        public void waitForElementVisibility(WebElement webElement){
            wdwait.until(ExpectedConditions.visibilityOf(webElement));
        }

        public void waitForElementClickability(WebElement webElement){
            wdwait.until(ExpectedConditions.elementToBeClickable(webElement));
        }

        @AfterClass
        public void tearDown() {
            driver.close();
            driver.quit();
        }


}
