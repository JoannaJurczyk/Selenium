package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItJobsPage {
    WebDriver driver;
    String url = "";

    By remoteJobs = By.xpath("//*[text()='Praca zdalna']");
    By arrow = By.xpath("//*[contains(@class, 'chips__image-box chips__image-box--arrow')]");
    By seleniumOnList = By.xpath("//li//*[text()='Selenium']");
    By jobOffers = By.xpath("//*[contains(@class, 'offers-listing')]/div");

    public ItJobsPage(WebDriver givenDriver)
    {
        driver = givenDriver;
    }

    public void clickOnRemoteJobs()
    {
        driver.findElement(remoteJobs).click();

    }

    public void selectSelenium()
    {
        driver.findElement(arrow).click();
        driver.findElement(seleniumOnList).click();
    }

    public int getJobOffersCount()
    {
        return driver.findElements(jobOffers).size();
    }
}


