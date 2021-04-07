package page.objects.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class FirstPaymentShipmentPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(name = "newOrder")
    private WebElement continueButton;

    public FirstPaymentShipmentPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public SecondConfirmTheInformationPage clickOnContinueButton(){
        WaitForElement.waitForElementToBeClickable(continueButton);
        continueButton.click();
        logger.info("Clicked on Continue button");
        return new SecondConfirmTheInformationPage();
    }
}
