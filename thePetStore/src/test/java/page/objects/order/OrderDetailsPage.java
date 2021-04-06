package page.objects.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage {

    private WebDriver driver;

    @FindBy(name = "newOrder")
    private WebElement continueButton;

    public OrderDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }
}
