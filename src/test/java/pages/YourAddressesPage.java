package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAddressesPage {
    WebDriver driver;

    @FindBy(css = "#main h1")
    private WebElement pageHeader;

    @FindBy(css = ".addresses-footer span")
    private WebElement createNewAddressButton;

    @FindBy(css = ".alert li")
    private WebElement successInformation;

    @FindBy(css = "#content div:nth-child(3) article a:last-child span")
    private WebElement deleteSecondAddressButton;

    @FindBy(css = "#content div:nth-child(3) article a:first-child span")
    private WebElement editSecondAddressButton;

    public YourAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToNewAddressPage() {
        createNewAddressButton.click();
    }

    public String getPageHeader() {
        return pageHeader.getText();
    }

    public String getAddressCreatedInformation() {
        return successInformation.getText();
    }

    public String getAddressDeletedInformation() {
        return successInformation.getText();
    }

    public void deleteCreatedSecondAddress(){
        deleteSecondAddressButton.click();
    }

    public void editCreatedSecondAddress(){
        editSecondAddressButton.click();
    }
}
