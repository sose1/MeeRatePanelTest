package test.panel;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.panel.PanelEventCreatePage;
import page.panel.PanelEventPage;
import page.panel.PanelLoginPage;
import test.FunctionalTest;

public class PanelEventCreatePageTest extends FunctionalTest {

    @Test
    public void testCreateCorrectEvent(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        panelEventCreatePage.enterNameEvent();
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        PanelEventPage panelEventPage = new PanelEventPage(driver);
        wait.until(ExpectedConditions.visibilityOf(panelEventPage.getFlashMessage()));
        Assert.assertEquals(PanelEventPage.URL, driver.getCurrentUrl());
    }

    @Test
    public void testCreateEventWhenNameIsEmpty(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getPopupMessages().get(0)));

        Assert.assertEquals(PanelEventCreatePage.EMPTY_NAME_EVENT, panelEventCreatePage.getPopupMessages().get(0).getText());
    }

    @Test
    public void testCreateEventWhenInfoIsEmpty(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        panelEventCreatePage.enterNameEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getPopupMessages().get(1)));

        Assert.assertEquals(PanelEventCreatePage.EMPTY_INFO_EVENT, panelEventCreatePage.getPopupMessages().get(1).getText());
    }

    @Test
    public void testCreateEventWhenStartDateIsEmpty(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        panelEventCreatePage.enterNameEvent();
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getPopupMessages().get(2)));

        Assert.assertEquals(PanelEventCreatePage.EMPTY_START_DATE_EVENT, panelEventCreatePage.getPopupMessages().get(2).getText());
    }

    @Test
    public void testCreateEventWhenEndDateIsEmpty(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        panelEventCreatePage.enterNameEvent();
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getPopupMessages().get(3)));

        Assert.assertEquals(PanelEventCreatePage.EMPTY_END_DATE_EVENT, panelEventCreatePage.getPopupMessages().get(3).getText());
    }

    @Test
    public void testCreateEventWhenLocationIsEmpty(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        panelEventCreatePage.enterNameEvent();
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.clickAddEventButton();


        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getFlashMessage()));
        Assert.assertTrue(panelEventCreatePage.getFlashMessage().isDisplayed());
    }

    @Test
    public void testCreateEventWhenNameIsAscii(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        String name = RandomStringUtils.randomAscii(20);
        panelEventCreatePage.enterNameEvent(name);
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        PanelEventPage panelEventPage = new PanelEventPage(driver);
        wait.until(ExpectedConditions.visibilityOf(panelEventPage.getFlashMessage()));
        Assert.assertTrue(panelEventPage.getFlashMessage().isDisplayed());
    }

    @Test
    public void testCreateEventWhenInfoIsAscii(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        String info = RandomStringUtils.randomAscii(20);
        panelEventCreatePage.enterNameEvent();
        panelEventCreatePage.enterInfoEvent(info);
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        PanelEventPage panelEventPage = new PanelEventPage(driver);
        wait.until(ExpectedConditions.visibilityOf(panelEventPage.getFlashMessage()));
        Assert.assertTrue(panelEventPage.getFlashMessage().isDisplayed());
    }

    @Test
    public void testCreateEventWhenDateIsAscii(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        String date = RandomStringUtils.randomAscii(20);
        panelEventCreatePage.enterNameEvent();
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterInvalidDate(date);
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getFlashMessage()));
        Assert.assertTrue(panelEventCreatePage.getFlashMessage().isDisplayed());
    }

    @Test
    public void testCreateEventWhenLocationIsAscii(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        String location = RandomStringUtils.randomAscii(20);
        panelEventCreatePage.enterNameEvent();
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent(location);
        panelEventCreatePage.clickAddEventButton();

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getFlashMessage()));
        Assert.assertTrue(panelEventCreatePage.getFlashMessage().isDisplayed());
    }

    @Test
    public void testCreateEventWhenNameIsHtml(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        String name = "<b>To pogrubione</b>";
        panelEventCreatePage.enterNameEvent(name);
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getFlashMessage()));
        Assert.assertTrue(panelEventCreatePage.getFlashMessage().isDisplayed());
    }

    @Test
    public void testCreateEventWhenInfoIsHtml(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        String info = "<b>To jest pogrubione infoo</b>";
        panelEventCreatePage.enterNameEvent();
        panelEventCreatePage.enterInfoEvent(info);
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getFlashMessage()));
        Assert.assertTrue(panelEventCreatePage.getFlashMessage().isDisplayed());
    }

    @Test
    public void testCreateEventWhenDateIsHtml(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        String date = "<b>To pogrubione data</b>";
        panelEventCreatePage.enterNameEvent();
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterInvalidDate(date);
        panelEventCreatePage.enterLocationEvent();
        panelEventCreatePage.clickAddEventButton();

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getFlashMessage()));
        Assert.assertTrue(panelEventCreatePage.getFlashMessage().isDisplayed());
    }

    @Test
    public void testCreateEventWhenLocationIsHtml(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        wait.until(ExpectedConditions.titleIs("main view"));

        driver.get(PanelEventCreatePage.URL);
        PanelEventCreatePage panelEventCreatePage = new PanelEventCreatePage(driver);

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getInfoEventField()));

        String location = "<b>To pogrubione lokalizacja</b>";
        panelEventCreatePage.enterNameEvent();
        panelEventCreatePage.enterInfoEvent();
        panelEventCreatePage.enterStartDate();
        panelEventCreatePage.enterEndDate();
        panelEventCreatePage.enterLocationEvent(location);
        panelEventCreatePage.clickAddEventButton();

        wait.until(ExpectedConditions.visibilityOf(panelEventCreatePage.getFlashMessage()));
        Assert.assertTrue(panelEventCreatePage.getFlashMessage().isDisplayed());
    }
}
