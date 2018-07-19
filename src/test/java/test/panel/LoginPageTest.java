package test.panel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.panel.LoginPage;
import test.FunctionalTest;

public class LoginPageTest extends FunctionalTest {

    @Test
    public void testCorrectEmail(){
        FunctionalTest.driver.get(LoginPage.URL);

        LoginPage loginPage = new LoginPage(FunctionalTest.driver);

        loginPage.enterEmail(LoginPage.TEST_CORRECT_EMAIL);
        loginPage.clickSignInBuuton();

        FunctionalTest.wait.until(ExpectedConditions.visibilityOf(loginPage.getPopupMessages().get(1)));

        Assert.assertEquals(LoginPage.EMPTY_PASSWORD_MESSAGE, loginPage.getPopupMessages().get(1).getText());
    }

    @Test
    public void testBadEmail(){
        FunctionalTest.driver.get(LoginPage.URL);

        LoginPage loginPage = new LoginPage(FunctionalTest.driver);

        loginPage.enterEmail(LoginPage.TEST_INCORRECT_EMAIL);
        loginPage.enterPassword(LoginPage.TEST_PASSWORD);
        loginPage.clickSignInBuuton();

        FunctionalTest.wait.until(ExpectedConditions.visibilityOf(loginPage.getPopupMessages().get(0)));

        Assert.assertEquals(LoginPage.INCORRECT_EMAIL_MESSAGE, loginPage.getPopupMessages().get(0).getText());
    }

    @Test
    public void  testWrongUser(){
        FunctionalTest.driver.get(LoginPage.URL);

        LoginPage loginPage = new LoginPage(FunctionalTest.driver);

        loginPage.enterEmail(LoginPage.TEST_CORRECT_EMAIL);
        loginPage.enterPassword(LoginPage.TEST_PASSWORD);
        loginPage.clickSignInBuuton();

        try {
            FunctionalTest.wait.until(ExpectedConditions.visibilityOf(loginPage.getPopupMessages().get(1)));
        } catch (StaleElementReferenceException e) {
            FunctionalTest.wait.until(ExpectedConditions.visibilityOf(loginPage.getPopupMessages().get(1)));
        }

        Assert.assertEquals(LoginPage.WRONG_USER_MESSAGE, loginPage.getPopupMessages().get(0).getText());
    }

    @Test
    public void testClickCanelButton(){
        driver.get(LoginPage.URL);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickCanelButton();

        wait.until(ExpectedConditions.visibilityOf(loginPage.getMenuButton()));
        Assert.assertTrue(!loginPage.isMenuVisible());
    }

    @Test
    public void testClickMenuButton(){
        driver.get(LoginPage.URL);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickCanelButton();


        wait.until(ExpectedConditions.visibilityOf(loginPage.getMenuButton()));

        loginPage.clickMenuButton();



    }
}
