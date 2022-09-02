package i_can_win;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatePaste {
    public static void main( String[] args ) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com/");

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='postform-text']")));

        WebElement textInputField = driver.findElement(By.xpath("//*[@id='postform-text']"));
        textInputField.sendKeys("Hello from WebDriver");
        Thread.sleep(2000);

        WebElement pasteExpiration = driver.findElement(By.id("select2-postform-expiration-container"));
        pasteExpiration.click();

        WebElement select10minInPasteExpiration = driver.findElement(By.xpath("//*[contains(@class, 'select2-results__options')]/li[contains(text(), '10 Minutes')]"));
        select10minInPasteExpiration.click();

        WebElement pasteName = driver.findElement(By.xpath("//*[@id='postform-name']"));
        pasteName.sendKeys("helloweb");
        pasteName.submit();

        Thread.sleep(4000);

        driver.quit();
    }
}
