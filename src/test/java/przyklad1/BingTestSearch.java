package przyklad1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BingTestSearch {

    private WebDriver driver;

    @Before
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

        Assert.assertTrue(title.contains(phrase));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
