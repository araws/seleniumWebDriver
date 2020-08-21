package przyklad1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Uruchom nowy egzemplarz przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();

        // Przejdź do Google
        driver.get("http://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @Test
    public void formTest() {

        WebElement firstNameElement = driver.findElement(By.id("first-name"));
        WebElement firstNameHeader = driver.findElement(By.cssSelector("[for='first-name']"));
        String name = "Karol";
        if (firstNameElement.isEnabled()) {
            firstNameElement.sendKeys(name);
            System.out.println(firstNameHeader.getText() + " : " + name);
        }

        WebElement lastNameElement = driver.findElement(By.id("last-name"));
        WebElement lastNameHeader = driver.findElement(By.cssSelector("[for='last-name']"));
        String surname = "Kowalski";
        if (firstNameElement.isDisplayed()) {
            lastNameElement.sendKeys(surname);
            System.out.println(lastNameHeader.getText() + " : " + surname);
        }

        //oporny na zmimany, nieodporny gdy istnieje więcej niż jeden element
//        driver.findElement(By.xpath("//label[text()='Male']")).click();
//        driver.findElement(By.xpath("//label[text()='Female']")).click();

        //odporne na zmiany, mniej czytelny lokator
        WebElement radioButtonFemale = driver.findElement(By.xpath("//label[text()='Female']/input[@name='gender']"));
        WebElement radioButtonMale = driver.findElement(By.xpath("//label[text()='Male']/input[@name='gender']"));
        WebElement genderHeader = driver.findElement(By.cssSelector("[for='gender']"));
        if (firstNameElement.isEnabled()) {
            radioButtonMale.click();
            System.out.println(genderHeader.getText() + " : " + radioButtonMale.getText());
        }
        if (radioButtonMale.isSelected()) {
            System.out.println("Radio Button Male is selected");
        }
        if (!radioButtonFemale.isSelected()) {
            System.out.println("Radio Button Female is NOT selected");
        }

        //Nieodporne na zmiany, np. w kolejności wyświetlania elementów
//        List<WebElement> genders = driver.findElements(By.name("gender"));
//        genders.get(0).click(); //Male
//        genders.get(1).click(); //Female
//        genders.get(2).click(); //In Between

        WebElement dataOfBirthElement = driver.findElement(By.id("dob"));
        WebElement dataOfBirthHeader = driver.findElement(By.cssSelector("[for='dob']"));
        String dateOfBirth = "05/22/2010";
        if (dataOfBirthElement.isEnabled()) {
            dataOfBirthElement.sendKeys(dateOfBirth);
            System.out.println(dataOfBirthHeader.getText() + " : " + dateOfBirth);
        }

        WebElement addressElement = driver.findElement(By.id("address"));
        WebElement addressHeader = driver.findElement(By.cssSelector("[for='address']"));
        String address = "Prosta 51";
        if (addressElement.isEnabled()){
            addressElement.sendKeys(address);
            System.out.println(addressHeader.getText() + " : " + address);
        }

        WebElement emailElement = driver.findElement(By.id("email"));
        WebElement emailHeader = driver.findElement(By.cssSelector("[for='email']"));
        String email = "karol.kowalski@mailinator.com";
        if (emailElement.isEnabled()){
            emailElement.sendKeys(email);
            System.out.println(emailHeader.getText() + " : " + email);
        }

        WebElement passwordElement = driver.findElement(By.id("password"));
        WebElement passwordHeader = driver.findElement(By.cssSelector("[for='password']"));
        String password = "Pass123";
        if (passwordElement.isEnabled()){
            passwordElement.sendKeys(password);
            System.out.println(passwordHeader.getText() + " : " + password);
        }

        WebElement companyElement = driver.findElement(By.id("company"));
        WebElement companyHeader = driver.findElement(By.cssSelector("[for='company']"));
        String company = "Coders Lab";
        if (companyElement.isEnabled()){
            companyElement.sendKeys(company);
            System.out.println(companyHeader.getText() + " : " + company);
        }

        Select roles = new Select(driver.findElement(By.id("role")));
        roles.selectByVisibleText("QA");

        WebElement commentElement = driver.findElement(By.id("comment"));
        WebElement commentHeader = driver.findElement(By.cssSelector("[for='comment']"));
        String comment = "To jest mój pierwszy automat testowy";
        if (commentElement.isEnabled()){
            commentElement.sendKeys(comment);
            System.out.println(commentHeader.getText() + " : " + comment);
        }

        driver.findElement(By.id("submit")).click();
    }
}
