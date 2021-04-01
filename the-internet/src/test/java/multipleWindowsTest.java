import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class multipleWindowsTest {

    private static final String CHROMEDRIVER_EXE = "src/main/resources/chromedriver.exe";
    private WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_EXE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl");
        WebElement addRemoveElement = driver.findElement(By.cssSelector("a[href*='windows']"));
        addRemoveElement.click();
    }

    @Test
    public void jsAlertTest(){
        String titleText = driver.getTitle();
        assertEquals(titleText, "The Internet");

        WebElement newWindow = driver.findElement(By.cssSelector("a[href*='windows/new']"));
        newWindow.click();

        String secondTabTitleText = driver.getTitle();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        assertEquals(secondTabTitleText, "New Window");

//        String titleText = driver.getTitle();
//        assertEquals(titleText, "The Internet");
//
//        WebElement jsAlert = driver.findElement(By.cssSelector("ul li:nth-child(1) > button"));
//        driver.navigate().
//        jsAlert.click();
//        Alert alert = driver.switchTo().alert();
//        assertEquals(alert.getText(), "I am a JS Alert");
//        alert.accept();
//        WebElement resultText = driver.findElement(By.id("result"));
//        assertEquals(resultText.getText(), "You successfuly clicked an alert");
    }

    @AfterTest
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
