import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;


public class AddRemoveTest {

    public static final String CHROMEDRIVER_EXE = "src//main//resources//chromedriver.exe";
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_EXE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl");
        WebElement addRemoveElement = driver.findElement(By.cssSelector("a[href*='add_remove']"));
        addRemoveElement.click();
    }

    @Test
    public void addRemoveTest(){
        WebElement addButton = driver.findElement(By.cssSelector("button"));
        addButton.click();

        List<WebElement> elements = driver.findElements(By.className("added-manually"));
        int elementsCount = elements.size();
        assertTrue(elementsCount == 1);

        elements.get(0).click();

        elements = driver.findElements(By.className("added-manually"));
        elementsCount = elements.size();

        assertTrue(elementsCount == 0);

        for (int i = 0; i < 5; i++) {
            addButton.click();
        }

        elements = driver.findElements(By.className("added-manually"));
        elementsCount = elements.size();

        assertTrue(elementsCount == 5);

        elements.forEach(WebElement::click);

        elements = driver.findElements(By.className("added-manually"));
        elementsCount = elements.size();

        assertTrue(elementsCount == 0);
    }

    @AfterTest
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
