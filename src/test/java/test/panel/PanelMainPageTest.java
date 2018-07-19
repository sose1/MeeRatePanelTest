package test.panel;


import org.junit.Assert;
import org.junit.Test;
import page.panel.PanelEventPage;
import page.panel.PanelLoginPage;
import page.panel.PanelMainPage;
import test.FunctionalTest;

public class PanelMainPageTest extends FunctionalTest {

    @Test
    public void testClickEventButton(){
        PanelLoginPage panelLoginPage = new PanelLoginPage(driver);
        panelLoginPage.loginAsSuperAdmin();

        PanelMainPage panelMainPage = new PanelMainPage(driver);

        panelMainPage.clickEventButton();

        Assert.assertEquals(PanelEventPage.URL, driver.getCurrentUrl());

    }
}
