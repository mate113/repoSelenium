package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    private WebDriver driver;

    @FindBy(css = "#Content a")
    private WebElement enterTheStoreLink;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterTheStore(){
        enterTheStoreLink.click();
    }
}