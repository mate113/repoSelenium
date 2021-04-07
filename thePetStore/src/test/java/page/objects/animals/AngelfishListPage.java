package page.objects.animals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import page.objects.order.ShoppingCartPage;
import waits.WaitForElement;

public class AngelfishListPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a[href*='EST-1']")
    private WebElement largeAngelfishLink;

    @FindBy(css = "a.Button[href*='EST-1']")
    private WebElement largeAngelfishAddToCartButton;

    public AngelfishListPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public AnimalDetailsPage clickOnLargeAngelfishId(){
        WaitForElement.waitForElementToBeClickable(largeAngelfishLink);
        largeAngelfishLink.click();
        logger.info("Clicked on Large Angelfish ID");
        return new AnimalDetailsPage();
    }

    public ShoppingCartPage clickOnAddToCartLargeAngelfish(){
        WaitForElement.waitForElementToBeClickable(largeAngelfishAddToCartButton);
        largeAngelfishAddToCartButton.click();
        logger.info("Clicked on Add to Cart - Large Angelfish");
        return new ShoppingCartPage();
    }
}
