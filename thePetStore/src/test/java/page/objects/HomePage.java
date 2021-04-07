package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class HomePage {

    @FindBy(id = "Welcome")
    private WebElement welcomeText;

    @FindBy(css = "img[src*='fish_icon']")
    private WebElement fishCategoryText;

    public HomePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public boolean isWelcomeContentVisible(){
        return welcomeText.isDisplayed();
    }

    public void clickOnFishText(){
        WaitForElement.waitForElementToBeClickable(fishCategoryText);
        fishCategoryText.click();
    }
}
