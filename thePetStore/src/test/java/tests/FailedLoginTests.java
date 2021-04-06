package tests;

import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.LoginPage;
import page.objects.TopMenuPage;

import static org.testng.Assert.assertEquals;

public class FailedLoginTests extends TestBase {

    @Test
    public void incorrectLoginAndPassword(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.enterTheStore();

        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnSignInLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUsernameFiled("badUsername");
        loginPage.typeIntoPasswordFiled("badPassword");
        loginPage.pressLoginButton();

        String failedLoginText = loginPage.getWarningMessage();
        assertEquals(failedLoginText, "Invalid username or password. Signon failed.");
    }

    @Test
    public void incorrectLoginAndCorrectPassword(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.enterTheStore();

        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnSignInLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUsernameFiled("badUsername");
        loginPage.typeIntoPasswordFiled("j2ee");
        loginPage.pressLoginButton();

        String failedLoginText = loginPage.getWarningMessage();
        assertEquals(failedLoginText, "Invalid username or password. Signon failed.");
    }

    @Test
    public void correctLoginAndIncorrectPassword(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.enterTheStore();

        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnSignInLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUsernameFiled("j2ee");
        loginPage.typeIntoPasswordFiled("badPassword");
        loginPage.pressLoginButton();

        String failedLoginText = loginPage.getWarningMessage();
        assertEquals(failedLoginText, "Invalid username or password. Signon failed.");
    }
}
