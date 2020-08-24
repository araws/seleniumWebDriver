package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressPage {

    private WebDriver driver;

    @FindBy(name = "alias")
    private WebElement aliasField;

    @FindBy(name = "address1")
    private WebElement addressField;

    @FindBy(name = "city")
    private WebElement cityField;

    @FindBy(name = "postcode")
    private WebElement zipField;

    @FindBy(xpath = "//*[@id='content']//button")
    private WebElement saveButton;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputAlias(String alias){
        aliasField.clear();
        aliasField.sendKeys(alias);
    }

    public void inputAddress(String address){
        addressField.clear();
        addressField.sendKeys(address);
    }

    public void inputCity(String city){
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void inputZip(String zip){
        zipField.clear();
        zipField.sendKeys(zip);
    }

    public void saveAddress(){
        saveButton.click();
    }
}
