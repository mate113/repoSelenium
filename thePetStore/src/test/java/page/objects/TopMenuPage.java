package page.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class TopMenuPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a[href*='signonForm']")
    private WebElement signInLink;

    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void clickOnSignInLink(){
        WaitForElement.waitForElementToBeClickable(signInLink);
        signInLink.click();
        logger.info("Clicked on Sign In link");
    }
}
