package page.objects.animals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishListPage {

    private WebDriver driver;

    @FindBy(css = "a[href*='FI-SW-01']")
    private WebElement angelfishLink;

    public FishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnAngelfishId(){
        angelfishLink.click();
    }
}
