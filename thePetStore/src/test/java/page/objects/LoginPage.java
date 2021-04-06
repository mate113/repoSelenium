package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "signon")
    private WebElement loginButton;

    @FindBy(css = ".messages li")
    private WebElement loginMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeIntoUsernameFiled(String username){
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void typeIntoPasswordFiled(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void pressLoginButton(){
        loginButton.click();
    }

    public String getWarningMessage(){
        return loginMessage.getText();
    }
}
