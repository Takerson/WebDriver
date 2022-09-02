package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailBox {
    private WebDriver driver;

    @FindBy(id = "refresh")
    private WebElement refreshButton;
    @FindBy(xpath = "//h3[contains(text(),'USD')]")
    private WebElement estimatedMonthlyCost;
    @FindBy(id = "ifmail")
    private WebElement frame;


    public EmailBox(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void refreshEmailBox(){
        new WebDriverWait(driver,15).until(ExpectedConditions.elementToBeClickable(refreshButton));
        refreshButton.click();
    }

    public String getEstimatedCostPerMonthFromEmailBox(){
        refreshEmailBox();
        driver.switchTo().frame(frame);
        new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOf(estimatedMonthlyCost));
        String s = estimatedMonthlyCost.getText().replaceAll("[a-zA-Z\\s]","").trim();
        return s;
    }

}
