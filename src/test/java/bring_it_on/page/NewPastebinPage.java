package bring_it_on.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPastebinPage {
    WebDriver driver;

    @FindBy(tagName="h1")
    private WebElement nameOfPaste;

    @FindBy(xpath="//*[@href='/archive/bash']")
    private WebElement syntaxText;

    @FindBy(xpath = "//ol[@class = 'bash'] ")
    private  WebElement newPasteText;

    public NewPastebinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getNameOfPasteText(){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(nameOfPaste));
        return nameOfPaste.getText();
    }

    public String getSyntaxText(){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(syntaxText));
        return syntaxText.getText();
    }

    public String getNewPasteText(){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(newPasteText));
        return newPasteText.getText();
    }
}
