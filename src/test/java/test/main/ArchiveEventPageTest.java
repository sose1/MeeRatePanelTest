package test.main;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.main.EventPage;
import page.main.MainPage;
import test.FunctionalTest;

import java.util.ArrayList;

public class ArchiveEventPageTest extends FunctionalTest {
    private static String eventId;

    @BeforeClass
    public static void setUpEventTests(){
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);
        eventId = mainPage.clickFirstArchiveEvent();
    }

    @Test
    public void testClickInformationTab(){
        EventPage eventPage = new EventPage(driver, eventId);
        driver.get(eventPage.URL);

        //przełączenia na kartę informacje
        wait.until(ExpectedConditions.visibilityOf(eventPage.getInformationTabButton()));
        eventPage.clickInformationTabButton();

        Assert.assertTrue(eventPage.getInformationWindow().isDisplayed());
    }

    @Test
    public void testClickMap(){
        EventPage eventPage = new EventPage(driver, eventId);
        driver.get(eventPage.URL);

        //przełączenia na kartę informacje
        wait.until(ExpectedConditions.visibilityOf(eventPage.getInformationTabButton()));
        eventPage.clickInformationTabButton();

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

        WebElement resultWindow = eventPage.getRessultsWindow();

        wait.until(ExpectedConditions.visibilityOf(resultWindow.findElement(By.id("speakers"))));
        Assert.assertTrue(resultWindow.findElement(By.id("speakers")).isDisplayed());

        wait.until(ExpectedConditions.visibilityOf(resultWindow.findElement(By.id("SpeakersSummary"))));
        Assert.assertTrue(resultWindow.findElement(By.id("SpeakersSummary")).isDisplayed());

        wait.until(ExpectedConditions.visibilityOf(resultWindow.findElement(By.id("eventSummary"))));
        Assert.assertTrue(resultWindow.findElement(By.id("eventSummary")).isDisplayed());

        //przełączenia na kartę informacje
        wait.until(ExpectedConditions.visibilityOf(eventPage.getInformationTabButton()));
        eventPage.clickInformationTabButton();

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