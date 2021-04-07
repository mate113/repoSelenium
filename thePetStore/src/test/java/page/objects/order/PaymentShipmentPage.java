package page.objects.order;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class PaymentShipmentPage {

    @FindBy(name = "newOrder")
    private WebElement continueButton;

    public PaymentShipmentPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void clickOnContinueButton(){
        WaitForElement.waitForElementToBeClickable(continueButton);
        continueButton.click();
    }
}
