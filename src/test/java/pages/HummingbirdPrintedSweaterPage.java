package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HummingbirdPrintedSweaterPage {

    private WebDriver driver;

    @FindBy(className = "h1")
    private WebElement productNameHeader;

    public HummingbirdPrintedSweaterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductNameHeader(){
        return productNameHeader.getText();
    }
}
