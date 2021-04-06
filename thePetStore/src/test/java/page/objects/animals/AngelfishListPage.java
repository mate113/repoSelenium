package page.objects.animals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AngelfishListPage {

    private WebDriver driver;

    @FindBy(css = "a[href*='EST-1']")
    private WebElement largeAngelfishLink;

    @FindBy(css = "a.Button[href*='EST-1']")
    private WebElement largeAngelfishAddToCartButton;

    public AngelfishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnLargeAngelfishId(){
        largeAngelfishLink.click();
    }

    public void clickOnAddToCartLargeAngelfish(){
        largeAngelfishAddToCartButton.click();
    }
}
