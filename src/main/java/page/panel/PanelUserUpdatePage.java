package page.panel;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.PageObject;

import java.util.List;

public class PanelUserUpdatePage extends PageObject {

    public static final String TITLE_PAGE = "Zaktualizuj informacje o użytkowniku";

    private String newName = RandomStringUtils.randomAlphabetic(10) + " " + RandomStringUtils.randomAlphabetic(8);
    private String newEmail = RandomStringUtils.randomAlphanumeric(15) + "@co.pl";

    @FindBy(className = "alert-dismissable")
    private WebElement flashMessage;

    @FindBy(id = "usersform-username")
    private WebElement nameField;

    @FindBy(id = "usersform-email")
    private WebElement emailField;

    @FindBy(id="select2-usersform-type-container")
    private WebElement userType;

    @FindBy(className="select2-results__option")
    private List<WebElement> selectUserType;

    @FindBy(className = "add-event-btn")
    private WebElement updateButton;



    public void enterNewName(){
        this.nameField.clear();
        this.nameField.sendKeys(newName);
    }

    public void enterNewName(String name){
        this.nameField.clear();
        this.nameField.sendKeys(name);
    }

    public void enterNewEmail(){
        this.emailField.clear();
        this.emailField.sendKeys(newEmail);
    }

    public void enterNewEmail(String email) {
        this.emailField.clear();
        this.emailField.sendKeys(email);
    }

    public void clickUpdateButton(){
        updateButton.click();
    }

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

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getUserType() {
        return userType;
    }

    public List<WebElement> getSelectUserType() {
        return selectUserType;
    }

    public WebElement getUpdateButton() {
        return updateButton;
    }

    public WebElement getFlashMessage() {
        return flashMessage;
    }


    public PanelUserUpdatePage(WebDriver driver) {
        super(driver);
    }


}
