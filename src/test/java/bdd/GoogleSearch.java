package bdd;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class GoogleSearch {

    private WebDriver driver;

    @Given("an open browser with google.com")
    public void openGoogleSearch() {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.google.com");

        //Sprawdź czy pojawił się modal cookies
        try {
            boolean isModalDisplayed = driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div[2]/div/div/div/div/div[2]/form/div/span/span")).isEnabled();
            if (isModalDisplayed)
                driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div[2]/div/div/div/div/div[2]/form/div/span/span")).click();
        } catch (NoSuchElementException e){
            System.out.println("Brak modalu - przechodzę dalej");
        }

    }

    @When("a keyword (.*) is entered in input field")
    public void enterKeyword(String keyword) {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement element = driver.findElement(By.name("q"));
        // Wyczyść tekst zapisany w elemencie
        element.clear();
        // Wpisz informacje do wyszukania
        element.sendKeys(keyword);
        // Prześlij formularz
        element.submit();
    }

    @Then("the first one should contain (.*)")
    public void theFirstOneShouldContainSelenium(String expectedText) {
        System.out.println(expectedText);
    }


    @And("close the browser")
    public void closeBrowser() {
        driver.quit();
    }
}
