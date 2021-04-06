package page.objects.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {

    private WebDriver driver;

    @FindBy(className = "messages")
    private WebElement message;

    @FindBy(css = "#BackLink a")
    private WebElement returnToMainMenuLink;

    public OrderSummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getMessage(){
        return message.getText();
    }
}
