package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HummingbirdPrintedSweaterPage {

    private WebDriver driver;

    @FindBy(className = "h1")
    private WebElement productNameHeader;

    @FindBy(id = "group_1")
    private WebElement sizeElement;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityField;

    public HummingbirdPrintedSweaterPage(WebDriver driver) {
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

    public void setQuantity(String quantity){
        quantityField.click();
        quantityField.clear();
        quantityField.sendKeys(quantity);
    }

    public void addToCart(){
        quantityField.submit();
    }
}
