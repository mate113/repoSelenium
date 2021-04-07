package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.LoginPage;
import page.objects.TopMenuPage;

import static org.testng.Assert.assertEquals;

public class FailedLoginTests extends TestBase {

    @DataProvider(name = "incorrectLoginData")
    private Object[][] getLoginData(){
        return new Object[][]{
                {"badUsername", "badPassword"},
                {"badUsername", "j2ee"},
                {"j2ee", "badPassword"}
        };
    };

    @Test(dataProvider = "incorrectLoginData")
    public void shouldNotLoginWithInvalidUsernameOrPassword(String username, String password){
        LandingPage landingPage = new LandingPage();
        landingPage.enterTheStore();

        TopMenuPage topMenuPage = new TopMenuPage();
        topMenuPage.clickOnSignInLink()
                .typeIntoUsernameFiled(username)
                .typeIntoPasswordFiled(password)
                .pressLoginButton();

        LoginPage loginPage = new LoginPage();
        String failedLoginText = loginPage.getWarningMessage();
        assertEquals(failedLoginText, "Invalid username or password. Signon failed.");
    }
}
