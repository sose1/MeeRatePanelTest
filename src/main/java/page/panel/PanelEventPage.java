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

    @FindBy(className = "add-btn")
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
        for (WebElement tableRow : rows) {
            if (row == 0){
                row ++;
                continue;
            }
            row++;
            if (tableRow.findElements(By.tagName("td")).get(0).getText().equalsIgnoreCase(name)){
                done = true;
                break;
            }

        }

        if (!done){
            Assert.fail();
        }

        WebElement thirdCell = driver.findElement(By.xpath("//table/tbody/tr[ " + row + "]/td[8]"));
        thirdCell.findElement(By.className("btn-dark")).click();
        Assert.assertEquals(PanelEventUpdatePage.TITLE_PAGE, driver.getTitle());
    }

    public void clickDeleteButtonForEventName(String name){
        List<WebElement> rows = this.getTableBody().findElements(By.tagName("tr"));
        int row = 0;

        boolean done = false;
        for (WebElement tableRow : rows) {
            if (row == 0){
                row ++;
                continue;
            }

            row++;
            if (tableRow.findElements(By.tagName("td")).get(0).getText().equalsIgnoreCase(name)){
                done = true;
                break;
            }

        }

        if (!done){
            Assert.fail();
        }

        WebElement thirdCell = driver.findElement(By.xpath("//table/tbody/tr[ " + row + "]/td[8]"));
        thirdCell.findElement(By.className("btn-danger")).click();
        Assert.assertTrue(this.getFlashMessage().isDisplayed());
    }
}
