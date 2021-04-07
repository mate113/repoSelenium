package page.objects.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import page.objects.HomePage;
import waits.WaitForElement;

public class ThirdOrderSummaryPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(className = "messages")
    private WebElement message;

    @FindBy(css = "#BackLink a")
    private WebElement returnToMainMenuLink;

    public ThirdOrderSummaryPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public String getMessage(){
        WaitForElement.waitForElementToBeVisible(message);
        String orderInfo = message.getText();
        logger.info("Returned Order Info: {}", orderInfo);
        return orderInfo;
    }

    public HomePage clickOnReturnToMainMenuLink(){
        WaitForElement.waitForElementToBeClickable(returnToMainMenuLink);
        returnToMainMenuLink.click();
        logger.info("Clicked on Return to Main Menu link");
        return new HomePage();
    }
}
