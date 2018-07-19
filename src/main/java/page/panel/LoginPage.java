package page.panel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.PageObject;

import java.util.List;

public class LoginPage extends PageObject {

    //todo testowe zmienne

    public static final String URL = "http://127.0.0.1/site/login";
    public static final String TEST_INCORRECT_EMAIL = "zlyemail";
    public static final String TEST_CORRECT_EMAIL = "cfsdfo@co.pl";
    public static final String TEST_PASSWORD = "start123";
    public static final String EMPTY_EMAIL_MESSAGE = "Email nie może pozostać bez wartości.";
    public static final String EMPTY_PASSWORD_MESSAGE = "Hasło nie może pozostać bez wartości.";
    public static final String INCORRECT_EMAIL_MESSAGE = "Email nie zawiera prawidłowego adresu email.";
    public static final String WRONG_USER_MESSAGE = "Niepoprawny email lub hasło";

    //todo pola tekstowe

    @FindBy(id = "loginform-username")
    private WebElement emailField;

    @FindBy(id = "loginform-password")
    private WebElement passwordField;

    @FindBy(name = "login-button")
    private WebElement loginButton;

    @FindBy(className = "help-block-error")
    private List<WebElement> popupMessages;

    @FindBy(className = "icon-menu")
    private WebElement menuButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email){
        this.emailField.clear();
        this.emailField.sendKeys(email);
    }

    public void enterPassword(String password){
        this.passwordField.clear();
        this.passwordField.sendKeys(password);
    }


    public void clickSignInBuuton(){
        loginButton.click();
    }

    public void  clickMenuButton(){
        menuButton.click();
    }

    public List<WebElement> getPopupMessages() {
        return popupMessages;
    }

    public void setPopupMessages(List<WebElement> popupMessages) {
        this.popupMessages = popupMessages;
    }
}