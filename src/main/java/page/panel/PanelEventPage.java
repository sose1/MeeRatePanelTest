package page.panel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.PageObject;
import java.util.List;

public class PanelEventPage extends PageObject {

    public static final String URL = URL_BASE_PANEL + "/events/index";

    @FindBy(className = "add-event-btn")
    private WebElement addEventButton;

    @FindBy(className = "alert-dismissable")
    private WebElement flashMessage;

    @FindBy(tagName = "tbody")
    private WebElement tableBody;

    @FindBy(className = "icon-cancel")
    private WebElement canelButton;

    public void clickAddEventButton(){
        addEventButton.click();
    }

    public void clickCanelButton(){
        canelButton.click();
    }

    public WebElement getAddEventButton() {
        return addEventButton;
    }

    public WebElement getFlashMessage() {
        return flashMessage;
    }

    public WebElement getTableBody() {
        return tableBody;
    }

    public PanelEventPage(WebDriver driver) {
        super(driver);
    }

    public void clickEditButtonForEventName(String name){
        List<WebElement> rows = this.getTableBody().findElements(By.tagName("tr"));
        int row = 0;

        boolean done = false;
        for (int i = rows.size() - 1; i >= 0; i--) {
            if (i == 0){
                break;
            }
            if (rows.get(i).findElements(By.tagName("td")).get(0).getText().equalsIgnoreCase(name)){
                done = true;
                row = i;
                break;
            }
        }

        if (!done){
            Assert.fail();
        }


        WebElement thirdCell = driver.findElement(By.xpath("//table/tbody/tr[ " + row + "]/td[9]"));
        thirdCell.findElement(By.className("blasePrompt")).click();
        Assert.assertEquals(PanelEventUpdatePage.TITLE_PAGE, driver.getTitle());
    }

    public void clickDeleteButtonForEventName(String name){
        List<WebElement> rows = this.getTableBody().findElements(By.tagName("tr"));
        int row = 0;

        boolean done = false;
        for (int i = rows.size() - 1; i >= 0; i--) {
            if (i == 0){
                break;
            }
            if (rows.get(i).findElements(By.tagName("td")).get(0).getText().equalsIgnoreCase(name)){
                done = true;
                row = i;
                break;
            }
        }

        if (!done){
            Assert.fail();
        }
        WebElement thirdCell = driver.findElement(By.xpath("//table/tbody/tr[ " + row + "]/td[9]"));
        thirdCell.findElement(By.className("sadPrompt")).click();
        driver.switchTo().alert().accept();
        Assert.assertTrue(this.getFlashMessage().isDisplayed());
    }
}
