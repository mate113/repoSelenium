package tests;

import org.testng.annotations.Test;
import page.objects.*;

import static org.testng.Assert.assertTrue;

public class PositiveLoginTests extends TestBase{

    @Test
    public void correctUsernameAndPassword(){
        LandingPage landingPage = new LandingPage();
        landingPage.enterTheStore();

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnSignInLink();

        LoginPage loginPage = new LoginPage();
        loginPage.typeIntoUsernameFiled("j2ee");
        loginPage.typeIntoPasswordFiled("j2ee");
        loginPage.pressLoginButton();

        HomePage homePage = new HomePage();
        assertTrue(homePage.isWelcomeContentVisible());

        FooterPage footerPage = new FooterPage();
        assertTrue(footerPage.isBannerVisible());
    }
}
