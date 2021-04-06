import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JSAlertsTest extends TestBase{

    @Test
    public void jsAlertTest(){
        WebElement addRemoveElement = driver.findElement(By.cssSelector("a[href*='javascript_alerts']"));
        addRemoveElement.click();

        WebElement jsAlert = driver.findElement(By.cssSelector("ul li:nth-child(1) > button"));

        jsAlert.click();
        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();
        WebElement resultText = driver.findElement(By.id("result"));
        assertEquals(resultText.getText(), "You successfully clicked an alert");
    }

    @Test
    public void jsConfirmAlertTest(){
        WebElement addRemoveElement = driver.findElement(By.cssSelector("a[href*='javascript_alerts']"));
        addRemoveElement.click();

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
        WebElement addRemoveElement = driver.findElement(By.cssSelector("a[href*='javascript_alerts']"));
        addRemoveElement.click();

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
}
