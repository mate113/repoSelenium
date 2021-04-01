import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;


public class DynamicLoadTest {

    public static final String CHROMEDRIVER_EXE = "src//main//resources//chromedriver.exe";
    WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_EXE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl");
        WebElement contextMenuText = driver.findElement(By.cssSelector("a[href*='dynamic_loading']"));
        contextMenuText.click();
    }

    @Test
    public void dynamicLoadExampleOneTest(){
        chooseExample(1);
        WebElement startButton = driver.findElement(By.cssSelector("#start button"));
        startButton.click();

        WebDriverWait driverWait = new WebDriverWait(driver, 5);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loading")));

        WebElement finishText = driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish h4")));
        String text = finishText.getText();
        assertEquals(text,"Hello World!");
    }

    @Test
    public void dynamicLoadExampleTwoTest(){
        chooseExample(2);
        WebElement startButton = driver.findElement(By.cssSelector("#start button"));
        startButton.click();

        WebDriverWait driverWait = new WebDriverWait(driver, 5);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loading")));
        WebElement finishText = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#finish h4")));

        String text = finishText.getText();
        assertEquals(text,"Hello World!");
    }


    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }

    public void chooseExample(int choice){
        WebElement choiceText = driver.findElement(By.cssSelector(String.format("a[href*='dynamic_loading/%s']", choice)));
        choiceText.click();
    }
}
