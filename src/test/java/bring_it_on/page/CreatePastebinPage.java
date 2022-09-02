package bring_it_on.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatePastebinPage {
    private static final String URL = "https://pastebin.com/";
    private WebDriver driver;


    @FindBy(id = "postform-text")
    private WebElement textInputField;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxHighlighting;

    @FindBy(xpath = "//*[contains(@class, 'select2-results__options')]/li[contains(text(), 'Bash')]")
    private WebElement selectBashInSyntaxHighlighting;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpiration;
    @FindBy(xpath = "//*[contains(@class, 'select2-results__options')]/li[contains(text(), '10 Minutes')]")
    private WebElement select10minInPasteExpiration;

    @FindBy(xpath = "//*[@id='postform-name']")
    private WebElement pasteName;


    public CreatePastebinPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public CreatePastebinPage openPage(){
        driver.get(URL);
        return this;
    }

    public CreatePastebinPage inputCodeInTextField(String code){
        textInputField.sendKeys(code);
        return this;
    }

    public CreatePastebinPage selectSyntaxHighlightingFieldAndSelectBash(){
        syntaxHighlighting.click();
        selectBashInSyntaxHighlighting.click();
        return this;
    }

    public CreatePastebinPage selectPasteExpirationFieldAndSelect10min() {
        pasteExpiration.click();
        select10minInPasteExpiration.click();
        return this;
    }

    public NewPastebinPage inputPasteNameAndCreateThePaste(String name) {
        pasteName.sendKeys(name);
        pasteName.submit();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")));
        return new NewPastebinPage(driver);
    }
}
