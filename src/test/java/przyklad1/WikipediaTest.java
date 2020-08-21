package przyklad1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();

        // Przejdź do Google
        driver.get("https://pl.wikipedia.org/");
    }

    @Test
    public void wikiTest(){

        // Metoda .getText()
//        WebElement element = driver.findElement(By.id("main-page-column1"));
//        System.out.println(element.getText());

        // .getAttribute()
        WebElement mainPageElement = driver.findElement(By.id("main-page-content"));
        String attribute = mainPageElement.getAttribute("class");
        System.out.println("Attribute is: " + attribute);

        // .getTagName()
        String tag = mainPageElement.getTagName();
        System.out.println("Tag is: " + tag);

        // .isEnabled()
        WebElement searchInputElement = driver.findElement(By.id("searchInput"));
//        if (searchInputElement.isEnabled()){
        if (searchInputElement.isDisplayed()){
            searchInputElement.sendKeys("Selenium");
            searchInputElement.submit();
        } else {
            Assertions.fail();
        }
    }

    @AfterEach
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        driver.quit();
    }
}
