package bdd;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.utility.RandomString;
import org.junit.Assert;
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

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("https://qloapps.coderslab.pl/pl/logowanie?back=my-account");

    }

    @When("user inputs email into address field")
    public void userInputsEmailIntoAddressField() {
        WebElement emailField = driver.findElement(By.id("email_create"));
        emailField.click();
        emailField.sendKeys(randomEmail);
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

    @And("user clicks Register button")
    public void userClicksRegisterButton() {
        driver.findElement(By.id("submitAccount")).click();
    }

    @Then("success message appears")
    public void successMessageAppears() {
        WebElement messageElement = driver.findElement(By.cssSelector("[class='alert alert-success']"));
        Assert.assertEquals("Your account has been created.", messageElement.getText());
    }

    @And("close browser")
    public void closeBrowser() {
        driver.quit();
    }

    String randomEmail = randomString() + "@o2.pl";
    public String randomString() {
        return RandomString.make(8);
    }
}
