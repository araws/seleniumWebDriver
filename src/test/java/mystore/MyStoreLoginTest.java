package mystore;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class MyStoreLoginTest {
    WebDriver driver;


    @Before
    public void setUp() {
        // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @Test
    public void loginWithProperDataNoPageObject() {
        WebElement emailInputField = driver.findElement(By.name("email"));
        emailInputField.sendKeys("johnd@mail.com");

        WebElement passwordInputField = driver.findElement(By.name("password"));
        passwordInputField.sendKeys("qwerty");

        driver.findElement(By.id("submit-login")).click();

        WebElement userFullNameLabel = driver.findElement(By.xpath("//*[@id='_desktop_user_info']/div/a[2]/span"));
        Assert.assertEquals("John Doe", userFullNameLabel.getText());
    }

    @Test
    public void loginWithProperDataPOP() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("johnd@mail.com", "qwerty");

        String userName = loginPage.getLoggedUserName();
        Assert.assertEquals("John Doe", userName);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}