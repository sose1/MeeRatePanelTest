package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {

    public static final String URL_BASE_MAIN = "http://localhost:3000";
    public static final String URL_BASE_PANEL = "http://127.0.0.1";

    public WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
