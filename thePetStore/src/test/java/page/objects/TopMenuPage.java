package page.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class TopMenuPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a[href*='signonForm']")
    private WebElement signInLink;

    @FindBy(name = "keyword")
    private WebElement searchFiled;

    @FindBy(name = "searchProducts")
    private WebElement searchButton;

    public TopMenuPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public LoginPage clickOnSignInLink(){
        WaitForElement.waitForElementToBeClickable(signInLink);
        signInLink.click();
        logger.info("Clicked on Sign In link");
        return new LoginPage();
    }

    public TopMenuPage typeIntoSearchField(String phrase){
        searchFiled.click();
        searchFiled.sendKeys(phrase);
        logger.info("Typed into Search Field: {}", phrase);
        return this;
    }

    public SearchResultsPage clickOnSearchButton(){
        searchButton.click();
        logger.info("Clicked on Search Button");
        return new SearchResultsPage();
    }
}
