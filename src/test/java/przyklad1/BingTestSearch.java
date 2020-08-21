package przyklad1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BingTestSearch {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.bing.com");
    }

    @Test
    public void bingSearchTest() {
        String phrase = "Mistrzostwa świata w piłce nożnej 2018";

        //znajdź pole wpisywania tekstu do wyszukania
        WebElement element = driver.findElement(By.name("q"));

        element.clear();
        element.sendKeys(phrase);
        element.submit();

        String title = driver.getTitle();

        Assertions.assertTrue(title.contains(phrase));
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }
}
