import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class DynamicLoadTest extends TestBase{

    @Test
    public void dynamicLoadExampleOneTest(){
        WebElement contextMenuText = driver.findElement(By.cssSelector("a[href*='dynamic_loading']"));
        contextMenuText.click();

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
        WebElement contextMenuText = driver.findElement(By.cssSelector("a[href*='dynamic_loading']"));
        contextMenuText.click();

        chooseExample(2);
        WebElement startButton = driver.findElement(By.cssSelector("#start button"));
        startButton.click();

        WebDriverWait driverWait = new WebDriverWait(driver, 5);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loading")));
        WebElement finishText = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#finish h4")));

        String text = finishText.getText();
        assertEquals(text,"Hello World!");
    }

    public void chooseExample(int choice){
        WebElement choiceText = driver.findElement(By.cssSelector(String.format("a[href*='dynamic_loading/%s']", choice)));
        choiceText.click();
    }
}
