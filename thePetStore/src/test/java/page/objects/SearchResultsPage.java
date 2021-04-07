package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "#Content li")
    private WebElement searchMessage;

    @FindBy(css = "#Catalog td > a")
    private List<WebElement> searchResultList;

    public SearchResultsPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public String getSearchMessage(){
        String searchMessageText = searchMessage.getText();
        logger.info("Returned Search Message text: {}", searchMessageText);
        return searchMessageText;
    }

    public int getNumberOfResults(){
        int numberOfResults = searchResultList.size();
        logger.info("Returned number of results: {}", numberOfResults);
        return numberOfResults;
    }

    public void clickOnNthResult(int n){
        searchResultList.get(n).click();
        logger.info("Clicked on Result No.{}", n);
    }
}
