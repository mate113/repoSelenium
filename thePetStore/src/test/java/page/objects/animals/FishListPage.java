package page.objects.animals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class FishListPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a[href*='FI-SW-01']")
    private WebElement angelfishLink;

    public FishListPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void clickOnAngelfishId(){
        WaitForElement.waitForElementToBeClickable(angelfishLink);
        angelfishLink.click();
        logger.info("Clicked on Angelfish ID");
    }
}
