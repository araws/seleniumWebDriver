package mystore;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.UserInfoPage;

import java.util.concurrent.TimeUnit;

public class ChangeUserInfoSteps {

    private WebDriver driver;

    UserInfoPage userInfoPage;

    @Given("^User is logged in to CodersLab shop$")
    public void userIsLoggedInToCodersLabShop() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("johnd@mail.com", "qwerty");

        userInfoPage = new UserInfoPage(driver);
    }

    @When("^User goes to UserInformationPage$")
    public void userGoesToUserInformationPage() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=identity");
    }

    @And("^User changes his birthdate to \"([^\"]*)\"$")
    public void userChangesHisBirthdayTo(String birthdate) {
        userInfoPage.setBirthdate(birthdate);
    }

    @And("^User signs up for our newsletter$")
    public void userSignsUpForOurNewsletter() {
        userInfoPage.singInForNewsletter();
    }

    @And("^User saves information$")
    public void userSavesInformation() {
        userInfoPage.submitUserInfo();
    }

    @Then("^User sees \"([^\"]*)\"$")
    public void userSees(String message) {
        Assert.assertEquals(message, userInfoPage.getUpdateInformation());
    }
}
