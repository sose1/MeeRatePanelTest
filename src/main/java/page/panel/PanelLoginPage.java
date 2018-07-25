package page.panel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.PageObject;
import java.util.List;

public class PanelLoginPage extends PageObject {

    //todo testowe zmienne

    public static final String URL = URL_BASE_PANEL + "/site/login";
    public static final String TEST_INCORRECT_EMAIL = "zlyemail";
    public static final String TEST_EMAIL = "cfsdfo@co.pl";
    public static final String TEST_PASSWORD = "16k7C9r4";
    public static final String TEST_CORRECT_EMAIL = "zz75sbu8nvnh@10minut.xyz";
    public static final String EMPTY_EMAIL_MESSAGE = "Email nie może pozostać bez wartości.";
    public static final String EMPTY_PASSWORD_MESSAGE = "Hasło nie może pozostać bez wartości.";
    public static final String INCORRECT_EMAIL_MESSAGE = "Email nie zawiera prawidłowego adresu email.";
    public static final String WRONG_USER_MESSAGE = "Niepoprawny email lub hasło";


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

    @FindBy(className = "icon-cancel")
    private WebElement canelButton;

    @FindBy(className = "show")
    private List<WebElement> leftNavigationMenu;


    public PanelLoginPage(WebDriver driver) {
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

    public void clickCanelButton(){
        canelButton.click();
    }

    public void clickMenuButton(){
        menuButton.click();
    }

    public List<WebElement> getPopupMessages() {
        return popupMessages;
    }

    public void setPopupMessages(List<WebElement> popupMessages) {
        this.popupMessages = popupMessages;
    }

    public List<WebElement> getLeftNavigationMenu(){
        return leftNavigationMenu;
    }

    public void clickMainPageButton(){
        leftNavigationMenu.get(0).click();
    }

    public WebElement getMenuButton() {
        return menuButton;
    }

    public WebElement getCanelButton() {
        return canelButton;
    }

    public boolean isMenuVisible() {
        return leftNavigationMenu.get(0).isDisplayed();
    }

    public void loginAsSuperAdmin(){
        driver.get(PanelLoginPage.URL);
        enterEmail(PanelLoginPage.TEST_CORRECT_EMAIL);
        enterPassword(PanelLoginPage.TEST_PASSWORD);
        clickSignInBuuton();
    }
}
