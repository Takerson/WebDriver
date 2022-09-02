package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailFor10MinHomePage {
    private static final String MAIL_FOR_10_MIN_PAGE_URL = "https://yopmail.com/ ";
    private WebDriver driver;

    @FindBy(xpath = "//*[contains(text(),'Случайный адрес электронной почты')]")
    private WebElement generateRandomMail;

    public MailFor10MinHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public MailFor10MinHomePage openMailGeneratorPage(){
        driver.get(MAIL_FOR_10_MIN_PAGE_URL);
        return this;
    }

    public GeneratedEmail generateAnEmail(){
        generateRandomMail.click();
        return new GeneratedEmail(driver);
    }
}
