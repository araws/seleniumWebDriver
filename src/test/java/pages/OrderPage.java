package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
    private WebDriver driver;

    @FindBy(name = "confirm-addresses")
    private WebElement confirmAddressButton;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement confirmDeliveryOptionButton;

    @FindBy(css = "#payment-option-1-container input")
    private WebElement payByCheckRadioButton;

    @FindBy(css = "[type=checkbox]")
    private WebElement termsAgreementCheckbox;

    @FindBy(css = "#payment-confirmation [type=submit]")
    private WebElement orderButton;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptAddress(){
        confirmAddressButton.click();
    }

    public void acceptDeliveryOption(){
        confirmDeliveryOptionButton.click();
    }

    public void choosePayByCheckOption(){
        payByCheckRadioButton.click();
    }

    public void agreeToTerms(){
        termsAgreementCheckbox.click();
    }

    public void order(){
        orderButton.click();
    }
}
