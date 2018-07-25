package page.panel;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.PageObject;

import java.util.List;

public class PanelEventUpdatePage extends PageObject {

    public static final String TITLE_PAGE = "Aktualziacja Wydarze";
    public static final String EMPTY_NAME_EVENT = "Nazwa Wydarzenia nie może pozostać bez wartości.";
    public static final String EMPTY_INFO_EVENT = "Opis nie może pozostać bez wartości.";
    public static final String EMPTY_START_DATE_EVENT = "Początek nie może pozostać bez wartości.";
    public static final String EMPTY_END_DATE_EVENT = "Zakończenie nie może pozostać bez wartości.";


    private String location = "RST Software Masters, Racławicka, Wrocław, Polska";
    private String startDate = "2018-12-02 00:00:00";
    private String endDate = "2018-12-02 08:00:00";

    private String nameEvent = RandomStringUtils.randomAlphanumeric(15) + " "
            + RandomStringUtils.randomAlphanumeric(10);
    private String infoEvent = RandomStringUtils.randomAlphanumeric(40) + " "
            + RandomStringUtils.randomAlphanumeric(40);


    @FindBy(id = "eventsform-name")
    private WebElement nameEventField;

    @FindBy(id = "eventsform-info")
    private WebElement infoEventField;

    @FindBy(id = "eventsform-fulllocation")
    private WebElement locationEventField;

    @FindBy(id="eventsform-start")
    private WebElement starDateField;

    @FindBy(id="eventsform-end")
    private WebElement endDateField;

    @FindBy(className = "help-block-error")
    private List<WebElement> popupMessages;

    @FindBy(className = "alert-dismissable")
    private WebElement flashMessage;

    @FindBy(className = "add-event-btn")
    private WebElement addEventButton;


    public void enterNameEvent(){
        this.nameEventField.clear();
        this.nameEventField.sendKeys(nameEvent);
    }

    public void enterNameEvent(String name){
        this.nameEventField.clear();
        this.nameEventField.sendKeys(name);
    }

    public void enterInfoEvent(){
        this.infoEventField.clear();
        this.infoEventField.sendKeys(infoEvent);
    }

    public void enterInfoEvent(String info){
        this.infoEventField.clear();
        this.infoEventField.sendKeys(info);
    }

    public void enterStartDate(){
        this.starDateField.clear();
        this.starDateField.sendKeys(startDate);
    }

    public void enterEndDate(){
        this.endDateField.clear();
        this.endDateField.sendKeys(endDate);
    }

    public void enterLocationEvent(){
        this.locationEventField.clear();
        this.locationEventField.sendKeys(location);
    }

    public void enterLocationEvent(String location){
        this.locationEventField.clear();
        this.locationEventField.sendKeys(location);
    }

    public void enterInvalidDate(String date){
        this.starDateField.clear();
        this.starDateField.sendKeys(date);
        this.endDateField.clear();
        this.endDateField.sendKeys(date);
    }

    public void clickAddEventButton(){
        addEventButton.click();
    }

    public WebElement getNameEventField() {
        return nameEventField;
    }

    public WebElement getInfoEventField() {
        return infoEventField;
    }

    public List<WebElement> getPopupMessages(){
        return popupMessages;
    }

    public WebElement getFlashMessage() {
        return flashMessage;
    }

    public PanelEventUpdatePage(WebDriver driver) {
        super(driver);
    }
}
