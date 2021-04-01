import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JSAlertsTest {

    private static final String CHROMEDRIVER_EXE = "src/main/resources/chromedriver.exe";
    private WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_EXE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl");
        WebElement addRemoveElement = driver.findElement(By.cssSelector("a[href*='javascript_alerts']"));
        addRemoveElement.click();
    }

    @Test
    public void jsAlertTest(){
        WebElement jsAlert = driver.findElement(By.cssSelector("ul li:nth-child(1) > button"));

        jsAlert.click();
        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();
        WebElement resultText = driver.findElement(By.id("result"));
        assertEquals(resultText.getText(), "You successfuly clicked an alert");
    }

    @Test
    public void jsConfirmAlertTest(){
        WebElement jsConfirmAlert = driver.findElement(By.cssSelector("ul li:nth-child(2) > button"));

        jsConfirmAlert.click();
        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(), "I am a JS Confirm");
        alert.accept();
        WebElement resultText = driver.findElement(By.id("result"));
        assertEquals(resultText.getText(), "You clicked: Ok");

        jsConfirmAlert.click();
        alert = driver.switchTo().alert();
        assertEquals(alert.getText(), "I am a JS Confirm");
        alert.dismiss();
        assertEquals(resultText.getText(), "You clicked: Cancel");
    }

    @Test
    public void jsPromptAlertTest(){
        String input = "Hello World";
        WebElement jsPromptAlert = driver.findElement(By.cssSelector("ul li:nth-child(3) > button"));

        jsPromptAlert.click();
        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(), "I am a JS prompt");
        alert.sendKeys(input);
        alert.accept();
        WebElement resultText = driver.findElement(By.id("result"));
        assertEquals(resultText.getText(), String.format("You entered: %s", input));

        jsPromptAlert.click();
        alert = driver.switchTo().alert();
        assertEquals(alert.getText(), "I am a JS prompt");
        alert.dismiss();
        assertEquals(resultText.getText(), "You entered: null");
    }

    @AfterTest
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
