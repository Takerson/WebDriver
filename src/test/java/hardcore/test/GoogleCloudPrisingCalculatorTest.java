package hardcore.test;

import hardcore.page.CreatedEstimate;
import hardcore.page.EmailBox;
import hardcore.page.GeneratedEmail;
import hardcore.page.GoogleHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleCloudPrisingCalculatorTest {
    private WebDriver driver = new ChromeDriver();
    EmailBox emailBox;
    private String searchText = "Google Cloud Platform Pricing Calculator";
    private String numberOfInstance = "4 x";

    @Test(priority = 1)
    public void createNewEstimateAnd() {
        driver.manage().window().maximize();
        emailBox = new GoogleHomePage(driver)
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
                .createAnEstimate()
                .createNewTabAndRotateToIt()
                .openMailGeneratorPage()
                .generateAnEmail()
                .copyAGeneratedEmailAddressAndSwitchToCalculatorPage()
                .clickOnEmailButton()
                .enterACreatedEmailAndSendToEmail(GeneratedEmail.emailAddress)
                .switchToEmailTab()
                .checkEmailBox();
        Assert.assertEquals(emailBox.getEstimatedCostPerMonthFromEmailBox(), CreatedEstimate.priceInCalculator);
        driver.quit();
        driver = null;
    }
}
