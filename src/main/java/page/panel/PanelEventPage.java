package page.panel;

import org.openqa.selenium.WebDriver;
import page.PageObject;

public class PanelEventPage extends PageObject {

    public static final String URL = "http://127.0.0.1/events/index";

    public PanelEventPage(WebDriver driver) {
        super(driver);
    }

    public void createEvent(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();


    }
}
