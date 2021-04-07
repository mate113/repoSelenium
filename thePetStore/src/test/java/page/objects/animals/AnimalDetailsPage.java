package page.objects.animals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import page.objects.order.ShoppingCartPage;
import waits.WaitForElement;

public class AnimalDetailsPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a[href*='addItemToCart']")
    private WebElement addItemToCartButton;

    public AnimalDetailsPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public ShoppingCartPage clickOnAddToCartButton(){
        WaitForElement.waitForElementToBeClickable(addItemToCartButton);
        addItemToCartButton.click();
        logger.info("Clicked on Add to Cart");
        return new ShoppingCartPage();
    }
}
