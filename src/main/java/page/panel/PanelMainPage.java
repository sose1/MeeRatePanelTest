package page.panel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.PageObject;

import java.util.List;

public class PanelMainPage extends PageObject {

    public static final String URL = PageObject.URL_BASE_PANEL + "/site/index";

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
