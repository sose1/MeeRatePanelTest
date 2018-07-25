package test.panel;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.panel.*;
import test.FunctionalTest;

public class PanelEventPageTest extends FunctionalTest {

    @Test
    public void testClickAddEventButton(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventPage.URL);
        PanelEventPage panelEventPage = new PanelEventPage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventPage.getAddEventButton()));
        panelEventPage.clickAddEventButton();

        Assert.assertEquals(PanelEventCreatePage.URL, driver.getCurrentUrl());
    }

    @Test
    public void testEventDeleteButton(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        String nameEvent = RandomStringUtils.randomAlphanumeric(15) + " "
                + RandomStringUtils.randomAlphanumeric(10);

        panelEventCreatePage.enterNameEvent(nameEvent);
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        PanelEventPage panelEventPage = new PanelEventPage(driver);
        wait.until(ExpectedConditions.visibilityOf(panelEventPage.getFlashMessage()));
        Assert.assertEquals(PanelEventPage.URL, driver.getCurrentUrl());

        panelEventPage.clickCanelButton();

        panelEventPage.clickDeleteButtonForEventName(nameEvent);

    }

    @Test
    public void testUpdateCorrectNameEvent(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        String nameEvent = RandomStringUtils.randomAlphanumeric(15) + " "
                + RandomStringUtils.randomAlphanumeric(10);

        panelEventCreatePage.enterNameEvent(nameEvent);
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        PanelEventPage panelEventPage = new PanelEventPage(driver);
        wait.until(ExpectedConditions.visibilityOf(panelEventPage.getFlashMessage()));
        Assert.assertEquals(PanelEventPage.URL, driver.getCurrentUrl());

        panelEventPage.clickCanelButton();

        panelEventPage.clickEditButtonForEventName(nameEvent);

        PanelEventUpdatePage panelEventUpdatePage = new PanelEventUpdatePage(driver);

        panelEventUpdatePage.enterNameEvent();
        panelEventUpdatePage.clickAddEventButton();


        Assert.assertTrue(panelEventPage.getFlashMessage().isDisplayed());
    }

    @Test
    public void testUpdateCorrectInfoEvent(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        String nameEvent = RandomStringUtils.randomAlphanumeric(15) + " "
                + RandomStringUtils.randomAlphanumeric(10);

        panelEventCreatePage.enterNameEvent(nameEvent);
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        PanelEventPage panelEventPage = new PanelEventPage(driver);
        wait.until(ExpectedConditions.visibilityOf(panelEventPage.getFlashMessage()));
        Assert.assertEquals(PanelEventPage.URL, driver.getCurrentUrl());

        panelEventPage.clickCanelButton();

        panelEventPage.clickEditButtonForEventName(nameEvent);

        PanelEventUpdatePage panelEventUpdatePage = new PanelEventUpdatePage(driver);

        panelEventUpdatePage.enterInfoEvent();
        panelEventUpdatePage.clickAddEventButton();


        Assert.assertTrue(panelEventPage.getFlashMessage().isDisplayed());
    }

    @Test
    public void testUpdateCorrectDateEvent(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        String nameEvent = RandomStringUtils.randomAlphanumeric(15) + " "
                + RandomStringUtils.randomAlphanumeric(10);

        panelEventCreatePage.enterNameEvent(nameEvent);
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        PanelEventPage panelEventPage = new PanelEventPage(driver);
        wait.until(ExpectedConditions.visibilityOf(panelEventPage.getFlashMessage()));
        Assert.assertEquals(PanelEventPage.URL, driver.getCurrentUrl());

        panelEventPage.clickCanelButton();

        panelEventPage.clickEditButtonForEventName(nameEvent);

        PanelEventUpdatePage panelEventUpdatePage = new PanelEventUpdatePage(driver);

        panelEventUpdatePage.enterStartDate();
        panelEventUpdatePage.enterEndDate();
        panelEventUpdatePage.clickAddEventButton();


        Assert.assertTrue(panelEventPage.getFlashMessage().isDisplayed());
    }

    @Test
    public void testUpdateCorrectLocationEvent(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        String nameEvent = RandomStringUtils.randomAlphanumeric(15) + " "
                + RandomStringUtils.randomAlphanumeric(10);

        panelEventCreatePage.enterNameEvent(nameEvent);
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        PanelEventPage panelEventPage = new PanelEventPage(driver);
        wait.until(ExpectedConditions.visibilityOf(panelEventPage.getFlashMessage()));
        Assert.assertEquals(PanelEventPage.URL, driver.getCurrentUrl());

        panelEventPage.clickCanelButton();

        panelEventPage.clickEditButtonForEventName(nameEvent);

        PanelEventUpdatePage panelEventUpdatePage = new PanelEventUpdatePage(driver);

        panelEventUpdatePage.enterLocationEvent();
        panelEventUpdatePage.clickAddEventButton();


        Assert.assertTrue(panelEventPage.getFlashMessage().isDisplayed());
    }

    @Test
    public void testUpdateEmptyNameEvent(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        String nameEvent = RandomStringUtils.randomAlphanumeric(15) + " "
                + RandomStringUtils.randomAlphanumeric(10);

        panelEventCreatePage.enterNameEvent(nameEvent);
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        PanelEventPage panelEventPage = new PanelEventPage(driver);
        wait.until(ExpectedConditions.visibilityOf(panelEventPage.getFlashMessage()));
        Assert.assertEquals(PanelEventPage.URL, driver.getCurrentUrl());

        panelEventPage.clickCanelButton();

        panelEventPage.clickEditButtonForEventName(nameEvent);

        PanelEventUpdatePage panelEventUpdatePage = new PanelEventUpdatePage(driver);

        String emptyName ="";
        panelEventUpdatePage.enterNameEvent(emptyName);
        panelEventUpdatePage.clickAddEventButton();


        Assert.assertTrue(panelEventUpdatePage.getFlashMessage().isDisplayed());
    }

    @Test
    public void testUpdateEmptyInfoEvent(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        String nameEvent = RandomStringUtils.randomAlphanumeric(15) + " "
                + RandomStringUtils.randomAlphanumeric(10);

        panelEventCreatePage.enterNameEvent(nameEvent);
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        PanelEventPage panelEventPage = new PanelEventPage(driver);
        wait.until(ExpectedConditions.visibilityOf(panelEventPage.getFlashMessage()));
        Assert.assertEquals(PanelEventPage.URL, driver.getCurrentUrl());

        panelEventPage.clickCanelButton();

        panelEventPage.clickEditButtonForEventName(nameEvent);

        PanelEventUpdatePage panelEventUpdatePage = new PanelEventUpdatePage(driver);

        String emptyInfo ="";
        panelEventUpdatePage.enterInfoEvent(emptyInfo);
        panelEventUpdatePage.clickAddEventButton();


        Assert.assertTrue(panelEventUpdatePage.getFlashMessage().isDisplayed());
    }

    @Test
    public void testUpdateEmptyDateEvent(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        String nameEvent = RandomStringUtils.randomAlphanumeric(15) + " "
                + RandomStringUtils.randomAlphanumeric(10);

        panelEventCreatePage.enterNameEvent(nameEvent);
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        PanelEventPage panelEventPage = new PanelEventPage(driver);
        wait.until(ExpectedConditions.visibilityOf(panelEventPage.getFlashMessage()));
        Assert.assertEquals(PanelEventPage.URL, driver.getCurrentUrl());

        panelEventPage.clickCanelButton();

        panelEventPage.clickEditButtonForEventName(nameEvent);

        PanelEventUpdatePage panelEventUpdatePage = new PanelEventUpdatePage(driver);

        String emptyDate ="";
        panelEventUpdatePage.enterInvalidDate(emptyDate);
        panelEventUpdatePage.clickAddEventButton();


        Assert.assertTrue(panelEventUpdatePage.getFlashMessage().isDisplayed());
    }

    @Test
    public void testUpdateEmptyLocationEvent(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        String nameEvent = RandomStringUtils.randomAlphanumeric(15) + " "
                + RandomStringUtils.randomAlphanumeric(10);

        panelEventCreatePage.enterNameEvent(nameEvent);
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        PanelEventPage panelEventPage = new PanelEventPage(driver);
        wait.until(ExpectedConditions.visibilityOf(panelEventPage.getFlashMessage()));
        Assert.assertEquals(PanelEventPage.URL, driver.getCurrentUrl());

        panelEventPage.clickCanelButton();

        panelEventPage.clickEditButtonForEventName(nameEvent);

        PanelEventUpdatePage panelEventUpdatePage = new PanelEventUpdatePage(driver);

        String emptyLocation ="";
        panelEventUpdatePage.enterLocationEvent(emptyLocation);
        panelEventUpdatePage.clickAddEventButton();


        Assert.assertTrue(panelEventUpdatePage.getFlashMessage().isDisplayed());
    }

    @Test
    public void testUpdateAsciiNameEvent(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        String nameEvent = RandomStringUtils.randomAlphanumeric(15) + " "
                + RandomStringUtils.randomAlphanumeric(10);

        panelEventCreatePage.enterNameEvent(nameEvent);
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        PanelEventPage panelEventPage = new PanelEventPage(driver);
        wait.until(ExpectedConditions.visibilityOf(panelEventPage.getFlashMessage()));
        Assert.assertEquals(PanelEventPage.URL, driver.getCurrentUrl());

        panelEventPage.clickCanelButton();

        panelEventPage.clickEditButtonForEventName(nameEvent);

        PanelEventUpdatePage panelEventUpdatePage = new PanelEventUpdatePage(driver);

        String newName = RandomStringUtils.randomAlphanumeric(15) + " "
                + RandomStringUtils.randomAlphanumeric(10);

        panelEventUpdatePage.enterNameEvent(newName);
        panelEventUpdatePage.clickAddEventButton();


        Assert.assertTrue(panelEventUpdatePage.getFlashMessage().isDisplayed());

    }

    @Test
    public void testUpdateAsciiInfoEvent(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        String nameEvent = RandomStringUtils.randomAlphanumeric(15) + " "
                + RandomStringUtils.randomAlphanumeric(10);

        panelEventCreatePage.enterNameEvent(nameEvent);
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        PanelEventPage panelEventPage = new PanelEventPage(driver);
        wait.until(ExpectedConditions.visibilityOf(panelEventPage.getFlashMessage()));
        Assert.assertEquals(PanelEventPage.URL, driver.getCurrentUrl());

        panelEventPage.clickCanelButton();

        panelEventPage.clickEditButtonForEventName(nameEvent);

        PanelEventUpdatePage panelEventUpdatePage = new PanelEventUpdatePage(driver);

        String newInfo = RandomStringUtils.randomAlphanumeric(15) + " "
                + RandomStringUtils.randomAlphanumeric(10);

        panelEventUpdatePage.enterInfoEvent(newInfo);
        panelEventUpdatePage.clickAddEventButton();


        Assert.assertTrue(panelEventUpdatePage.getFlashMessage().isDisplayed());

    }

    @Test
    public void testUpdateAsciiDateEvent(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        String nameEvent = RandomStringUtils.randomAlphanumeric(15) + " "
                + RandomStringUtils.randomAlphanumeric(10);

        panelEventCreatePage.enterNameEvent(nameEvent);
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        PanelEventPage panelEventPage = new PanelEventPage(driver);
        wait.until(ExpectedConditions.visibilityOf(panelEventPage.getFlashMessage()));
        Assert.assertEquals(PanelEventPage.URL, driver.getCurrentUrl());

        panelEventPage.clickCanelButton();

        panelEventPage.clickEditButtonForEventName(nameEvent);

        PanelEventUpdatePage panelEventUpdatePage = new PanelEventUpdatePage(driver);

        String date = RandomStringUtils.randomAlphanumeric(15);

        panelEventUpdatePage.enterInvalidDate(date);
        panelEventUpdatePage.clickAddEventButton();


        Assert.assertTrue(panelEventUpdatePage.getFlashMessage().isDisplayed());

    }

    @Test
    public void testUpdateAsciiLocationEvent(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        String nameEvent = RandomStringUtils.randomAlphanumeric(15) + " "
                + RandomStringUtils.randomAlphanumeric(10);

        panelEventCreatePage.enterNameEvent(nameEvent);
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        PanelEventPage panelEventPage = new PanelEventPage(driver);
        wait.until(ExpectedConditions.visibilityOf(panelEventPage.getFlashMessage()));
        Assert.assertEquals(PanelEventPage.URL, driver.getCurrentUrl());

        panelEventPage.clickCanelButton();

        panelEventPage.clickEditButtonForEventName(nameEvent);

        PanelEventUpdatePage panelEventUpdatePage = new PanelEventUpdatePage(driver);

        String location = RandomStringUtils.randomAlphanumeric(15) + " "
                + RandomStringUtils.randomAlphanumeric(10);

        panelEventUpdatePage.enterLocationEvent(location);
        panelEventUpdatePage.clickAddEventButton();


        Assert.assertTrue(panelEventUpdatePage.getFlashMessage().isDisplayed());

    }

}
