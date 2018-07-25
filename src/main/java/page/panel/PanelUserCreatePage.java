package page.panel;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.PageObject;

import java.util.List;


public class PanelUserCreatePage extends PageObject {

    public static final String URL = "http://127.0.0.1/users/create";
    public static final String INVALID_EMAIL = "Email nie zawiera prawidłowego adresu email.";
    public static final String EMPTY_EMAIL = "Email nie może pozostać bez wartości.";
    public static final String EMPTY_USER_TYPE = "Typ konta nie może pozostać bez wartości.";
    public static final String EMPTY_USER_NAME = "Nazwa użytkownika nie może pozostać bez wartości.";
    public static final String INVALID_NAME = "Nazwa użytkownika musi zawierać imię i nazwisko!";


    private String name = RandomStringUtils.randomAlphabetic(10) + " " + RandomStringUtils.randomAlphabetic(8);
    private String email = RandomStringUtils.randomAlphanumeric(15) + "@co.pl";



    @FindBy(className = "icon-menu")
    private WebElement menuButton;

    @FindBy(className = "icon-plus")
    private List<WebElement> leftNavigationAddButton;

    @FindBy(id = "usersform-username")
    private WebElement nameField;

    @FindBy(id = "usersform-email")
    private WebElement emailField;

    @FindBy(id="select2-usersform-type-container")
    private WebElement userType;

    @FindBy(className="select2-results__option")
    private List<WebElement>  selectUserType;

    @FindBy(className = "add-event-btn")
    private WebElement registerButton;

    @FindBy(className = "help-block-error")
    private List<WebElement> popupMessages;


    public void enterName(){
        this.nameField.clear();
        this.nameField.sendKeys(name);
    }

    public void enterNummName(){
        this.nameField.clear();
    }

    public void enterNullEmail(){
       this.emailField.clear();
    }

    public void enterEmail(){
        this.emailField.clear();
        this.emailField.sendKeys(email);
    }

/**/

    public void enterName(String name){
        this.nameField.clear();
        this.nameField.sendKeys(name);
    }

    public void enterEmail(String email){
        this.emailField.clear();
        this.emailField.sendKeys(email);
    }

/**/

    public void clickUserType(){
        userType.click();
    }

    public void clickSpeaker(){
        selectUserType.get(2).click();
    }

    public void clickAdmin(){
        selectUserType.get(1).click();
    }

    public void clickSuperAdmin(){
        selectUserType.get(0).click();
    }

    public void clickRegisterButton(){
        registerButton.click();
    }

/**/

    public WebElement getEmail() {
        return emailField;
    }

    public List<WebElement> getPopupMessages(){
        return popupMessages;
    }

/**/

    public PanelUserCreatePage(WebDriver driver) {
        super(driver);
    }
}
