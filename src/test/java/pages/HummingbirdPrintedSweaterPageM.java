package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HummingbirdPrintedSweaterPageM {
    private WebDriver driver;

    @FindBy(id = "quantity_wanted")
    WebElement quantityField;

    @FindBy(id = "myModalLabel")
    private WebElement successInformation;

    @FindBy(css = "section form div [type='submit']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@id='blockcart-modal']/div//a")
    private WebElement proceedToCheckoutButton;

    public HummingbirdPrintedSweaterPageM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setQuantity(String quantity) {
        quantityField.click();
        quantityField.clear();
        quantityField.sendKeys(quantity);
    }

    public void addToCart() {
        addToCartButton.click();
//        quantityField.submit();
    }

    public String getProductAddedInformation() {
        return successInformation.getText();
    }

    public void proceedToCheckout() {
        proceedToCheckoutButton.click();
    }

}
