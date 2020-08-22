package mystore;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class MyStoreTest {

    private WebDriver driver;

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
}
