package page.objects.animals;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class AngelfishListPage {

    @FindBy(css = "a[href*='EST-1']")
    private WebElement largeAngelfishLink;

    @FindBy(css = "a.Button[href*='EST-1']")
    private WebElement largeAngelfishAddToCartButton;

    public AngelfishListPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void clickOnLargeAngelfishId(){
        WaitForElement.waitForElementToBeClickable(largeAngelfishLink);
        largeAngelfishLink.click();
    }

    public void clickOnAddToCartLargeAngelfish(){
        WaitForElement.waitForElementToBeClickable(largeAngelfishAddToCartButton);
        largeAngelfishAddToCartButton.click();
    }
}
