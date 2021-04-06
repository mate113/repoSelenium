package tests;

import org.testng.annotations.Test;
import page.objects.*;

import static org.testng.Assert.assertTrue;

public class PositiveLoginTests extends TestBase{

    @Test
    public void correctUsernameAndPassword(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.enterTheStore();

        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnSignInLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUsernameFiled("j2ee");
        loginPage.typeIntoPasswordFiled("j2ee");
        loginPage.pressLoginButton();

        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isWelcomeContentVisible());

        FooterPage footerPage = new FooterPage(driver);
        assertTrue(footerPage.isBannerVisible());
    }
}
