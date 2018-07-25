package page.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.PageObject;

import java.util.List;

public class MainPage extends PageObject {

    public static final String URL = PageObject.URL_BASE_MAIN;

    //główne przyciski

    @FindBy(id = "menuButton")
    private WebElement menuButtonOpen;

    @FindBy(id = "contactButton")
    private WebElement mainContactButton;

    //menu

    @FindBy(className = "icon-icon-close")
    private WebElement menuButtonClose;

    //listy eventów

    @FindBy(className = "eventbox-actual")
    private List<WebElement> actualEvents;

    @FindBy(className = "eventbox-future")
    private List<WebElement> futureEvents;

    @FindBy(className = "eventbox-archive")
    private List<WebElement> archiveEvents;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickMenuButtonOpen(){
        menuButtonOpen.click();
    }

    public void clickMenuButtonClose(){
        menuButtonClose.click();
    }

    public void clickMainContactButton(){
        mainContactButton.click();
    }

    public String clickFirstActualEvent(){
        String eventId = actualEvents.get(0).getAttribute("id");
        actualEvents.get(0).click();
        return eventId;
    }

    public String clickFirstFutureEvent() {
        String eventId = futureEvents.get(0).getAttribute("id");
        futureEvents.get(0).click();
        return eventId;
    }

    public String clickFirstArchiveEvent() {
        String eventId = archiveEvents.get(0).getAttribute("id");
        archiveEvents.get(0).click();
        return eventId;
    }

    public WebElement getMenuButtonOpen() {
        return menuButtonOpen;
    }

    public void setMenuButtonOpen(WebElement menuButtonOpen) {
        this.menuButtonOpen = menuButtonOpen;
    }

    public WebElement getMenuButtonClose() {
        return menuButtonClose;
    }

    public void setMenuButtonClose(WebElement menuButtonClose) {
        this.menuButtonClose = menuButtonClose;
    }

    public List<WebElement> getActualEvents() {
        return actualEvents;
    }

    public void setActualEvents(List<WebElement> actualEvents) {
        this.actualEvents = actualEvents;
    }

    public List<WebElement> getFutureEvents() {
        return futureEvents;
    }

    public void setFutureEvents(List<WebElement> futureEvents) {
        this.futureEvents = futureEvents;
    }

    public List<WebElement> getArchiveEvents() {
        return archiveEvents;
    }

    public void setArchiveEvents(List<WebElement> archiveEvents) {
        this.archiveEvents = archiveEvents;
    }

    public WebElement getMainContactButton() {
        return mainContactButton;
    }

    public void setMainContactButton(WebElement mainContactButton) {
        this.mainContactButton = mainContactButton;
    }
}
