package mystore;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class MyStoreShoppingPathTest {

    WebDriver driver;
    LoginPage loginPage;
    YourAccountPage yourAccountPage;
    IndexPage indexPage;
    HummingbirdPrintedSweaterPageS hummingbirdPrintedSweaterPageS;
    HummingbirdPrintedSweaterPageM hummingbirdPrintedSweaterPageM;
    ShoppingCartPage shoppingCartPage;
    OrderPage orderPage;

    private String productName;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php");
    }

    @Test
    public void myStoreShoppingPathTest() throws IOException {
        userGoesToLoginPage();
        loginWithProperDataPOP();
        goToMainPageTest();
        searchProductTest();
        goToHummingbirdPrintedSweaterPageTest();
        chooseSizeTest();
        setQuantityTest();
        addToCartTest();
        proceedToCheckoutTest();
        goToOrderPageTest();
        acceptAddressTest();
        acceptDeliveryOptionTest();
        choosePayByCheckOptionTest();
        agreeToTermsTest();
        orderTest();
        takeScreenShot();
    }

    public void userGoesToLoginPage() {
        indexPage = new IndexPage(driver);
        indexPage.goToLoginPage();
        loginPage = new LoginPage(driver);
        Assert.assertEquals("Log in to your account", loginPage.getPageHeader());
    }

    public void loginWithProperDataPOP() {
        loginPage = new LoginPage(driver);
        loginPage.loginAs("ebkbdkmzbfmyljlrhl@kiabws.online", "qwe123");

        String userName = loginPage.getLoggedUserName();
        assertEquals("Andrzej Rawski", userName);
    }

    public void goToMainPageTest() {
        yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.goToMainPage();
    }

    public void searchProductTest() {
        productName = "HUMMINGBIRD PRINTED SWEATER";
        indexPage.searchProduct(productName);
    }

    public void goToHummingbirdPrintedSweaterPageTest() {
        indexPage.goToHummingbirdPrintedSweaterPage();
        hummingbirdPrintedSweaterPageS = new HummingbirdPrintedSweaterPageS(driver);
        assertEquals(productName, hummingbirdPrintedSweaterPageS.getProductNameHeader());
    }

    public void chooseSizeTest() {
        hummingbirdPrintedSweaterPageS.chooseSize("M");
        hummingbirdPrintedSweaterPageM = new HummingbirdPrintedSweaterPageM(driver);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        assertEquals("M", driver.findElement(By.cssSelector("form select option[selected]")).getText());
    }

    public void setQuantityTest() {
        hummingbirdPrintedSweaterPageM.setQuantity("5");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.attributeToBe(driver.findElement(By.id("quantity_wanted")), "value", "5"));
    }

    public void addToCartTest() {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        hummingbirdPrintedSweaterPageM.addToCart();
//        assertEquals("Product successfully added to your shopping cart",
//                hummingbirdPrintedSweaterPageM.getProductAddedInformation());
    }

    public void proceedToCheckoutTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        hummingbirdPrintedSweaterPageM.proceedToCheckout();
    }

    public void goToOrderPageTest() {
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.goToOrderPage();
    }

    public void acceptAddressTest(){
        orderPage = new OrderPage(driver);
        orderPage.acceptAddress();
    }

    public void acceptDeliveryOptionTest(){
        orderPage.acceptDeliveryOption();
    }

    public void choosePayByCheckOptionTest(){
        orderPage.choosePayByCheckOption();
    }

    public void agreeToTermsTest(){
        orderPage.agreeToTerms();
    }

    public void orderTest(){
        orderPage.order();
    }

    public String takeScreenShot() throws IOException {
        String path;
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        path = ".target/screenshots/" + scrFile.getName();
        FileUtils.copyFile(scrFile, new File(path));
        return path;
    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }
}