package page.objects.order;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class CheckoutPage {

    @FindBy(css = "a.Button[href*='newOrder']")
    private WebElement confirmButton;

    public CheckoutPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void clickOnConfirmButton(){
        WaitForElement.waitForElementToBeClickable(confirmButton);
        confirmButton.click();
    }
}
