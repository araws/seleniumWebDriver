package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(name = "email")
    private WebElement loginInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit-login")
    private WebElement singInButton;

    @FindBy(xpath = "//*[@id='content']/div/a")
    private WebElement createAccountElement;

    @FindBy(xpath = "//a[@class='account']")
    private WebElement userName;

    @FindBy(xpath = "//*[@id='main']/header/h1")
    private WebElement pageHeader;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void loginAs(String email, String password) {
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(email);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        singInButton.click();
    }

    public void goToCreateNewAccountPage(){
        createAccountElement.click();
    }

    public String getLoggedUserName(){
        return userName.getText();
    }

    public String getPageHeader(){
        return pageHeader.getText();
    }
}