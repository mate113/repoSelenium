package tests;

import org.testng.annotations.Test;
import page.objects.*;
import page.objects.animals.AngelfishListPage;
import page.objects.animals.AnimalDetailsPage;
import page.objects.animals.FishListPage;
import page.objects.order.CheckoutPage;
import page.objects.order.OrderSummaryPage;
import page.objects.order.PaymentShipmentPage;
import page.objects.order.ShoppingCartPage;

import static org.testng.Assert.assertEquals;

public class ShoppingCartTests extends TestBase {

    @Test
    public void purchaseWhileNotLoggedIn(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.enterTheStore();

        HomePage homePage = new HomePage(driver);
        homePage.clickOnFishText();

        FishListPage fishListPage = new FishListPage(driver);
        fishListPage.clickOnAngelfishId();

        AngelfishListPage angelfishListPage = new AngelfishListPage(driver);
        angelfishListPage.clickOnLargeAngelfishId();

        AnimalDetailsPage animalDetailsPage = new AnimalDetailsPage(driver);
        animalDetailsPage.clickOnAddToCartButton();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickOnProceedToCheckout();

        LoginPage loginPage = new LoginPage(driver);
        String warningMessage = loginPage.getWarningMessage();
        assertEquals(warningMessage,
                "You must sign on before attempting to check out. Please sign on and try checking out again.");
    }

    @Test
    public void purchaseWhileLoggedIn(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.enterTheStore();

        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnSignInLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUsernameFiled("j2ee");
        loginPage.typeIntoPasswordFiled("j2ee");
        loginPage.pressLoginButton();

        HomePage homePage = new HomePage(driver);
        homePage.clickOnFishText();

        FishListPage fishListPage = new FishListPage(driver);
        fishListPage.clickOnAngelfishId();

        AngelfishListPage angelfishListPage = new AngelfishListPage(driver);
        angelfishListPage.clickOnAddToCartLargeAngelfish();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickOnProceedToCheckout();

        PaymentShipmentPage paymentShipmentPage = new PaymentShipmentPage(driver);
        paymentShipmentPage.clickOnContinueButton();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickOnConfirmButton();

        OrderSummaryPage orderSummaryPage = new OrderSummaryPage(driver);
        String orderMessage = orderSummaryPage.getMessage();
        assertEquals(orderMessage, "Thank you, your order has been submitted.");
    }
}
