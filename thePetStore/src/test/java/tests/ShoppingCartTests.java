package tests;

import org.testng.annotations.Test;
import page.objects.LandingPage;
import page.objects.LoginPage;
import page.objects.TopMenuPage;

import static org.testng.Assert.assertEquals;

public class ShoppingCartTests extends TestBase {

    @Test
    public void shouldNotBeAllowedToGoToCheckoutWhenNotLoggedIn(){
        LandingPage landingPage = new LandingPage();
        landingPage.enterTheStore()
                .clickOnFishText()
                .clickOnAngelfishId()
                .clickOnLargeAngelfishId()
                .clickOnAddToCartButton()
                .clickOnProceedToCheckout();

        LoginPage loginPage = new LoginPage();
        String warningMessage = loginPage.getWarningMessage();
        assertEquals(warningMessage,
                "You must sign on before attempting to check out. Please sign on and try checking out again.");
    }

    @Test
    public void shouldBeAllowedToPurchaseWhenLoggedIn(){
        LandingPage landingPage = new LandingPage();
        landingPage.enterTheStore();

        TopMenuPage topMenuPage = new TopMenuPage();
        String orderMessage = topMenuPage.clickOnSignInLink()
                .typeIntoUsernameFiled("j2ee")
                .typeIntoPasswordFiled("j2ee")
                .pressLoginButton()
                .clickOnFishText()
                .clickOnAngelfishId()
                .clickOnAddToCartLargeAngelfish()
                .clickOnProceedToCheckout()
                .clickOnContinueButton()
                .clickOnConfirmButton()
                .getMessage();

        assertEquals(orderMessage, "Thank you, your order has been submitted.");
    }
}
