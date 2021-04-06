package page.objects.animals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnimalDetailsPage {

    private WebDriver driver;

    @FindBy(css = "a[href*='addItemToCart']")
    private WebElement addItemToCartButton;

    public AnimalDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnAddToCartButton(){
        addItemToCartButton.click();
    }
}
