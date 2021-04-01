import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

import static org.testng.Assert.*;

public class HoverTest {

    private static final String CHROMEDRIVER_EXE = "src/main/resources/chromedriver.exe";
    private WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_EXE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl");
        WebElement addRemoveElement = driver.findElement(By.cssSelector("a[href*='hovers']"));
        addRemoveElement.click();
    }

    @Test
    public void hoverOverTheAvatarTest(){
        List<WebElement> userAvatars = driver.findElements(By.cssSelector(".figure"));
        List<WebElement> userNames = driver.findElements(By.cssSelector(".figcaption"));
        Actions actions = new Actions(driver);

        userNames.forEach(name -> assertFalse(name.isDisplayed()));

        for (int i = 0; i < userAvatars.size(); i++) {
            actions.moveToElement(userAvatars.get(i)).perform();
            for (int j = 0; j < userNames.size(); j++) {
                if (j==i) assertTrue(userNames.get(j).isDisplayed());
                else assertFalse(userNames.get(j).isDisplayed());
            }
        }
    }

    @AfterTest
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
