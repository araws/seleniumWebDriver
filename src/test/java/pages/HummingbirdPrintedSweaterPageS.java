package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HummingbirdPrintedSweaterPageS {

    private WebDriver driver;

    @FindBy(className = "h1")
    private WebElement productNameHeader;

    @FindBy(id = "group_1")
    private WebElement sizeElement;

//    @FindBy(id = "quantity_wanted")
//    private WebElement quantityField;
//
//    @FindBy(id = "myModalLabel")
//    private WebElement successInformation;
//
//    @FindBy(css = "[data-button-action='add-to-cart']")
//    private WebElement addToCartButton;
//
//    @FindBy(xpath = "//*[@id='blockcart-modal']/div//a")
//    private WebElement proceedToCheckoutButton;

    public HummingbirdPrintedSweaterPageS(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductNameHeader() {
        return productNameHeader.getText();
    }

    public void chooseSize(String size){
        Select select = new Select(sizeElement);
        select.selectByVisibleText(size);
    }
//
//    public void setQuantity(String quantity){
//        quantityField.click();
//        quantityField.clear();
//        quantityField.sendKeys(quantity);
//    }
//
//    public void addToCart(){
//        addToCartButton.click();
//    }
//
//    public String getProductAddedInformation(){
//        return successInformation.getText();
//    }
//
//    public void proceedToCheckout(){
//        proceedToCheckoutButton.click();
//    }
}
