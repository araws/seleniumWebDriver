package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInfoPage {
    private static WebDriver driver;

    @FindBy(name = "birthday")
    WebElement birthdayInput;

    @FindBy(name = "newsletter")
    WebElement newsletterCheckbox;

    @FindBy(css = ".btn.btn-primary.form-control-submit")
    WebElement submitButton;

    @FindBy(css = ".alert.alert-success")
    WebElement successInformation;

    @FindBy(name = "password")
    WebElement passwordInput;

    public UserInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void singInForNewsletter(){
        if (!newsletterCheckbox.isSelected())
            newsletterCheckbox.click();
    }

    public void signOutFromNewsletter() {
        if (newsletterCheckbox.isSelected())
            newsletterCheckbox.click();
    }

    public void setBirthdate(String birthDate) {
        birthdayInput.click();
        birthdayInput.clear();
        birthdayInput.sendKeys(birthDate);
    }

    public void submitUserInfo() {
        passwordInput.sendKeys("qwerty");
        submitButton.click();
    }

    public String getUpdateInformation() {
        return successInformation.getText();
    }
}
