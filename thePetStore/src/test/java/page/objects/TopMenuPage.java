package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class TopMenuPage {

    @FindBy(css = "a[href*='signonForm']")
    private WebElement signInLink;

    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void clickOnSignInLink(){
        WaitForElement.waitForElementToBeClickable(signInLink);
        signInLink.click();
    }
}
