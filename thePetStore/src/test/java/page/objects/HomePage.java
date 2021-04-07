package page.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import page.objects.animals.FishListPage;
import waits.WaitForElement;

public class HomePage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(id = "Welcome")
    private WebElement welcomeText;

    @FindBy(css = "img[src*='fish_icon']")
    private WebElement fishCategoryText;

    public HomePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public boolean isWelcomeContentVisible(){
        boolean isWelcomeTextDisplayed = welcomeText.isDisplayed();
        logger.info("Returned visibility of Welcome text: {}", isWelcomeTextDisplayed);
        return isWelcomeTextDisplayed;
    }

    public FishListPage clickOnFishText(){
        WaitForElement.waitForElementToBeClickable(fishCategoryText);
        fishCategoryText.click();
        logger.info("Clicked on Fish Text");
        return new FishListPage();
    }
}
