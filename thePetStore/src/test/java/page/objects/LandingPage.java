package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class LandingPage {

    @FindBy(css = "#Content a")
    private WebElement enterTheStoreLink;

    public LandingPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void enterTheStore(){
        WaitForElement.waitForElementToBeClickable(enterTheStoreLink);
        enterTheStoreLink.click();
    }
}
