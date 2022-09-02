package hurt_me_planty.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatedEstimate {
    private WebDriver driver;

    // get data about estimate
    @FindBy(xpath = "//*[@id='compute']/md-list/div/div/div/span/span")
    private WebElement numberOfInstance;
    @FindBy(xpath = "//div[contains(text(),'Region: ')]")
    private WebElement region;
    @FindBy(xpath = "//div[contains(text(),'Instance type: ')]")
    private WebElement instanceType;
    @FindBy(xpath = "//div[contains(text(),'Provisioning model: ')]")
    private WebElement vmClass;
    @FindBy(xpath = "//div[contains(text(),'Local SSD: ')]")
    private WebElement localSSD;
    @FindBy(xpath = "//*[contains(text(),'Total Estimated Cost:')]")
    private WebElement priceForMonth;
    @FindBy(xpath = "//div[contains(text(),'Commitment term')]")
    private WebElement committedTerm;


    public CreatedEstimate(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public String getNumberOfInstance() {
        webElementWaitToBeClickable(numberOfInstance);
        return numberOfInstance.getText().trim();
    }

    public String getRegion() {
        webElementWaitToBeClickable(region);
        return region.getText().trim();
    }

    public String getInstanceType() {
        webElementWaitToBeClickable(instanceType);
        return instanceType.getText().trim();
    }

    public String getVmClass() {
        webElementWaitToBeClickable(vmClass);
        return vmClass.getText().trim();
    }

    public String getLocalSSD() {
        webElementWaitToBeClickable(localSSD);
        return localSSD.getText().trim();
    }

    public String getPriceForMonth() {
        webElementWaitToBeClickable(priceForMonth);
        return priceForMonth.getText().trim();
    }

    public String getCommittedTerm() {
        webElementWaitToBeClickable(committedTerm);
        return committedTerm.getText().trim();
    }

    private void webElementWaitToBeClickable(WebElement webElement){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(webElement));
    }
}
