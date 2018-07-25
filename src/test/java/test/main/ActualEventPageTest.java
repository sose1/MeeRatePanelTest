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
import java.util.List;

public class ActualEventPageTest extends FunctionalTest {
    private static String eventId;

    @BeforeClass
    public static void setUpEventTests(){
        driver.get(MainPage.URL);
        MainPage mainPage = new MainPage(driver);
        eventId = mainPage.clickFirstActualEvent();
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
    public void testBackButton(){
        EventPage eventPage = new EventPage(driver, eventId);
        driver.get(eventPage.URL);

        eventPage.getBackButton().click();

        Assert.assertEquals(MainPage.URL + "/index.html", driver.getCurrentUrl());
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
    public void testRateEvent(){
        EventPage eventPage = new EventPage(driver, eventId);
        driver.get(eventPage.URL);

        eventPage.clickEventRate();

        //submit
        wait.until(ExpectedConditions.visibilityOf(eventPage.getEventRateSection().findElement(By.className("submit"))));
        eventPage.getEventRateSection().findElement(By.className("submit")).click();

        //sprawdzanie flasha
        wait.until(ExpectedConditions.visibilityOf(eventPage.getHappyPrompt()));
        Assert.assertEquals("Dziękujemy!", eventPage.getHappyPrompt().getText());
    }

    @Test
    public void testRateEventWithHtml(){
        EventPage eventPage = new EventPage(driver, eventId);
        driver.get(eventPage.URL);

        eventPage.clickEventRate();

        //wpisanie htmla
        eventPage.getEventRateSection().findElement(By.tagName("textarea")).sendKeys("<div>");
        eventPage.getEventRateSection().findElement(By.className("submit")).click();

        //sprawdzanie flasha
        wait.until(ExpectedConditions.visibilityOf(eventPage.getBlasePrompt()));
        Assert.assertEquals("Błąd serwera!", eventPage.getBlasePrompt().getText());
    }

    @Test
    public void testRateEventWithoutSelecting(){
        EventPage eventPage = new EventPage(driver, eventId);
        driver.get(eventPage.URL);

        eventPage.getEventRateSection().findElement(By.className("submit")).click();

        //sprawdzanie flasha
        wait.until(ExpectedConditions.visibilityOf(eventPage.getSadPrompt()));
        Assert.assertEquals("Musisz wystawić ocenę.", eventPage.getSadPrompt().getText());
    }

    @Test
    public void testClickRateFirstTalk(){
        EventPage eventPage = new EventPage(driver, eventId);
        driver.get(eventPage.URL);

        WebElement talk = eventPage.getTalk(0);

        List<WebElement> barButtons = talk.findElement(By.className("bar")).findElements(By.tagName("button"));

        //sprawdzanie czy sekcja oceny się wyświetla
        barButtons.get(0).click();
        Assert.assertTrue(eventPage.getFeedBackOpinionSection().isDisplayed());
    }

    @Test
    public void testRateFirstTalkWithHtml(){
        EventPage eventPage = new EventPage(driver, eventId);
        driver.get(eventPage.URL);

        WebElement talk = eventPage.getTalk(0);

        List<WebElement> barButtons = talk.findElement(By.className("bar")).findElements(By.tagName("button"));

        //opcja OCEŃ
        barButtons.get(0).click();
        Assert.assertTrue(eventPage.getFeedBackOpinionSection().isDisplayed());

        //ocena
        talk.findElement(By.className("RateRadio")).findElements(By.tagName("label")).get(0).click();
        talk.findElement(By.tagName("textarea")).sendKeys("<div>");

        //submit
        wait.until(ExpectedConditions.visibilityOf(eventPage.getTalkRateSection().findElement(By.className("submit"))));
        eventPage.getTalkRateSection().findElement(By.className("submit")).click();

        //sprawdzanie flasha
        wait.until(ExpectedConditions.visibilityOf(eventPage.getBlasePrompt()));
        Assert.assertEquals("Błąd serwera!", eventPage.getBlasePrompt().getText());
    }

    @Test
    public void testRateFirstTalkWithoutSelecting(){
        EventPage eventPage = new EventPage(driver, eventId);
        driver.get(eventPage.URL);

        WebElement talk = eventPage.getTalk(0);

        List<WebElement> barButtons = talk.findElement(By.className("bar")).findElements(By.tagName("button"));

        barButtons.get(0).click();
        Assert.assertTrue(eventPage.getFeedBackOpinionSection().isDisplayed());

        //submit
        wait.until(ExpectedConditions.visibilityOf(eventPage.getTalkRateSection().findElement(By.className("submit"))));
        eventPage.getTalkRateSection().findElement(By.className("submit")).click();

        //sprawdzanie flasha
        wait.until(ExpectedConditions.visibilityOf(eventPage.getSadPrompt()));
        Assert.assertEquals("Musisz wybrać ocenę.", eventPage.getSadPrompt().getText());
    }

    @Test
    public void testRateFirstTalk(){
        EventPage eventPage = new EventPage(driver, eventId);
        driver.get(eventPage.URL);

        WebElement talk = eventPage.getTalk(0);

        List<WebElement> barButtons = talk.findElement(By.className("bar")).findElements(By.tagName("button"));

        barButtons.get(0).click();
        Assert.assertTrue(eventPage.getFeedBackOpinionSection().isDisplayed());

        //ocena

        talk.findElement(By.className("RateRadio")).findElements(By.tagName("label")).get(0).click();

        wait.until(ExpectedConditions.visibilityOf(eventPage.getTalkRateSection().findElement(By.className("submit"))));
        eventPage.getTalkRateSection().findElement(By.className("submit")).click();

        //sprawdzanie flasha
        wait.until(ExpectedConditions.visibilityOf(eventPage.getHappyPrompt()));
        Assert.assertEquals("Dziękujemy!", eventPage.getHappyPrompt().getText());
    }

    @Test
    public void testSendEmptyQuestion(){
        EventPage eventPage = new EventPage(driver, eventId);
        driver.get(eventPage.URL);

        WebElement talk = eventPage.getTalk(0);

        List<WebElement> barButtons = talk.findElement(By.className("bar")).findElements(By.tagName("button"));

        //opcja PYTANIE
        barButtons.get(1).click();
        Assert.assertTrue(eventPage.getAskQuestionSection().isDisplayed());

        wait.until(ExpectedConditions.visibilityOf(eventPage.getAskQuestionSection().findElement(By.className("submit"))));
        eventPage.getAskQuestionSection().findElement(By.className("submit")).click();

        //sprawdzanie flasha
        wait.until(ExpectedConditions.visibilityOf(eventPage.getSadPrompt()));
        Assert.assertEquals("Uzupełnij pole tekstowe.", eventPage.getSadPrompt().getText());
    }

    @Test
    public void testSendQuestion(){
        EventPage eventPage = new EventPage(driver, eventId);
        driver.get(eventPage.URL);

        //wybranie prelekcji
        WebElement talk = eventPage.getTalk(0);
        List<WebElement> barButtons = talk.findElement(By.className("bar")).findElements(By.tagName("button"));

        //opcja PYTANIE
        barButtons.get(1).click();
        Assert.assertTrue(eventPage.getAskQuestionSection().isDisplayed());

        //wpisanie pytania
        eventPage.getAskQuestionSection().findElement(By.tagName("textarea")).sendKeys("Pytanie? wiem czy nie wiem? a może wiem?");

        //submit
        wait.until(ExpectedConditions.visibilityOf(eventPage.getAskQuestionSection().findElement(By.className("submit"))));
        eventPage.getAskQuestionSection().findElement(By.className("submit")).click();

        //sprawdzanie flasha
        wait.until(ExpectedConditions.visibilityOf(eventPage.getHappyPrompt()));
        Assert.assertEquals("Dziękujemy!", eventPage.getHappyPrompt().getText());
    }

    @Test
    public void testTalkHideButton(){
        EventPage eventPage = new EventPage(driver, eventId);
        driver.get(eventPage.URL);

        //wybranie prelekcji
        WebElement talk = eventPage.getTalk(0);
        List<WebElement> barButtons = talk.findElement(By.className("bar")).findElements(By.tagName("button"));

        //opcja PYTANIE
        barButtons.get(1).click();
        Assert.assertTrue(eventPage.getAskQuestionSection().isDisplayed());

        //kliknięcie schowaj
        wait.until(ExpectedConditions.visibilityOf(eventPage.getTalkMoreSection().findElement(By.xpath("//button[text()='Schowaj']"))));
        eventPage.getTalkMoreSection().findElement(By.xpath("//button[text()='Schowaj']")).click();

        WebElement bar = talk.findElement(By.className("bar"));
        wait.until(ExpectedConditions.visibilityOf(bar));
        Assert.assertTrue(bar.isDisplayed());
    }

    @Test
    public void testProperPageLoad(){
        EventPage eventPage = new EventPage(driver, eventId);
        driver.get(eventPage.URL);

        WebElement resultWindow = eventPage.getRessultsWindow();

        wait.until(ExpectedConditions.visibilityOf(resultWindow.findElement(By.id("speakersRate"))));
        Assert.assertTrue(resultWindow.findElement(By.id("speakersRate")).isDisplayed());

        wait.until(ExpectedConditions.visibilityOf(resultWindow.findElement(By.id("eventRate"))));
        Assert.assertTrue(resultWindow.findElement(By.id("eventRate")).isDisplayed());

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