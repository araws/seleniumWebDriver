package mystore;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.IndexPage;
import pages.LoginPage;
import pages.YourAccountPage;

import static org.junit.Assert.assertEquals;

public class MyStoreShoppingPathTest {

    WebDriver driver;
    LoginPage loginPage;
    YourAccountPage yourAccountPage;
    IndexPage indexPage;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php");
    }

    @Test
    public void loginWithProperDataPOP() {
        loginPage = new LoginPage(driver);
        loginPage.loginAs("ebkbdkmzbfmyljlrhl@kiabws.online", "qwe123");

        String userName = loginPage.getLoggedUserName();
        assertEquals("Andrzej Rawski", userName);
    }

    @Test
    public void goToMainPageTest(){
        yourAccountPage.goToMainPage();
    }

    @Test
    public void searchProductTest(){
        indexPage.searchProduct("Hummingbird Printed Sweater");
    }

    @Test
    public void goToHummingbirdPrintedSweaterPageTest(){
        indexPage.goToHummingbirdPrintedSweaterPage();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}