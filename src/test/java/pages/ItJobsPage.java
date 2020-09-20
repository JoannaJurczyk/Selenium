package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.function.Function;


public class ItJobsPage extends BasePage {
    String url = "";
    By remoteJobs = By.xpath("//*[text()='Praca zdalna']");
    By arrow = By.xpath("//*[contains(@class, 'chips__image-box chips__image-box--arrow')]");
    By seleniumOnList = By.xpath("//li//*[text()='Selenium']");
    By jobOffers = By.xpath("//*[contains(@class, 'offers-listing')]/div");
    By scrollUpArrow = By.cssSelector("div[class~=scroll-up]");
    By mapButton = By.cssSelector("div[class~=listing__change-button--map]");
    By map = By.cssSelector("div[class~=map]");
    public ItJobsPage(WebDriver givenDriver)
    {
        driver = givenDriver;
    }
    public ItJobsPage clickOnMapButton() {
        WebElement element = verifyElementPresent(mapButton);
        element.click();
        //driver.findElement(mapButton).click();
        verifyElementPresentFluentWait(map);
        return this;
    }
    public ItJobsPage clickOnRemoteJobs()
    {
        verifyElementNotPresent(scrollUpArrow);
        driver.findElement(remoteJobs).click();
        return this;
    }
    public ItJobsPage selectSelenium()
    {
        driver.findElement(arrow).click();
        driver.findElement(seleniumOnList).click();
        return this;
    }
    public int getJobOffersCount()
    {
        return driver.findElements(jobOffers).size();
    }
}


