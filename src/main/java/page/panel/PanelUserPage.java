package page.panel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.PageObject;

import java.util.List;

public class PanelUserPage extends PageObject {
    public static final String URL = URL_BASE_PANEL + "/users/index";

    @FindBy(className = "add-event-btn")
    private WebElement createUserButton;

    @FindBy(className = "icon-cancel")
    private WebElement canelButton;

    @FindBy(className = "alert-dismissable")
    private WebElement flashMessage;

    @FindBy(tagName = "tbody")
    private WebElement tableBody;

    public void clickCreateUserButton(){
        createUserButton.click();
    }

    public void clickCanelButton(){
        canelButton.click();
    }

    public WebElement getFlashMessage() {
        return flashMessage;
    }

    public WebElement getCreateUserButton(){
        return createUserButton;
    }

    public PanelUserPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTableBody() {
        return tableBody;
    }

    public void setTableBody(WebElement tableBody) {
        this.tableBody = tableBody;
    }


    public void clickEditButtonForEmail(String email){
        List<WebElement> rows = this.getTableBody().findElements(By.tagName("tr"));
        int row = 0;

        boolean done = false;
        for (int i = rows.size() - 1; i >= 0; i--) {
            if (i == 0){
                break;
            }
            if (rows.get(i).findElements(By.tagName("td")).get(1).getText().equalsIgnoreCase(email)){
                done = true;
                row = i;
                break;
            }
        }

        if (!done){
            Assert.fail();
        }


        WebElement thirdCell = driver.findElement(By.xpath("//table/tbody/tr[ " + row + "]/td[4]"));
        thirdCell.findElement(By.className("blasePrompt")).click();
        Assert.assertEquals(PanelUserUpdatePage.TITLE_PAGE, driver.getTitle());
    }

    public void clickDeleteButtonForEmail(String email){
        List<WebElement> rows = this.getTableBody().findElements(By.tagName("tr"));
        int row = 0;

        boolean done = false;
        for (int i = rows.size() - 1; i >= 0; i--) {
            if (i == 0){
                break;
            }
            if (rows.get(i).findElements(By.tagName("td")).get(1).getText().equalsIgnoreCase(email)){
                done = true;
                row = i;
                break;
            }
        }

        if (!done){
            Assert.fail();
        }

        WebElement thirdCell = driver.findElement(By.xpath("//table/tbody/tr[ " + row + "]/td[4]"));
        thirdCell.findElement(By.className("sadPrompt")).click();
        driver.switchTo().alert().accept();
        Assert.assertTrue(this.getFlashMessage().isDisplayed());
    }
}
