package page.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class FooterPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "img[src*='banner_dogs']")
    private WebElement banner;

    public FooterPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public boolean isBannerVisible(){
        WaitForElement.waitForElementToBeVisible(banner);
        boolean isBannerDisplayed = banner.isDisplayed();
        logger.info("Returned visibility of Footer Banner: {}", isBannerDisplayed);
        return isBannerDisplayed;
    }
}
