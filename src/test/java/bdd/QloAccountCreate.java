package bdd;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class QloAccountCreate {

    WebDriver driver;

    @Given("User is on the authentication page")
    public void goToAccountCreationPage() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("https://qloapps.coderslab.pl/pl/logowanie?back=my-account");

    }

    @When("user inputs (.*) into address field")
    public void userInputsEmailIntoAddressField(String email) {
        WebElement emailField = driver.findElement(By.id("email_create"));
        emailField.click();
        emailField.sendKeys(email);
    }

    @And("user clicks Create an account button")
    public void userClicksCreateAnAccountButton() {
        driver.findElement(By.id("SubmitCreate")).click();
    }

    @When("user fills (.*), (.*), (.*)")
    public void userFillsFirstNameLastNameAndPassword(
            String firstName,
            String lastName,
            String password) {
        driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
        driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
        driver.findElement(By.id("passwd")).sendKeys(password);
    }
}
