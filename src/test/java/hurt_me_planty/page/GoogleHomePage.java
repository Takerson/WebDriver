package hurt_me_planty.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHomePage {
    private static final String HOME_PAGE_URL = "https://cloud.google.com/";
    private WebDriver driver;

    @FindBy(xpath = "//input[@name = 'q']")
    private WebElement searchInput;

    public GoogleHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public GoogleHomePage openPage(){
        driver.get(HOME_PAGE_URL);
        return this;
    }

    public GoogleSearchListPage inputTextInSearchField(String searchTextx){
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(searchInput)).sendKeys(searchTextx);
//        searchInput.sendKeys(searchTextx);
        searchInput.submit();
        return new GoogleSearchListPage(driver);
    }

}
