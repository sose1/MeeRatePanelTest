package test.panel;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.panel.PanelLoginPage;
import page.panel.PanelMainPage;
import page.panel.PanelUserCreatePage;
import page.panel.PanelUserPage;
import test.FunctionalTest;


public class PanelUserCreatePageTest extends FunctionalTest {

    @Test
    public void testAddCorrectSpeaker(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs(PanelMainPage.TITLE));


        driver.get(PanelUserCreatePage.URL);
        PanelUserCreatePage panelCreateUserPage = new PanelUserCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelCreateUserPage.getEmail()));
        panelCreateUserPage.enterName();
        panelCreateUserPage.enterEmail();
        panelCreateUserPage.clickUserType();
        panelCreateUserPage.clickSpeaker();
        panelCreateUserPage.clickRegisterButton();

        wait.until(ExpectedConditions.titleIs("Użytkownicy"));
        Assert.assertEquals(PanelUserPage.URL, driver.getCurrentUrl());
    }

    @Test
    public void testAddCorrectAdmin(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs(PanelMainPage.TITLE));


        driver.get(PanelUserCreatePage.URL);
        PanelUserCreatePage panelCreateUserPage = new PanelUserCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelCreateUserPage.getEmail()));
        panelCreateUserPage.enterName();
        panelCreateUserPage.enterEmail();
        panelCreateUserPage.clickUserType();
        panelCreateUserPage.clickAdmin();
        panelCreateUserPage.clickRegisterButton();

        wait.until(ExpectedConditions.titleIs("Użytkownicy"));
        Assert.assertEquals(PanelUserPage.URL, driver.getCurrentUrl());
    }

    @Test
    public void testAddCorrectSuperAdmin(){

        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs(PanelMainPage.TITLE));


        driver.get(PanelUserCreatePage.URL);
        PanelUserCreatePage panelCreateUserPage = new PanelUserCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelCreateUserPage.getEmail()));
        panelCreateUserPage.enterName();
        panelCreateUserPage.enterEmail();
        panelCreateUserPage.clickUserType();
        panelCreateUserPage.clickSuperAdmin();
        panelCreateUserPage.clickRegisterButton();

        wait.until(ExpectedConditions.titleIs("Użytkownicy"));
        Assert.assertEquals(PanelUserPage.URL, driver.getCurrentUrl());
    }

    @Test
    public void testAddUserWhenNotSelectUserType(){

        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs(PanelMainPage.TITLE));


        driver.get(PanelUserCreatePage.URL);
        PanelUserCreatePage panelCreateUserPage = new PanelUserCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelCreateUserPage.getEmail()));
        panelCreateUserPage.enterName();
        panelCreateUserPage.enterEmail();
        panelCreateUserPage.clickRegisterButton();

        wait.until(ExpectedConditions.visibilityOf(panelCreateUserPage.getPopupMessages().get(2)));
        Assert.assertEquals(PanelUserCreatePage.EMPTY_USER_TYPE, panelCreateUserPage.getPopupMessages().get(2).getText());
    }

    @Test
    public void testAddUserWhenEmailIsInvalid(){
        String email = RandomStringUtils.randomAlphabetic(10);

        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs(PanelMainPage.TITLE));


        driver.get(PanelUserCreatePage.URL);
        PanelUserCreatePage panelCreateUserPage = new PanelUserCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelCreateUserPage.getEmail()));
        panelCreateUserPage.enterName();
        panelCreateUserPage.enterEmail(email);

        panelCreateUserPage.clickUserType();
        panelCreateUserPage.clickSuperAdmin();
        panelCreateUserPage.clickRegisterButton();

        wait.until(ExpectedConditions.visibilityOf(panelCreateUserPage.getPopupMessages().get(1)));
        Assert.assertEquals(PanelUserCreatePage.INVALID_EMAIL, panelCreateUserPage.getPopupMessages().get(1).getText());

    }

    @Test
    public void testAddUserWhenEmailIsAscii(){
        String email = RandomStringUtils.randomAscii(13) +"@oww.pl";

        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs(PanelMainPage.TITLE));


        driver.get(PanelUserCreatePage.URL);
        PanelUserCreatePage panelCreateUserPage = new PanelUserCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelCreateUserPage.getEmail()));
        panelCreateUserPage.enterName();
        panelCreateUserPage.enterEmail(email);

        panelCreateUserPage.clickUserType();
        panelCreateUserPage.clickSuperAdmin();
        panelCreateUserPage.clickRegisterButton();

        wait.until(ExpectedConditions.visibilityOf(panelCreateUserPage.getPopupMessages().get(1)));
        Assert.assertEquals(PanelUserCreatePage.INVALID_EMAIL, panelCreateUserPage.getPopupMessages().get(1).getText());

    }

    @Test
    public void testAddUserWhenEmailIsEmpty(){
        String email = "";

        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs(PanelMainPage.TITLE));


        driver.get(PanelUserCreatePage.URL);
        PanelUserCreatePage panelCreateUserPage = new PanelUserCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelCreateUserPage.getEmail()));
        panelCreateUserPage.enterName();
        panelCreateUserPage.enterEmail(email);

        panelCreateUserPage.clickUserType();
        panelCreateUserPage.clickSuperAdmin();
        panelCreateUserPage.clickRegisterButton();

        wait.until(ExpectedConditions.visibilityOf(panelCreateUserPage.getPopupMessages().get(1)));
        Assert.assertEquals(PanelUserCreatePage.EMPTY_EMAIL, panelCreateUserPage.getPopupMessages().get(1).getText());

    }

    @Test
    public void testAddUserWhenEmailIsNull(){

        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs(PanelMainPage.TITLE));


        driver.get(PanelUserCreatePage.URL);
        PanelUserCreatePage panelCreateUserPage = new PanelUserCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelCreateUserPage.getEmail()));
        panelCreateUserPage.enterName();
        panelCreateUserPage.enterNullEmail();

        panelCreateUserPage.clickUserType();
        panelCreateUserPage.clickSuperAdmin();
        panelCreateUserPage.clickRegisterButton();

        wait.until(ExpectedConditions.visibilityOf(panelCreateUserPage.getPopupMessages().get(1)));
        Assert.assertEquals(PanelUserCreatePage.EMPTY_EMAIL, panelCreateUserPage.getPopupMessages().get(1).getText());

    }

    @Test
    public void testAddUserWhenNameIsEmpty(){
        String name = "";

        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs(PanelMainPage.TITLE));


        driver.get(PanelUserCreatePage.URL);
        PanelUserCreatePage panelCreateUserPage = new PanelUserCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelCreateUserPage.getEmail()));
        panelCreateUserPage.enterName(name);
        panelCreateUserPage.enterEmail();

        panelCreateUserPage.clickUserType();
        panelCreateUserPage.clickSuperAdmin();
        panelCreateUserPage.clickRegisterButton();

        wait.until(ExpectedConditions.visibilityOf(panelCreateUserPage.getPopupMessages().get(0)));
        Assert.assertEquals(PanelUserCreatePage.EMPTY_USER_NAME, panelCreateUserPage.getPopupMessages().get(0).getText());

    }

    @Test
    public void testAddUserWhenNameIsNull(){


        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs(PanelMainPage.TITLE));


        driver.get(PanelUserCreatePage.URL);
        PanelUserCreatePage panelCreateUserPage = new PanelUserCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelCreateUserPage.getEmail()));
        panelCreateUserPage.enterNullEmail();
        panelCreateUserPage.enterEmail();

        panelCreateUserPage.clickUserType();
        panelCreateUserPage.clickSuperAdmin();
        panelCreateUserPage.clickRegisterButton();

        wait.until(ExpectedConditions.visibilityOf(panelCreateUserPage.getPopupMessages().get(0)));
        Assert.assertEquals(PanelUserCreatePage.EMPTY_USER_NAME, panelCreateUserPage.getPopupMessages().get(0).getText());

    }

    @Test
    public void testAddUserWhenNameIsInvalid(){

        String name = RandomStringUtils.randomAlphabetic(12);

        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs(PanelMainPage.TITLE));


        driver.get(PanelUserCreatePage.URL);
        PanelUserCreatePage panelCreateUserPage = new PanelUserCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelCreateUserPage.getEmail()));
        panelCreateUserPage.enterName(name);
        panelCreateUserPage.enterEmail();

        panelCreateUserPage.clickUserType();
        panelCreateUserPage.clickSuperAdmin();
        panelCreateUserPage.clickRegisterButton();

        wait.until(ExpectedConditions.visibilityOf(panelCreateUserPage.getPopupMessages().get(0)));
        Assert.assertEquals(PanelUserCreatePage.INVALID_NAME, panelCreateUserPage.getPopupMessages().get(0).getText());

    }

    @Test
    public void testAddUserWhenNameIsAscii(){

        String name = RandomStringUtils.randomAscii(10) + " " + RandomStringUtils.randomAscii(12);

        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs(PanelMainPage.TITLE));


        driver.get(PanelUserCreatePage.URL);
        PanelUserCreatePage panelCreateUserPage = new PanelUserCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelCreateUserPage.getEmail()));
        panelCreateUserPage.enterName(name);
        panelCreateUserPage.enterEmail();

        panelCreateUserPage.clickUserType();
        panelCreateUserPage.clickSuperAdmin();
        panelCreateUserPage.clickRegisterButton();

        wait.until(ExpectedConditions.visibilityOf(panelCreateUserPage.getPopupMessages().get(0)));
        Assert.assertEquals(PanelUserCreatePage.EMPTY_USER_NAME, panelCreateUserPage.getPopupMessages().get(0).getText());

    }


}
