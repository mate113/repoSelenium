import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class EntryAdTest extends TestBase{

    @Test
    public void closeEntryAdTest(){
        WebElement addRemoveElement = driver.findElement(By.cssSelector("a[href*='entry_ad']"));
        addRemoveElement.click();

        WebDriverWait driverWait = new WebDriverWait(driver, 3);
        WebElement entryAd = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal")));

        WebElement closeButton = driver.findElement(By.cssSelector(".modal-footer p"));
        closeButton.click();

        driverWait.until(ExpectedConditions.invisibilityOf(entryAd));
    }
}
