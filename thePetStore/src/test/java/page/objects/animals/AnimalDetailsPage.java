package page.objects.animals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class AnimalDetailsPage {

    @FindBy(css = "a[href*='addItemToCart']")
    private WebElement addItemToCartButton;

    public AnimalDetailsPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void clickOnAddToCartButton(){
        WaitForElement.waitForElementToBeClickable(addItemToCartButton);
        addItemToCartButton.click();
    }
}
