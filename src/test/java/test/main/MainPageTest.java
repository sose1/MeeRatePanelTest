package test.main;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.main.MainContactPage;
import page.main.MainPage;
import test.FunctionalTest;

public class MainPageTest extends FunctionalTest {

    @Test
    public void testOpenMenu(){
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);

        wait.until(ExpectedConditions.visibilityOf(mainPage.getMenuButtonOpen()));
        mainPage.clickMenuButtonOpen();

        wait.until(ExpectedConditions.visibilityOf(mainPage.getMenuButtonClose()));
        Assert.assertTrue(mainPage.getMenuButtonClose().isDisplayed());
    }

    @Test
    public void testCloseMenu(){
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);

        wait.until(ExpectedConditions.visibilityOf(mainPage.getMenuButtonOpen()));
        mainPage.clickMenuButtonOpen();

        wait.until(ExpectedConditions.visibilityOf(mainPage.getMenuButtonClose()));
        Assert.assertTrue(mainPage.getMenuButtonClose().isDisplayed());
        mainPage.clickMenuButtonClose();

        wait.until(ExpectedConditions.visibilityOf(mainPage.getMenuButtonOpen()));
        Assert.assertTrue(mainPage.getMenuButtonOpen().isDisplayed());
    }

    @Test
    public void testContactButton(){
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);

        wait.until(ExpectedConditions.visibilityOf(mainPage.getMainContactButton()));
        mainPage.clickMainContactButton();

        Assert.assertEquals(MainContactPage.URL + ".html", driver.getCurrentUrl());
    }

    //todo testy poszczególnych eventów


    @Test
    public void test(){
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);

        System.out.println("AKTUaLNEE: " + mainPage.getActualEvents().size());
        System.out.println("FUTUREE: " + mainPage.getFutureEvents().size());
        System.out.println("ArchiwymmmE: " + mainPage.getArchiveEvents().size());
    }

    @Test
    public void testClickActualEvent(){
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);

        WebElement firstActualEvent = mainPage.getActualEvents().get(0);
        String firstEventId = firstActualEvent.getAttribute("id");

        firstActualEvent.click();

        Assert.assertEquals(MainPage.URL + "/" + firstEventId, driver.getCurrentUrl());
    }

    @Test
    public void testClickFutureEvent(){
        MainPage mainPage = new MainPage(driver);
        driver.get(MainPage.URL);

        WebElement firstFutureEvent = mainPage.getFutureEvents().get(0);
        String firstEventId = firstFutureEvent.getAttribute("id");

        firstFutureEvent.click();

        Assert.assertEquals(MainPage.URL + "/" + firstEventId, driver.getCurrentUrl());
    }

    @Test
    public void testClickArchiveEvent(){
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);

        WebElement firstArchiveEvent = mainPage.getArchiveEvents().get(0);
        String firstEventId = firstArchiveEvent.getAttribute("id");

        firstArchiveEvent.click();

        Assert.assertEquals(MainPage.URL + "/" + firstEventId, driver.getCurrentUrl());
    }
}