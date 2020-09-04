package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='_desktop_user_info']/div/a/span")
    private WebElement singInElement;

    @FindBy(name = "s")
    private WebElement searchProductField;

    @FindBy(css = "[data-id-product='2'] img")
    private WebElement hummingbirdPrintedSweaterImg;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPage(){
        singInElement.click();
    }

    public void searchProduct(String productName){
        searchProductField.click();
        searchProductField.clear();
        searchProductField.sendKeys(productName);
        searchProductField.submit();
    }

    public void goToHummingbirdPrintedSweaterPage(){
        hummingbirdPrintedSweaterImg.click();
    }
}
