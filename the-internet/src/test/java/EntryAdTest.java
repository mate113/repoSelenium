import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class EntryAdTest {

    public static final String CHROMEDRIVER_EXE = "src//main//resources//chromedriver.exe";
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_EXE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl");
        WebElement addRemoveElement = driver.findElement(By.cssSelector("a[href*='entry_ad']"));
        addRemoveElement.click();
    }

    @Test
    public void closeEntryAdTest(){
        WebDriverWait driverWait = new WebDriverWait(driver, 3);
        WebElement entryAd = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal")));

        WebElement closeButton = driver.findElement(By.cssSelector(".modal-footer p"));
        closeButton.click();

        driverWait.until(ExpectedConditions.invisibilityOf(entryAd));
    }

    @AfterTest
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
