package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateYourAddressPage {

    private WebDriver driver;

    @FindBy(css = "#main h1")
    private WebElement pageHeader;

    @FindBy(css = "input[name=alias]")
    private WebElement aliasField;

    @FindBy(css = "input[name=address1]")
    private WebElement addressField;

    @FindBy(css = "input[name=city]")
    private WebElement cityField;

    @FindBy(css = "input[name=postcode]")
    private WebElement zipField;

    @FindBy(css = "input[name='phone']")
    private WebElement phoneField;

    @FindBy(xpath = "//*[@id='content']//button")
    private WebElement saveButton;

    public UpdateYourAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getAliasValue() {
        return aliasField.getAttribute("value");
    }

    public String getAddressValue() {
        return addressField.getAttribute("value");
    }

    public String getCityValue() {
        return cityField.getAttribute("value");
    }

    public String getZipValue() {
        return zipField.getAttribute("value");
    }

    public String getPhoneValue() {
        return phoneField.getAttribute("value");
    }

    public void saveAddress() {
        saveButton.click();
    }
}
