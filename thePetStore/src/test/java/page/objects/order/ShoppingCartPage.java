package page.objects.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class ShoppingCartPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a.Button[href$='newOrderForm=']")
    private WebElement proceedToCheckoutButton;

    public ShoppingCartPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public FirstPaymentShipmentPage clickOnProceedToCheckout(){
        WaitForElement.waitForElementToBeClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        logger.info("Clicked on Proceed to Checkout button");
        return new FirstPaymentShipmentPage();
    }
}
