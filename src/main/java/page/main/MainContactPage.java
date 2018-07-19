package page.main;

import org.openqa.selenium.WebDriver;
import page.PageObject;

public class MainContactPage extends PageObject {

    public static final String URL = PageObject.URL_BASE_MAIN + "/contact";

    public MainContactPage(WebDriver driver) {
        super(driver);
    }

}
