package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.SearchResultsPage;
import page.objects.TopMenuPage;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class SearchTests extends TestBase{

    @Test
    public void shouldShowResultsWhenEnteredKeyword(){
        LandingPage landingPage = new LandingPage();
        landingPage.enterTheStore();

        TopMenuPage topMenuPage = new TopMenuPage();
        int numberOfResults = topMenuPage.typeIntoSearchField("Retriever")
                .clickOnSearchButton()
                .getNumberOfResults();

        assertEquals(numberOfResults, 2);
    }

    @Test
    public void shouldShowErrorWhenNoKeyword(){
        LandingPage landingPage = new LandingPage();
        landingPage.enterTheStore();

        TopMenuPage topMenuPage = new TopMenuPage();
        String searchMessage = topMenuPage.typeIntoSearchField("")
                .clickOnSearchButton()
                .getSearchMessage();
        assertEquals(searchMessage, "Please enter a keyword to search for, then press the search button.");
    }
}
