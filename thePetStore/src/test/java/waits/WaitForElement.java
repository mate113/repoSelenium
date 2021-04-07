package waits;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement {

    private static WebDriverWait getWebDriverWait(){
        return new WebDriverWait(DriverManager.getDriver(), 10);
    }

    public static void waitForElementToBeVisible(WebElement element){
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebElement element){
        WebDriverWait webDriverWait = getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
