package test.main;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.main.EventPage;
import page.main.MainPage;
import test.FunctionalTest;

import java.util.ArrayList;

public class FutureEventPageTest extends FunctionalTest {
    private static String eventId;

    @BeforeClass
    public static void setUpEventTests(){
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);
        eventId = mainPage.clickFirstFutureEvent();
    }

    @Test
    public void testClickMap(){
        EventPage eventPage = new EventPage(driver, eventId);
        driver.get(eventPage.URL);

        eventPage.getPlaceSection()
                .findElement(By.className("row"))
                .findElement(By.tagName("p"))
                .findElement(By.tagName("a")).click();

        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        Assert.assertTrue(driver.getTitle().contains("Mapy Google"));
    }

    @Test
    public void testProperPageLoad(){
        EventPage eventPage = new EventPage(driver, eventId);
        driver.get(eventPage.URL);

        wait.until(ExpectedConditions.visibilityOf(eventPage.getAboutSection()));
        Assert.assertTrue(eventPage.getAboutSection().isDisplayed());

        wait.until(ExpectedConditions.visibilityOf(eventPage.getDateSection()));
        Assert.assertTrue(eventPage.getDateSection().isDisplayed());

        wait.until(ExpectedConditions.visibilityOf(eventPage.getPlaceSection()));
        Assert.assertTrue(eventPage.getPlaceSection().isDisplayed());

        wait.until(ExpectedConditions.visibilityOf(eventPage.getAgendaSection()));
        Assert.assertTrue(eventPage.getAgendaSection().isDisplayed());
    }
}