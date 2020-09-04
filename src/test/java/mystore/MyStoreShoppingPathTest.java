package mystore;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HummingbirdPrintedSweaterPage;
import pages.IndexPage;
import pages.LoginPage;
import pages.YourAccountPage;

import static org.junit.Assert.assertEquals;

public class MyStoreShoppingPathTest {

    WebDriver driver;
    LoginPage loginPage;
    YourAccountPage yourAccountPage;
    IndexPage indexPage;
    HummingbirdPrintedSweaterPage hummingbirdPrintedSweaterPage;
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
    public void myStoreShoppingPathTest(){
        userGoesToLoginPage();
        loginWithProperDataPOP();
        goToMainPageTest();
        searchProductTest();
        goToHummingbirdPrintedSweaterPageTest();
        chooseSizeTest();
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
        hummingbirdPrintedSweaterPage = new HummingbirdPrintedSweaterPage(driver);
        assertEquals(productName, hummingbirdPrintedSweaterPage.getProductNameHeader());
    }

    public void chooseSizeTest() {
        hummingbirdPrintedSweaterPage.chooseSize("M");
//        assertEquals("M", driver.findElement(By.cssSelector("form select option[selected]")).getText());
    }

    public void setQuantityTest(){
        hummingbirdPrintedSweaterPage.setQuantity("5");
    }

    public void addToCartTest(){
        hummingbirdPrintedSweaterPage.addToCart();
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}