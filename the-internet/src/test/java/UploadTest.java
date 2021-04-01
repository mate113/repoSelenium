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

import static org.testng.Assert.assertEquals;


public class UploadTest {

    public static final String CHROMEDRIVER_EXE = "src/main/resources/chromedriver.exe";
    public static final String UPLOAD_FILE = "C:/SeleniumFiles/text.txt";
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_EXE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl");
        WebElement addRemoveElement = driver.findElement(By.cssSelector("a[href*='upload']"));
        addRemoveElement.click();
    }

    @Test
    public void uploadFileTest(){
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
        chooseFileButton.sendKeys(UPLOAD_FILE);

        WebElement submitButton = driver.findElement(By.id("file-submit"));
        submitButton.click();

        WebDriverWait driverWait = new WebDriverWait(driver, 5);
        WebElement successText = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".example h3")));
        String text = successText.getText();

        assertEquals(text, "File Uploaded!");

        WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
        String fileName = uploadedFiles.getText();
        String[] path = UPLOAD_FILE.split("/");
        assertEquals(fileName, path[path.length-1]);
    }

    @AfterTest
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
