package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    @FindBy(id = "Welcome")
    private WebElement welcomeText;

    @FindBy(css = "img[src*='fish_icon']")
    private WebElement fishCategoryText;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isWelcomeContentVisible(){
        return welcomeText.isDisplayed();
    }

    public void clickOnFishText(){
        fishCategoryText.click();
    }
}
