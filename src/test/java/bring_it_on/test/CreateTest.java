package bring_it_on.test;

import bring_it_on.page.CreatePastebinPage;
import bring_it_on.page.NewPastebinPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateTest {
    private WebDriver driver = new ChromeDriver();
    private String textOfPaste = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private String nameOfPaste = "how to gain dominance among developers";
    private String syntax = "Bash";
    NewPastebinPage newPastebinPage;

    @Test(priority = 1)
    public void createNewPateAndVerificationNameOfPaste() {
        driver.manage().window().maximize();
        newPastebinPage = new CreatePastebinPage(driver)
                .openPage()
                .inputCodeInTextField(textOfPaste)
                .selectSyntaxHighlightingFieldAndSelectBash()
                .selectPasteExpirationFieldAndSelect10min()
                .inputPasteNameAndCreateThePaste(nameOfPaste);
        Assert.assertEquals(newPastebinPage.getNameOfPasteText(),nameOfPaste);
    }

    @Test(priority = 2)
    public void verificationSyntax(){
        Assert.assertEquals(newPastebinPage.getSyntaxText(),syntax);
    }

    @Test(priority = 3)
    public void verificationCodeText(){
        Assert.assertEquals(newPastebinPage.getNewPasteText(),textOfPaste);
        driver.quit();
        driver = null;
    }
}
