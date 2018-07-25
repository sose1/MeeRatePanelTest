package page.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.PageObject;

public class EventPage extends PageObject {
    public String URL;
    private String eventId;

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
        this.eventId = eventId;
        this.URL = URL_BASE_MAIN + "/" + eventId;
    }

    public WebElement getTalk(int id){
        return talkOrderedList.findElements(By.tagName("li")).get(id);
    }

    public void clickInformationTabButton(){
        informationTabButton.click();
    }

    public WebElement getBackButton() {
        return backButton;
    }

    public void setBackButton(WebElement backButton) {
        this.backButton = backButton;
    }

    public WebElement getSpeakersRateSection() {
        return speakersRateSection;
    }

    public void setSpeakersRateSection(WebElement speakersRateSection) {
        this.speakersRateSection = speakersRateSection;
    }

    public WebElement getInformationTabButton() {
        return informationTabButton;
    }

    public void setInformationTabButton(WebElement informationTabButton) {
        this.informationTabButton = informationTabButton;
    }

    public WebElement getResultsTabButton() {
        return resultsTabButton;
    }

    public void setResultsTabButton(WebElement resultsTabButton) {
        this.resultsTabButton = resultsTabButton;
    }

    public WebElement getAboutSection() {
        return aboutSection;
    }

    public void setAboutSection(WebElement aboutSection) {
        this.aboutSection = aboutSection;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public WebElement getInformationWindow() {
        return informationWindow;
    }

    public void setInformationWindow(WebElement informationWindow) {
        this.informationWindow = informationWindow;
    }

    public void clickEventRate(){
        eventRateButtons.findElements(By.tagName("label")).get(0).click();
    }

    public WebElement getHappyPrompt() {
        return happyPrompt;
    }

    public void setHappyPrompt(WebElement happyPrompt) {
        this.happyPrompt = happyPrompt;
    }

    public WebElement getSadPrompt() {
        return sadPrompt;
    }

    public void setSadPrompt(WebElement sadPrompt) {
        this.sadPrompt = sadPrompt;
    }

    public WebElement getBlasePrompt() {
        return blasePrompt;
    }

    public void setBlasePrompt(WebElement blasePrompt) {
        this.blasePrompt = blasePrompt;
    }

    public WebElement getTalkOrderedList() {
        return talkOrderedList;
    }

    public void setTalkOrderedList(WebElement talkOrderedList) {
        this.talkOrderedList = talkOrderedList;
    }

    public WebElement getFeedBackOpinionSection() {
        return feedBackOpinionSection;
    }

    public void setFeedBackOpinionSection(WebElement feedBackOpinionSection) {
        this.feedBackOpinionSection = feedBackOpinionSection;
    }

    public WebElement getEventRateSection() {
        return eventRateSection;
    }

    public void setEventRateSection(WebElement eventRateSection) {
        this.eventRateSection = eventRateSection;
    }

    public WebElement getAskQuestionSection() {
        return askQuestionSection;
    }

    public void setAskQuestionSection(WebElement askQuestionSection) {
        this.askQuestionSection = askQuestionSection;
    }

    public WebElement getTalkRateSection() {
        return talkRateSection;
    }

    public void setTalkRateSection(WebElement talkRateSection) {
        this.talkRateSection = talkRateSection;
    }

    public WebElement getTalkMoreSection() {
        return talkMoreSection;
    }

    public void setTalkMoreSection(WebElement talkMoreSection) {
        this.talkMoreSection = talkMoreSection;
    }

    public WebElement getPlaceSection() {
        return placeSection;
    }

    public void setPlaceSection(WebElement placeSection) {
        this.placeSection = placeSection;
    }

    public WebElement getDateSection() {
        return dateSection;
    }

    public void setDateSection(WebElement dateSection) {
        this.dateSection = dateSection;
    }

    public WebElement getAgendaSection() {
        return agendaSection;
    }

    public void setAgendaSection(WebElement agendaSection) {
        this.agendaSection = agendaSection;
    }

    public WebElement getRessultsWindow() {
        return resultsWindow;
    }
}
