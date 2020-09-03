package mystore;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class MyStoreAddAddress {

    WebDriver driver;

    IndexPage indexPage;
    LoginPage loginPage;
    YourAccountPage yourAccountPage;
    YourAddressesPage yourAddressesPage;
    NewAddressPage newAddressPage;


    @Given("^User is created in to CodersLab shop, one address is created and User is logged out$")
    public void userIsCreatedInToCodersLabShopOneAddressIsCreatedAndUserIsLoggedOut() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php");
        indexPage = new IndexPage(driver);
    }

    @When("^User goes to Login Page$")
    public void userGoesToLoginPage() {
        indexPage.goToLoginPage();
        loginPage = new LoginPage(driver);
        Assert.assertEquals("Log in to your account", loginPage.getPageHeader());
    }

    @When("^User logs with Email \"([^\"]*)\" and Password \"([^\"]*)\"$")
    public void userLogsWithEmailAndPassword(String email, String password) {
        loginPage.loginAs(email, password);
        yourAccountPage = new YourAccountPage(driver);
        Assert.assertEquals("Your account", yourAccountPage.getPageHeader());
    }

    @Then("^User clicks Addresses button and goes to Your addresses page$")
    public void userClicksAddressesButton() {
        yourAccountPage.goToYourAddressesPage();
        Assert.assertEquals("Your addresses", yourAddressesPage.getPageHeader());
    }

    @When("^User clicks Create new address button$")
    public void userClicksCreateNewAddressButton() {
        yourAddressesPage.goToNewAddressPage();
        newAddressPage = new NewAddressPage(driver);
        Assert.assertEquals("New address", newAddressPage.getPageHeader());
    }

    @And("^User fills Alias \"([^\"]*)\" in form$")
    public void userFillsAliasInForm(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^User fills Address \"([^\"]*)\" in form$")
    public void userFillsAddressInForm(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^User fills City \"([^\"]*)\" in form$")
    public void userFillsCityInForm(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^User fills Zip \"([^\"]*)\" in form$")
    public void userFillsZipInForm(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^User chooses Country from list$")
    public void userChoosesCountryFromList() {
    }

    @And("^User fills Phone \"([^\"]*)\" in form$")
    public void userFillsPhoneInForm(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^User clicks Save button in form$")
    public void userClicksSaveButtonInForm() {
    }

    @Then("^User sees \"([^\"]*)\" on page$")
    public void userSeesOnPage(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Data is correct in new address$")
    public void dataIsCorrectInNewAddress() {
    }

    @When("^User clicks Delete button in new address$")
    public void userClicksDeleteButtonInNewAddress() {
    }

    @And("^There is only one previous made address on page$")
    public void thereIsOnlyOnePreviousMadeAddressOnPage() {
    }
}
