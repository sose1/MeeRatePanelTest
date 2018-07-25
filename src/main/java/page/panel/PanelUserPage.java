package page.panel;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.PageObject;

import java.util.List;


public class PanelUserPage extends PageObject {


    public static final String URL = "http://127.0.0.1/users/index";

    @FindBy(className = "add-btn")
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
        for (WebElement tableRow : rows) {
            if (row == 0){
                row ++;
                continue;
            }
            row++;
            if (tableRow.findElements(By.tagName("td")).get(1).getText().equalsIgnoreCase(email)){
                done = true;
                break;
            }

        }

        if (!done){
            Assert.fail();
        }

        WebElement thirdCell = driver.findElement(By.xpath("//table/tbody/tr[ " + row + "]/td[4]"));
        thirdCell.findElement(By.className("btn-dark")).click();
        Assert.assertEquals(PanelUserUpdatePage.TITLE_PAGE, driver.getTitle());
    }

    public void clickDeleteButtonForEmail(String email){
        List<WebElement> rows = this.getTableBody().findElements(By.tagName("tr"));
        int row = 0;

        boolean done = false;
        for (WebElement tableRow : rows) {
            if (row == 0){
                row ++;
                continue;
            }

            row++;
            if (tableRow.findElements(By.tagName("td")).get(1).getText().equalsIgnoreCase(email)){
                done = true;
                break;
            }

        }

        if (!done){
            Assert.fail();
        }

        WebElement thirdCell = driver.findElement(By.xpath("//table/tbody/tr[ " + row + "]/td[4]"));
        thirdCell.findElement(By.className("btn-danger")).click();
        Assert.assertTrue(this.getFlashMessage().isDisplayed());
    }
}
