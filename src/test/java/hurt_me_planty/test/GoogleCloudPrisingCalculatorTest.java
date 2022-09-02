package hurt_me_planty.test;

import hurt_me_planty.page.CreatedEstimate;
import hurt_me_planty.page.GoogleHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudPrisingCalculatorTest {
    private WebDriver driver = new ChromeDriver();
    CreatedEstimate createdEstimate;
    private String searchText = "Google Cloud Platform Pricing Calculator";
    private String numberOfInstance = "4 x";
    private String vmClass = "Provisioning model: Regular";
    private String instanceType = "Instance type: n1-standard-8\nCommitted Use Discount applied";
    private String region = "Region: Frankfurt";
    private String localSSD = "Local SSD: 2x375 GiB\nCommitted Use Discount applied";
    private String commitmentTerm = "Commitment term: 1 Year";
    private String priceForMonth = "Total Estimated Cost: USD 1,840.40 per 1 month";

    @Test(priority = 1)
    public void createNewEstimateAnd() {
        driver.manage().window().maximize();
        createdEstimate = new GoogleHomePage(driver)
                .openPage()
                .inputTextInSearchField(searchText)
                .selectPricingCalculatorPageFromSearchList()
                .setUpNumberOfInstance(numberOfInstance)
                .selectMachineType()
                .selectMachine()
                .addGPU()
                .selectGpuType()
                .setUpNumberOfGPUs()
                .selectLocalSSD()
                .choosingADatacenterLocal()
                .selectCommittedUsageDate()
                .createAnEstimate();
        Assert.assertEquals(numberOfInstance,createdEstimate.getNumberOfInstance());
    }

    @Test(priority = 2)
    public void verificationRegion(){
        Assert.assertEquals(region,createdEstimate.getRegion());
    }

    @Test(priority = 3)
    public void verificationInstanceType(){
        Assert.assertEquals(instanceType,createdEstimate.getInstanceType());
    }

    @Test(priority = 4)
    public void verificationVmClass(){
        Assert.assertEquals(vmClass,createdEstimate.getVmClass());
    }

    @Test(priority = 5)
    public void verificationLocalSSD(){
        Assert.assertEquals(localSSD,createdEstimate.getLocalSSD());
    }

    @Test(priority = 6)
    public void verificationCommitmentTerm(){
        Assert.assertEquals(commitmentTerm,createdEstimate.getCommittedTerm());
    }

    @Test(priority = 6)
    public void verificationPriceForMonth(){
        Assert.assertEquals(priceForMonth,createdEstimate.getPriceForMonth());
        driver.quit();
        driver = null;
    }
}
