package mystore;

import net.bytebuddy.utility.RandomString;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CreateNewAccountPage;
import pages.IndexPage;
import pages.LoginPage;

import java.util.Random;

public class MyStoreTest {

    private WebDriver driver;

    IndexPage indexPage;
    LoginPage loginPage;
    CreateNewAccountPage createNewAccountPage;

    String randomEmail = randomString() + "@o2.pl";

    String[] names = {"zenon", "stefan", "franek", "andrzej", "michal", "piotr"};
    String[] lastNames = {"kowalski", "sosnowski", "nowak", "nowakowski"};
    String[] addresses = {"majowa 1", "kwietniowa 2", "marcowa 3", "lutowa 4", "styczniowa 5"};
    String[] postalCodes = {"44-100", "00-920", "41-800", "43-500", "42-200"};
    String[] cities = {"gliwice", "warszawa", "zabrze", "wisla", "zory"};




    @Before
    public void setUp() {
        // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php");
    }

    @Test
    public void searchTest() {
        WebElement searchBox = driver.findElement(By.cssSelector("input.ui-autocomplete-input"));
        String[] products = {"t-shirt", "mug", "notebook"};
        System.out.println("Length is: " + products.length);
        Random random = new Random();
//        for (int i = 0; i < 20; i++){
//            System.out.println("Index: " + random.nextInt(products.length));
//            System.out.println( "Value: " + products[random.nextInt(products.length)]);
//        }

        int randomModuloProducts = random.nextInt(50) % products.length;
        String product = products[randomModuloProducts];
        searchBox.sendKeys(product);
        searchBox.submit();
    }

    @Test
    public void createNewAccountTest() {

        indexPage = new IndexPage(driver);
        loginPage = new LoginPage(driver);
        createNewAccountPage = new CreateNewAccountPage(driver);

        indexPage.goToLoginPage();
        Assert.assertEquals("Log in to your account", loginPage.getPageHeader());

        loginPage.goToCreateNewAccountPage();
        Assert.assertEquals("Create an account", createNewAccountPage.getPageHeader());

        WebElement firstNameElement = driver.findElement(By.name("firstname"));
        firstNameElement.sendKeys(getRandomFromArray(names));

        WebElement lastNameElement = driver.findElement(By.name("lastname"));
        lastNameElement.sendKeys(getRandomFromArray(lastNames));

        WebElement emailElement = driver.findElement(By.name("email"));
        emailElement.sendKeys(randomEmail);

        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys(randomString());

        WebElement saveButtonElement = driver.findElement(By.xpath("//*[@id='customer-form']/footer/button"));
        saveButtonElement.click();

        WebElement myAccountButton = driver.findElement(By.cssSelector("a span.hidden-sm-down"));
        myAccountButton.click();

        WebElement addAddressButtonElement = driver.findElement(By.xpath("//*[@id='address-link']/span"));
        addAddressButtonElement.click();
        Assert.assertEquals("New address", driver.findElement(By.cssSelector("header.page-header")).getText());

        WebElement addressElement = driver.findElement(By.name("address1"));
        addressElement.sendKeys(getRandomFromArray(addresses));

        WebElement postalCodeElement = driver.findElement(By.name("postcode"));
        postalCodeElement.sendKeys(getRandomFromArray(postalCodes));

        WebElement cityElement = driver.findElement(By.name("city"));
        cityElement.sendKeys(getRandomFromArray(cities));

        WebElement countryListElement = driver.findElement(By.name("id_country"));
        countryListElement.click();
        countryListElement.sendKeys("u");

        WebElement saveButtonElement2 = driver.findElement(By.xpath("//*[@id='content']/div/div/form/footer/button"));
        saveButtonElement2.click();
        Assert.assertEquals("Address successfully added!", driver.findElement(By.cssSelector("article.alert")).getText());
    }

    public String randomString() {
        return RandomString.make(8);
    }

    public static String getRandomFromArray(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}
