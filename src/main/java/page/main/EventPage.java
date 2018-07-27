package page.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.PageObject;

public class EventPage extends PageObject {
    public String URL;

    public static final String FILL_RATE_PROMPT_MESSAGE = "Proszę wystawić ocenę.";
    public static final String SERVER_ERROR_MESSAGE = "Błąd serwera!";
    public static final String SUCCESSFUL_RATE_MESSAGE = "Dziękujemy!";

    //przyciski

    @FindBy(className = "icon-icon-back-arrow")
    private WebElement backButton;

    @FindBy(id = "resultsTab")
    private WebElement resultsTabButton;

    @FindBy(id = "informationTab")
    private WebElement informationTabButton;

    @FindBy(className = "eventRadio")
    private WebElement eventRateButtons;

    //sekcje itp

    @FindBy(id = "speakersRate")
    private WebElement speakersRateSection;

    @FindBy(id = "about")
    private WebElement aboutSection;

    @FindBy(id = "informationWindow")
    private WebElement informationWindow;

    @FindBy(tagName = "ol")
    private WebElement talkOrderedList;

    @FindBy(className = "feedbackOption")
    private WebElement feedBackOpinionSection;

    @FindBy(className = "askQuestion")
    private WebElement askQuestionSection;

    @FindBy(id = "eventRate")
    private WebElement eventRateSection;

    @FindBy(className = "giveRate")
    private WebElement talkRateSection;

    @FindBy(className = "more")
    private WebElement talkMoreSection;

    @FindBy(id = "place")
    private WebElement placeSection;

    @FindBy(id = "date")
    private WebElement dateSection;

    @FindBy(id = "agenda")
    private WebElement agendaSection;

    //flash

    @FindBy(className = "happyPrompt")
    private WebElement happyPrompt;

    @FindBy(className = "sadPrompt")
    private WebElement sadPrompt;

    @FindBy(className = "blasePrompt")
    private WebElement blasePrompt;

    @FindBy(id = "resultsWindow")
    private WebElement resultsWindow;

    public EventPage(WebDriver driver, String eventId) {
        super(driver);
        this.URL = URL_BASE_MAIN + "/" + eventId;
    }

    public void clickInformationTabButton(){
        informationTabButton.click();
    }

    public void clickEventRate(){
        eventRateButtons.findElements(By.tagName("label")).get(0).click();
    }

    public void clickMapButton(){
        this.getPlaceSection()
                .findElement(By.className("row"))
                .findElement(By.tagName("p"))
                .findElement(By.tagName("a")).click();
    }

    public WebElement getBackButton() {
        return backButton;
    }

    public WebElement getTalk(int id){
        return talkOrderedList.findElements(By.tagName("li")).get(id);
    }

    public WebElement getSpeakersRateSection() {
        return speakersRateSection;
    }

    public WebElement getInformationTabButton() {
        return informationTabButton;
    }

    public WebElement getAboutSection() {
        return aboutSection;
    }

    public WebElement getInformationWindow() {
        return informationWindow;
    }

    public WebElement getHappyPrompt() {
        return happyPrompt;
    }

    public WebElement getSadPrompt() {
        return sadPrompt;
    }

    public WebElement getBlasePrompt() {
        return blasePrompt;
    }

    public WebElement getFeedBackOpinionSection() {
        return feedBackOpinionSection;
    }

    public WebElement getEventRateSection() {
        return eventRateSection;
    }

    public WebElement getAskQuestionSection() {
        return askQuestionSection;
    }

    public WebElement getTalkRateSection() {
        return talkRateSection;
    }

    public WebElement getTalkMoreSection() {
        return talkMoreSection;
    }

    public WebElement getPlaceSection() {
        return placeSection;
    }

    public WebElement getDateSection() {
        return dateSection;
    }

    public WebElement getAgendaSection() {
        return agendaSection;
    }

    public WebElement getRessultsWindow() {
        return resultsWindow;
    }
}
