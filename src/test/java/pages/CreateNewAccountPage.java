package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewAccountPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='main']/header/h1")
    private WebElement pageHeader;

    public CreateNewAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageHeader(){
        return pageHeader.getText();
    }
}
