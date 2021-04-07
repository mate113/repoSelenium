package page.objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class LoginPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "signon")
    private WebElement loginButton;

    @FindBy(css = ".messages li")
    private WebElement loginMessage;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void typeIntoUsernameFiled(String username){
        usernameField.clear();
        WaitForElement.waitForElementToBeVisible(usernameField);
        usernameField.sendKeys(username);
        logger.info("Typed into Username field: {}", username);
    }

    public void typeIntoPasswordFiled(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("Typed into Password field: {}", password);
    }

    public void pressLoginButton(){
        loginButton.click();
        logger.info("Clicked on Login button");
    }

    public String getWarningMessage(){
        WaitForElement.waitForElementToBeVisible(loginMessage);
        String warningMessage = loginMessage.getText();
        logger.info("Returned warning text: {}", warningMessage);
        return warningMessage;
    }
}
