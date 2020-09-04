package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountPage {
    private WebDriver driver;

    @FindBy(css = "#addresses-link span")
    private WebElement addressesButton;

    @FindBy(css = ".logo")
    private WebElement myStoreButton;

    @FindBy(css = "#main h1")
    private WebElement pageHeader;

    public YourAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToYourAddressesPage(){
        addressesButton.click();
    }

    public void goToMainPage(){
        myStoreButton.click();
    }

    public String getPageHeader(){
        return pageHeader.getText();
    }
}
