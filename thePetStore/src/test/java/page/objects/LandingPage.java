package page.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class LandingPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "#Content a")
    private WebElement enterTheStoreLink;

    public LandingPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public HomePage enterTheStore(){
        WaitForElement.waitForElementToBeClickable(enterTheStoreLink);
        enterTheStoreLink.click();
        logger.info("Clicked on Enter The Store");
        return new HomePage();
    }
}
