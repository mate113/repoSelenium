package page.objects.order;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class OrderSummaryPage {

    @FindBy(className = "messages")
    private WebElement message;

    @FindBy(css = "#BackLink a")
    private WebElement returnToMainMenuLink;

    public OrderSummaryPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public String getMessage(){
        WaitForElement.waitForElementToBeVisible(message);
        String orderInfo = message.getText();
        return orderInfo;
    }
}
