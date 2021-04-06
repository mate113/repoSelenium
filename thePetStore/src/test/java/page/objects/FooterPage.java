package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {

    private WebDriver driver;

    @FindBy(css = "img[src*='banner_dogs']")
    private WebElement banner;

    public FooterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isBannerVisible(){
        return banner.isDisplayed();
    }
}
