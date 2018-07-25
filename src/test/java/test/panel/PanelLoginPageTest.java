package test.panel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.panel.PanelLoginPage;
import page.panel.PanelMainPage;
import test.FunctionalTest;

public class PanelLoginPageTest extends FunctionalTest {

    @Test
    public void testCorrectUser(){
        driver.get(PanelLoginPage.URL);

        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);

        panelLoginPage.enterEmail(PanelLoginPage.TEST_CORRECT_EMAIL);
        panelLoginPage.enterPassword(panelLoginPage.TEST_PASSWORD);
        panelLoginPage.clickSignInBuuton();

        wait.until(ExpectedConditions.titleIs("main view"));

        Assert.assertEquals(PanelMainPage.URL, driver.getCurrentUrl());
    }

    @Test
    public void testCorrectEmail(){
        driver.get(PanelLoginPage.URL);

        PanelLoginPage panelLoginPage = new PanelLoginPage(FunctionalTest.driver);

        panelLoginPage.enterEmail(PanelLoginPage.TEST_EMAIL);
        panelLoginPage.clickSignInBuuton();

        wait.until(ExpectedConditions.visibilityOf(panelLoginPage.getPopupMessages().get(1)));

        Assert.assertEquals(PanelLoginPage.EMPTY_PASSWORD_MESSAGE, panelLoginPage.getPopupMessages().get(1).getText());
    }

    @Test
    public void testBadEmail(){
        driver.get(PanelLoginPage.URL);

        PanelLoginPage panelLoginPage = new PanelLoginPage(FunctionalTest.driver);

        panelLoginPage.enterEmail(PanelLoginPage.TEST_INCORRECT_EMAIL);
        panelLoginPage.enterPassword(PanelLoginPage.TEST_PASSWORD);
        panelLoginPage.clickSignInBuuton();

        wait.until(ExpectedConditions.visibilityOf(panelLoginPage.getPopupMessages().get(0)));

        Assert.assertEquals(PanelLoginPage.INCORRECT_EMAIL_MESSAGE, panelLoginPage.getPopupMessages().get(0).getText());
    }

    @Test
    public void  testWrongUser(){
        driver.get(PanelLoginPage.URL);

        PanelLoginPage panelLoginPage = new PanelLoginPage(FunctionalTest.driver);

        panelLoginPage.enterEmail(PanelLoginPage.TEST_EMAIL);
        panelLoginPage.enterPassword(PanelLoginPage.TEST_PASSWORD);
        panelLoginPage.clickSignInBuuton();

        try {
            wait.until(ExpectedConditions.visibilityOf(panelLoginPage.getPopupMessages().get(1)));
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.visibilityOf(panelLoginPage.getPopupMessages().get(1)));
        }

        Assert.assertEquals(PanelLoginPage.WRONG_USER_MESSAGE, panelLoginPage.getPopupMessages().get(0).getText());
    }

    @Test
    public void testClickCanelButton(){
        driver.get(PanelLoginPage.URL);

        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);

        panelLoginPage.clickCanelButton();

        wait.until(ExpectedConditions.visibilityOf(panelLoginPage.getMenuButton()));
        Assert.assertTrue(!panelLoginPage.isMenuVisible());
    }

    @Test
    public void testClickMenuButton(){
        driver.get(PanelLoginPage.URL);

        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);

        panelLoginPage.clickCanelButton();


        wait.until(ExpectedConditions.visibilityOf(panelLoginPage.getMenuButton()));

        panelLoginPage.clickMenuButton();

    }
}
