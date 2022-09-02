package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCalculatorPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstance;

    @FindBy(xpath = "//md-card-content[@id='mainForm']//label[text() = 'Series']/following-sibling::md-select")
    private WebElement seriesField ;
    @FindBy(xpath = "//md-option[@value='n1']")
    private WebElement selectSeriesN1;

    @FindBy(xpath = "//md-card-content[@id='mainForm']//label[text() = 'Machine type']/following-sibling::md-select")
    private WebElement machineType ;
    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement selectMachineTypeN1Standard8;

    @FindBy(xpath = "//div[contains(text(),'Add GPUs')]//preceding-sibling::div")
    private WebElement GPUsCheckBox ;
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement GPUTypeField;
    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_T4']")
    private WebElement selectGPUType;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUField;
    @FindBy(xpath = "//md-option[@value='1'][@ng-repeat = 'item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]']")
    private WebElement selectNumberOfGPUField2;

    @FindBy(xpath = "//md-select[@ng-model ='listingCtrl.computeServer.ssd']")
    private WebElement localSSDField;
    @FindBy(xpath = "//md-option[@ng-repeat ='item in listingCtrl.dynamicSsd.computeServer' and @value ='2']")
    private WebElement selectLocalSSD;

    @FindBy(xpath = "//md-select[@ng-model ='listingCtrl.computeServer.location']")
    private WebElement dataCenterLocationField;
    @FindBy(xpath = "//md-option[@ng-repeat ='item in listingCtrl.fullRegionList | filter:listingCtrl.inputRegionText.computeServer' and @value ='europe-west3']")
    private WebElement selectDataCenterLocation;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage' and @ng-model = 'listingCtrl.computeServer.cud']")
    private WebElement committedUsageField;
    @FindBy(xpath = "//md-select-menu[contains(@style, 'transform-origin')]//div[text()='1 Year']/parent::md-option")
    private WebElement selectCommittedUsage1Year;

    @FindBy(xpath = "//button[not(@disabled)][contains(text(),'Add to Estimate')]")
    private WebElement addToEstimateButton;
    @FindBy(xpath = "//button[contains(text(),'Email')]")
    private WebElement emailButton;

    @FindBy(xpath = "//input[@name = 'description' and @type = 'email']")
    private WebElement emailInputField;


    @FindBy(xpath = "//article[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement parentFrame;
    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement frame;


    public GoogleCalculatorPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public GoogleCalculatorPage setUpNumberOfInstance(String number)  {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(parentFrame));
        driver.switchTo().frame(parentFrame);
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(frame));
        driver.switchTo().frame(frame);
        numberOfInstance.sendKeys(number);
        return this;
    }

    public GoogleCalculatorPage selectMachineType()  {
        seriesField.click();
        webElementWaitToBeClickableWithClick(selectSeriesN1);
        return this;
    }

    public GoogleCalculatorPage selectMachine() {
        machineType.click();
        webElementWaitToBeClickableWithClick(selectMachineTypeN1Standard8);
        return this;
    }

    public GoogleCalculatorPage addGPU(){
        GPUsCheckBox.click();
        return this;
    }

    public GoogleCalculatorPage selectGpuType(){
        webElementWaitToBeClickableWithClick(GPUTypeField);
        webElementWaitToBeClickableWithClick(selectGPUType);
        return this;
    }

    public GoogleCalculatorPage setUpNumberOfGPUs(){
        numberOfGPUField.click();
        webElementWaitToBeClickableWithClick(selectNumberOfGPUField2);
        return this;
    }

    public GoogleCalculatorPage selectLocalSSD(){
        localSSDField.click();
        webElementWaitToBeClickableWithClick(selectLocalSSD);
        return this;
    }

    public GoogleCalculatorPage choosingADatacenterLocal(){
        dataCenterLocationField.click();
        webElementWaitToBeClickableWithClick(selectDataCenterLocation);
        return this;
    }

    public GoogleCalculatorPage selectCommittedUsageDate(){
        committedUsageField.click();
        webElementWaitToBeClickableWithClick(selectCommittedUsage1Year);
        return this;
    }

    public CreatedEstimate createAnEstimate(){
        addToEstimateButton.click();
        return new CreatedEstimate(driver);
    }

    public void webElementWaitToBeClickableWithClick(WebElement webElement){
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }
}
