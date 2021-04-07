package tests;

import org.testng.annotations.Test;
import page.objects.*;

import static org.testng.Assert.assertTrue;

public class PositiveLoginTests extends TestBase{

    @Test
    public void shouldLoginWhenValidUsernameAndPassword(){
        LandingPage landingPage = new LandingPage();
        landingPage.enterTheStore();

        TopMenuPage topMenuPage = new TopMenuPage();
        boolean welcomeContentVisible = topMenuPage.clickOnSignInLink()
                .typeIntoUsernameFiled("j2ee")
                .typeIntoPasswordFiled("j2ee")
                .pressLoginButton()
                .isWelcomeContentVisible();

        assertTrue(welcomeContentVisible);

        FooterPage footerPage = new FooterPage();
        assertTrue(footerPage.isBannerVisible());
    }
}
