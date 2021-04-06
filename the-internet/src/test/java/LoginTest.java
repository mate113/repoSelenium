import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends TestBase{

    private static final String CORRECT_USERNAME = "tomsmith";
    private static final String CORRECT_PASSWORD = "SuperSecretPassword!";

    @DataProvider(name = "loginData")
    private Object[][] testData(){
        return new Object[][]{
                {CORRECT_USERNAME, "SuperSecretPassword", "Your password is invalid!\n×"},
                {"tomsmith1", CORRECT_PASSWORD, "Your username is invalid!\n×"},
                {"tomsmith1", "SuperSecretPassword", "Your username is invalid!\n×"}
        };
    };

    @Test(dataProvider = "loginData")
    public void failedLoginTest(String username, String password, String message){
        WebElement addRemoveElement = driver.findElement(By.cssSelector("a[href*='login']"));
        addRemoveElement.click();

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        WebDriverWait driverWait = new WebDriverWait(driver, 3);
        WebElement errorMessage = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));
        String failedLoginText = errorMessage.getText();
        assertEquals(failedLoginText, message);

        WebElement closeButton = driver.findElement(By.className("close"));
        closeButton.click();
        driverWait.until(ExpectedConditions.invisibilityOf(errorMessage));
    }

    @Test
    public void successLoginTest(){
        WebElement addRemoveElement = driver.findElement(By.cssSelector("a[href*='login']"));
        addRemoveElement.click();

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys(CORRECT_USERNAME);

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(CORRECT_PASSWORD);

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        WebDriverWait driverWait = new WebDriverWait(driver, 5);
        WebElement successMessage = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));
        String successText = successMessage.getText();
        assertEquals(successText, "You logged into a secure area!\n×");

        WebElement logoutButton = driver.findElement(By.cssSelector("a[href*='logout']"));
        logoutButton.click();

        driverWait = new WebDriverWait(driver, 5);
        successMessage = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));
        successText = successMessage.getText();
        assertEquals(successText, "You logged out of the secure area!\n×");
    }
}
