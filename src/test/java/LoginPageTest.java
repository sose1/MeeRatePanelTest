import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.LoginPage;
import sun.java2d.pipe.AAShapePipe;

public class LoginPageTest extends FunctionalTest {

    @Test
    public void testCorrectEmail(){
        driver.get(LoginPage.URL);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail(LoginPage.TEST_CORRECT_EMAIL);
        loginPage.clickSignInBuuton();

        wait.until(ExpectedConditions.visibilityOf(loginPage.getPopupMessages().get(1)));

        Assert.assertEquals(LoginPage.EMPTY_PASSWORD_MESSAGE, loginPage.getPopupMessages().get(1).getText());
    }

    @Test
    public void testBadEmail(){
        driver.get(LoginPage.URL);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail(LoginPage.TEST_INCORRECT_EMAIL);
        loginPage.enterPassword(LoginPage.TEST_PASSWORD);
        loginPage.clickSignInBuuton();

        wait.until(ExpectedConditions.visibilityOf(loginPage.getPopupMessages().get(0)));

        Assert.assertEquals(LoginPage.INCORRECT_EMAIL_MESSAGE, loginPage.getPopupMessages().get(0).getText());
    }

    @Test
    public void  testWrongUser(){
        driver.get(LoginPage.URL);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail(LoginPage.TEST_CORRECT_EMAIL);
        loginPage.enterPassword(LoginPage.TEST_PASSWORD);
        loginPage.clickSignInBuuton();

        try {
            wait.until(ExpectedConditions.visibilityOf(loginPage.getPopupMessages().get(1)));
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.visibilityOf(loginPage.getPopupMessages().get(1)));
        }

        Assert.assertEquals(LoginPage.WRONG_USER_MESSAGE, loginPage.getPopupMessages().get(0).getText());
    }
}
