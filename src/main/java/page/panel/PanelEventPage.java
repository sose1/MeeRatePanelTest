package page.panel;

import org.openqa.selenium.WebDriver;
import page.PageObject;

public class PanelEventPage extends PageObject {

    public static final String URL = PageObject.URL_BASE_PANEL + "/events/index";

    public PanelEventPage(WebDriver driver) {
        super(driver);
    }

    public void createEvent(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();


    }
}
