package page.objects.order;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class ShoppingCartPage {

    @FindBy(css = "a.Button[href$='newOrderForm=']")
    private WebElement proceedToCheckoutButton;

    public ShoppingCartPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void clickOnProceedToCheckout(){
        WaitForElement.waitForElementToBeClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
    }
}
