package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchListPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@data-ctorig='https://cloud.google.com/products/calculator']")
    private WebElement chooseThePrisingCalculatorPageFromSearchList;

    public GoogleSearchListPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public GoogleCalculatorPage selectPricingCalculatorPageFromSearchList(){
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(chooseThePrisingCalculatorPageFromSearchList));
        chooseThePrisingCalculatorPageFromSearchList.click();
        return new GoogleCalculatorPage(driver);
    }
}
