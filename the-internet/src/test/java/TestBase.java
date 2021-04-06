import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    private static final String CHROMEDRIVER_EXE = "src/main/resources/chromedriver.exe";
    public WebDriver driver;

    @BeforeMethod
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_EXE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://the-internet.herokuapp.com/");
    }

    @AfterMethod
    public void afterTest(){
        driver.close();
        driver.quit();
    }
}
