package page.panel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.PageObject;

public class PanelMainPage extends PageObject {
    public static final String URL = URL_BASE_PANEL + "/site/index";
    public static final String TITLE = "Strona główna";

    @FindBy(id = "id-for-tester-1")
    private WebElement eventButton;

    @FindBy(id = "id-for-tester-2")
    private WebElement speakerButton;

    @FindBy(id = "id-for-tester-3")
    private WebElement talkButton;

    public PanelMainPage(WebDriver driver) {
        super(driver);
    }

    public void clickEventButton(){
        eventButton.click();
    }

}
