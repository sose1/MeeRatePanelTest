package test.panel;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.panel.PanelLoginPage;
import page.panel.PanelUserCreatePage;
import page.panel.PanelUserPage;
import page.panel.PanelUserUpdatePage;
import test.FunctionalTest;

import java.util.List;


public class PanelUserPageTest extends FunctionalTest {

    @Test
    public void testClickCreateUserButton(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelUserPage.URL);
        PanelUserPage panelUserPage = new PanelUserPage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getCreateUserButton()));
        panelUserPage.clickCreateUserButton();

        wait.until(ExpectedConditions.titleIs("Dodaj użytkownika"));
        Assert.assertEquals(PanelUserCreatePage.URL, driver.getCurrentUrl());
    }

    @Test
    public void testUserDeleteButton(){

        String email = RandomStringUtils.randomAlphabetic(10) + "@co.pl";
        System.out.println("Utworozno " + email);
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelUserPage.URL);
        PanelUserPage panelUserPage = new PanelUserPage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getCreateUserButton()));
        panelUserPage.clickCreateUserButton();

        wait.until(ExpectedConditions.titleIs("Dodaj użytkownika"));
        Assert.assertEquals(PanelUserCreatePage.URL, driver.getCurrentUrl());

        PanelUserCreatePage panelUserCreatePage = new PanelUserCreatePage(driver);
        panelUserCreatePage.enterName();
        panelUserCreatePage.enterEmail(email);
        panelUserCreatePage.clickUserType();
        panelUserCreatePage.clickAdmin();
        panelUserCreatePage.clickRegisterButton();

        wait.until(ExpectedConditions.titleIs("Użytkownicy"));
        Assert.assertEquals(PanelUserPage.URL, driver.getCurrentUrl());// FIXME: 23.07.2018

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getFlashMessage()));
        panelUserPage.clickCanelButton();
        panelUserPage.clickDeleteButtonForEmail(email);
    }

    @Test
    public void testUserUpdateButton(){
        String email = RandomStringUtils.randomAlphabetic(10) + "@co.pl";
        System.out.println("Utworozno " + email);
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelUserPage.URL);
        PanelUserPage panelUserPage = new PanelUserPage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getCreateUserButton()));
        panelUserPage.clickCreateUserButton();

        wait.until(ExpectedConditions.titleIs("Dodaj użytkownika"));
        Assert.assertEquals(PanelUserCreatePage.URL, driver.getCurrentUrl());

        PanelUserCreatePage panelUserCreatePage = new PanelUserCreatePage(driver);
        panelUserCreatePage.enterName();
        panelUserCreatePage.enterEmail(email);
        panelUserCreatePage.clickUserType();
        panelUserCreatePage.clickAdmin();
        panelUserCreatePage.clickRegisterButton();

        wait.until(ExpectedConditions.titleIs("Użytkownicy"));
        Assert.assertEquals(PanelUserPage.URL, driver.getCurrentUrl());// FIXME: 23.07.2018

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getFlashMessage()));
        panelUserPage.clickCanelButton();

        panelUserPage.clickEditButtonForEmail(email);
    }

    @Test
    public void testUserUpdateName(){
        String email = RandomStringUtils.randomAlphabetic(10) + "@co.pl";
        System.out.println("Utworozno " + email);
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelUserPage.URL);
        PanelUserPage panelUserPage = new PanelUserPage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getCreateUserButton()));
        panelUserPage.clickCreateUserButton();

        wait.until(ExpectedConditions.titleIs("Dodaj użytkownika"));
        Assert.assertEquals(PanelUserCreatePage.URL, driver.getCurrentUrl());

        PanelUserCreatePage panelUserCreatePage = new PanelUserCreatePage(driver);
        panelUserCreatePage.enterName();
        panelUserCreatePage.enterEmail(email);
        panelUserCreatePage.clickUserType();
        panelUserCreatePage.clickAdmin();
        panelUserCreatePage.clickRegisterButton();

        wait.until(ExpectedConditions.titleIs("Użytkownicy"));
        Assert.assertEquals(PanelUserPage.URL, driver.getCurrentUrl());// FIXME: 23.07.2018

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getFlashMessage()));
        panelUserPage.clickCanelButton();
        panelUserPage.clickEditButtonForEmail(email);

        PanelUserUpdatePage panelUserUpdatePage = new PanelUserUpdatePage(driver);

        panelUserUpdatePage.enterNewName();
        panelUserUpdatePage.clickUpdateButton();


        Assert.assertTrue(panelUserPage.getFlashMessage().isDisplayed());

    }

    @Test
    public void testUserUpdateEmail(){
        String email = RandomStringUtils.randomAlphabetic(10) + "@co.pl";
        System.out.println("Utworozno " + email);
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelUserPage.URL);
        PanelUserPage panelUserPage = new PanelUserPage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getCreateUserButton()));
        panelUserPage.clickCreateUserButton();

        wait.until(ExpectedConditions.titleIs("Dodaj użytkownika"));
        Assert.assertEquals(PanelUserCreatePage.URL, driver.getCurrentUrl());

        PanelUserCreatePage panelUserCreatePage = new PanelUserCreatePage(driver);
        panelUserCreatePage.enterName();
        panelUserCreatePage.enterEmail(email);
        panelUserCreatePage.clickUserType();
        panelUserCreatePage.clickAdmin();
        panelUserCreatePage.clickRegisterButton();

        wait.until(ExpectedConditions.titleIs("Użytkownicy"));
        Assert.assertEquals(PanelUserPage.URL, driver.getCurrentUrl());// FIXME: 23.07.2018

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getFlashMessage()));
        panelUserPage.clickCanelButton();
        panelUserPage.clickEditButtonForEmail(email);

        PanelUserUpdatePage panelUserUpdatePage = new PanelUserUpdatePage(driver);

        panelUserUpdatePage.enterNewEmail();
        panelUserUpdatePage.clickUpdateButton();


        Assert.assertTrue(panelUserPage.getFlashMessage().isDisplayed());
    }

    @Test
    public void testUserUpdateType(){
        String email = RandomStringUtils.randomAlphabetic(10) + "@co.pl";
        System.out.println("Utworozno " + email);
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelUserPage.URL);
        PanelUserPage panelUserPage = new PanelUserPage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getCreateUserButton()));
        panelUserPage.clickCreateUserButton();

        wait.until(ExpectedConditions.titleIs("Dodaj użytkownika"));
        Assert.assertEquals(PanelUserCreatePage.URL, driver.getCurrentUrl());

        PanelUserCreatePage panelUserCreatePage = new PanelUserCreatePage(driver);
        panelUserCreatePage.enterName();
        panelUserCreatePage.enterEmail(email);
        panelUserCreatePage.clickUserType();
        panelUserCreatePage.clickAdmin();
        panelUserCreatePage.clickRegisterButton();

        wait.until(ExpectedConditions.titleIs("Użytkownicy"));
        Assert.assertEquals(PanelUserPage.URL, driver.getCurrentUrl());// FIXME: 23.07.2018

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getFlashMessage()));
        panelUserPage.clickCanelButton();
        panelUserPage.clickEditButtonForEmail(email);



        PanelUserUpdatePage panelUserUpdatePage = new PanelUserUpdatePage(driver);

        panelUserUpdatePage.clickUserType();
        panelUserUpdatePage.clickSpeaker();
        panelUserUpdatePage.clickUpdateButton();


        Assert.assertTrue(panelUserPage.getFlashMessage().isDisplayed());
    }

    @Test
    public void testUserUpdateInvalidName(){
        String email = RandomStringUtils.randomAlphabetic(10) + "@co.pl";
        System.out.println("Utworozno " + email);
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelUserPage.URL);
        PanelUserPage panelUserPage = new PanelUserPage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getCreateUserButton()));
        panelUserPage.clickCreateUserButton();

        wait.until(ExpectedConditions.titleIs("Dodaj użytkownika"));
        Assert.assertEquals(PanelUserCreatePage.URL, driver.getCurrentUrl());

        PanelUserCreatePage panelUserCreatePage = new PanelUserCreatePage(driver);
        panelUserCreatePage.enterName();
        panelUserCreatePage.enterEmail(email);
        panelUserCreatePage.clickUserType();
        panelUserCreatePage.clickAdmin();
        panelUserCreatePage.clickRegisterButton();

        wait.until(ExpectedConditions.titleIs("Użytkownicy"));
        Assert.assertEquals(PanelUserPage.URL, driver.getCurrentUrl());// FIXME: 23.07.2018

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getFlashMessage()));
        panelUserPage.clickCanelButton();
        panelUserPage.clickEditButtonForEmail(email);

        PanelUserUpdatePage panelUserUpdatePage = new PanelUserUpdatePage(driver);

        String name = RandomStringUtils.random(8);
        panelUserUpdatePage.enterNewName(name);
        panelUserUpdatePage.clickUpdateButton();


        Assert.assertTrue(panelUserUpdatePage.getFlashMessage().isDisplayed());
    }


    @Test
    public void testUserUpdateNullName(){
        String email = RandomStringUtils.randomAlphabetic(10) + "@co.pl";
        System.out.println("Utworozno " + email);
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelUserPage.URL);
        PanelUserPage panelUserPage = new PanelUserPage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getCreateUserButton()));
        panelUserPage.clickCreateUserButton();

        wait.until(ExpectedConditions.titleIs("Dodaj użytkownika"));
        Assert.assertEquals(PanelUserCreatePage.URL, driver.getCurrentUrl());

        PanelUserCreatePage panelUserCreatePage = new PanelUserCreatePage(driver);
        panelUserCreatePage.enterName();
        panelUserCreatePage.enterEmail(email);
        panelUserCreatePage.clickUserType();
        panelUserCreatePage.clickAdmin();
        panelUserCreatePage.clickRegisterButton();

        wait.until(ExpectedConditions.titleIs("Użytkownicy"));
        Assert.assertEquals(PanelUserPage.URL, driver.getCurrentUrl());// FIXME: 23.07.2018

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getFlashMessage()));
        panelUserPage.clickCanelButton();
        panelUserPage.clickEditButtonForEmail(email);

        PanelUserUpdatePage panelUserUpdatePage = new PanelUserUpdatePage(driver);


        panelUserUpdatePage.enterNewName(null);
        panelUserUpdatePage.clickUpdateButton();


        Assert.assertTrue(panelUserUpdatePage.getFlashMessage().isDisplayed());
    }

    @Test
    public void testUserUpdateEmptyName(){
        String email = RandomStringUtils.randomAlphabetic(10) + "@co.pl";
        System.out.println("Utworozno " + email);
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelUserPage.URL);
        PanelUserPage panelUserPage = new PanelUserPage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getCreateUserButton()));
        panelUserPage.clickCreateUserButton();

        wait.until(ExpectedConditions.titleIs("Dodaj użytkownika"));
        Assert.assertEquals(PanelUserCreatePage.URL, driver.getCurrentUrl());

        PanelUserCreatePage panelUserCreatePage = new PanelUserCreatePage(driver);
        panelUserCreatePage.enterName();
        panelUserCreatePage.enterEmail(email);
        panelUserCreatePage.clickUserType();
        panelUserCreatePage.clickAdmin();
        panelUserCreatePage.clickRegisterButton();

        wait.until(ExpectedConditions.titleIs("Użytkownicy"));
        Assert.assertEquals(PanelUserPage.URL, driver.getCurrentUrl());// FIXME: 23.07.2018

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getFlashMessage()));
        panelUserPage.clickCanelButton();
        panelUserPage.clickEditButtonForEmail(email);

        PanelUserUpdatePage panelUserUpdatePage = new PanelUserUpdatePage(driver);

        String name = "";
        panelUserUpdatePage.enterNewName(name);
        panelUserUpdatePage.clickUpdateButton();


        Assert.assertTrue(panelUserUpdatePage.getFlashMessage().isDisplayed());
    }


    @Test
    public void testUserUpdateAsciiName(){
        String email = RandomStringUtils.randomAlphabetic(10) + "@co.pl";
        System.out.println("Utworozno " + email);
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelUserPage.URL);
        PanelUserPage panelUserPage = new PanelUserPage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getCreateUserButton()));
        panelUserPage.clickCreateUserButton();

        wait.until(ExpectedConditions.titleIs("Dodaj użytkownika"));
        Assert.assertEquals(PanelUserCreatePage.URL, driver.getCurrentUrl());

        PanelUserCreatePage panelUserCreatePage = new PanelUserCreatePage(driver);
        panelUserCreatePage.enterName();
        panelUserCreatePage.enterEmail(email);
        panelUserCreatePage.clickUserType();
        panelUserCreatePage.clickAdmin();
        panelUserCreatePage.clickRegisterButton();

        wait.until(ExpectedConditions.titleIs("Użytkownicy"));
        Assert.assertEquals(PanelUserPage.URL, driver.getCurrentUrl());// FIXME: 23.07.2018

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getFlashMessage()));
        panelUserPage.clickCanelButton();
        panelUserPage.clickEditButtonForEmail(email);


        PanelUserUpdatePage panelUserUpdatePage = new PanelUserUpdatePage(driver);

        String name = RandomStringUtils.randomAscii(12) + " " + RandomStringUtils.randomAscii(12);
        panelUserUpdatePage.enterNewName(name);
        panelUserUpdatePage.clickUpdateButton();


        Assert.assertTrue(panelUserUpdatePage.getFlashMessage().isDisplayed());

    }

    @Test
    public void testUserUpdateInvalidEmail(){
        String email = RandomStringUtils.randomAlphabetic(10) + "@co.pl";
        System.out.println("Utworozno " + email);
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelUserPage.URL);
        PanelUserPage panelUserPage = new PanelUserPage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getCreateUserButton()));
        panelUserPage.clickCreateUserButton();

        wait.until(ExpectedConditions.titleIs("Dodaj użytkownika"));
        Assert.assertEquals(PanelUserCreatePage.URL, driver.getCurrentUrl());

        PanelUserCreatePage panelUserCreatePage = new PanelUserCreatePage(driver);
        panelUserCreatePage.enterName();
        panelUserCreatePage.enterEmail(email);
        panelUserCreatePage.clickUserType();
        panelUserCreatePage.clickAdmin();
        panelUserCreatePage.clickRegisterButton();

        wait.until(ExpectedConditions.titleIs("Użytkownicy"));
        Assert.assertEquals(PanelUserPage.URL, driver.getCurrentUrl());// FIXME: 23.07.2018

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getFlashMessage()));
        panelUserPage.clickCanelButton();
        panelUserPage.clickEditButtonForEmail(email);

        PanelUserUpdatePage panelUserUpdatePage = new PanelUserUpdatePage(driver);

        email = RandomStringUtils.randomAlphabetic(8);
        panelUserUpdatePage.enterNewEmail(email);
        panelUserUpdatePage.clickUpdateButton();


        Assert.assertTrue(panelUserUpdatePage.getFlashMessage().isDisplayed());
    }

    @Test
    public void testUserUpdateEmptyEmail(){
        String email = RandomStringUtils.randomAlphabetic(10) + "@co.pl";
        System.out.println("Utworozno " + email);
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelUserPage.URL);
        PanelUserPage panelUserPage = new PanelUserPage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getCreateUserButton()));
        panelUserPage.clickCreateUserButton();

        wait.until(ExpectedConditions.titleIs("Dodaj użytkownika"));
        Assert.assertEquals(PanelUserCreatePage.URL, driver.getCurrentUrl());

        PanelUserCreatePage panelUserCreatePage = new PanelUserCreatePage(driver);
        panelUserCreatePage.enterName();
        panelUserCreatePage.enterEmail(email);
        panelUserCreatePage.clickUserType();
        panelUserCreatePage.clickAdmin();
        panelUserCreatePage.clickRegisterButton();

        wait.until(ExpectedConditions.titleIs("Użytkownicy"));
        Assert.assertEquals(PanelUserPage.URL, driver.getCurrentUrl());// FIXME: 23.07.2018

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getFlashMessage()));
        panelUserPage.clickCanelButton();
        panelUserPage.clickEditButtonForEmail(email);

        PanelUserUpdatePage panelUserUpdatePage = new PanelUserUpdatePage(driver);

        String newEmail = "";
        panelUserUpdatePage.enterNewEmail(newEmail);
        panelUserUpdatePage.clickUpdateButton();


        Assert.assertTrue(panelUserUpdatePage.getFlashMessage().isDisplayed());

    }

    @Test
    public void testUserUpdateAsciiEmail(){

        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        String email = RandomStringUtils.randomAlphabetic(10) + "@co.pl";
        System.out.println("Utworozno " + email);

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelUserPage.URL);
        PanelUserPage panelUserPage = new PanelUserPage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getCreateUserButton()));
        panelUserPage.clickCreateUserButton();

        wait.until(ExpectedConditions.titleIs("Dodaj użytkownika"));
        Assert.assertEquals(PanelUserCreatePage.URL, driver.getCurrentUrl());

        PanelUserCreatePage panelUserCreatePage = new PanelUserCreatePage(driver);
        panelUserCreatePage.enterName();
        panelUserCreatePage.enterEmail(email);
        panelUserCreatePage.clickUserType();
        panelUserCreatePage.clickAdmin();
        panelUserCreatePage.clickRegisterButton();

        wait.until(ExpectedConditions.titleIs("Użytkownicy"));
        Assert.assertEquals(PanelUserPage.URL, driver.getCurrentUrl());//

        wait.until(ExpectedConditions.visibilityOf(panelUserPage.getFlashMessage()));
        panelUserPage.clickCanelButton();
        panelUserPage.clickEditButtonForEmail(email);

        PanelUserUpdatePage panelUserUpdatePage = new PanelUserUpdatePage(driver);

        String newEmail = RandomStringUtils.randomAscii(12) + "coo.pl";
        panelUserUpdatePage.enterNewEmail(newEmail);
        panelUserUpdatePage.clickUpdateButton();


        Assert.assertTrue(panelUserUpdatePage.getFlashMessage().isDisplayed());
    }


}





