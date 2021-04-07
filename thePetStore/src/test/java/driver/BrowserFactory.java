package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
    private static String CHROMEDRIVER_EXE = "src/main/resources/chromedriver.exe";
    private static String GECKODRIVER_EXE = "src/main/resources/geckodriver.exe";
    private static String IEDRIVERSERVER_EXE = "src/main/resources/IEDriverServer.exe";

    public static WebDriver getBrowser(BrowserType browser){
        switch (browser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_EXE);
                return new ChromeDriver();
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", GECKODRIVER_EXE);
                return new FirefoxDriver();
            case IE:
                System.setProperty("webdriver.ie.driver", IEDRIVERSERVER_EXE);
                return new InternetExplorerDriver();
            default:
                throw new IllegalStateException("Unknown browser type! Please check your configuration");
        }
    }
}
