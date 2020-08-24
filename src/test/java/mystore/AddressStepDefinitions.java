package mystore;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.NewAddressPage;

import java.util.concurrent.TimeUnit;

public class AddressStepDefinitions {

    WebDriver driver;

    NewAddressPage newAddressPage;

    @Given("^User is logged in to CodersLab shop - new address test$")
    public void userIsLoggedInToCodersLabShopNewAddressTest() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("johnd@mail.com", "qwerty");

        newAddressPage = new NewAddressPage(driver);
    }

    @When("^User goes to new address page$")
    public void userGoesToNewAddressPage() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=address");


        newAddressPage = new NewAddressPage(driver);
    }

    @When("^User fills alias \"([^\"]*)\"$")
    public void userFillsAlias(String alias) {
        newAddressPage.inputAlias(alias);
    }

    @And("^User fills Address \"([^\"]*)\"$")
    public void userFillsAddress(String address) {
        newAddressPage.inputAddress(address);
    }

    @And("^User fills City \"([^\"]*)\"$")
    public void userFillsCity(String city) {
        newAddressPage.inputCity(city);
    }

    @And("^User fills Zip \"([^\"]*)\"$")
    public void userFillsZip(String zip) {
        newAddressPage.inputZip(zip);
    }

    @And("^User clicks Save button$")
    public void userClicksSaveButton() {
        newAddressPage.saveAddress();
    }

    @Then("^User sees \"([^\"]*)\" - new address test$")
    public void userSeesNewAddressTest(String message) {

    }
}
