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
}
