package uitests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ItJobsPage;
import pages.LoginPage;
import pages.MainPage;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;

public class PracujTest {
    WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;
    ItJobsPage itJobsPage;

    @Before
    public void setUp()
    {
        //System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get("https://pracuj.pl");
        // Create pages
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        itJobsPage = new ItJobsPage(driver);
    }
    @Test
    public void checkPracujTitle()
    {
        String title = driver.getTitle();
        assertThat(title).isEqualTo("Praca - Pracuj.pl");
    }
    @Test
    public void checkLoginActionNegative()
    {
        By loginLink = By.xpath("//*[@data-test='section-desktopLayout']//a[@data-test='anchor-login']");
        driver.findElement(loginLink).click();
        By emailInput = By.xpath("//input[@data-test='input-email']");
        // WebDriverWait wait = new WebDriverWait(driver, 10);
        // WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        driver.findElement(emailInput).sendKeys("JanKowalski12345@gmail.com");
        By passwordInput = By.xpath("//*[@data-test='input-password']");
        driver.findElement(passwordInput).sendKeys("HasloJanaKowalskiego");
        By loginButton = By.xpath("//*[@data-test='button-login']");
        driver.findElement(loginButton).click();
        By alertMessage = By.xpath("//*[@data-test='text-feedback-message']");
        String expectedMessage = "Możliwe, że nie potwierdziłeś swojego konta lub 3 razy użyłeś złego hasła. Sprawdź pocztę lub spróbuj później.";
        String actualMessage = driver.findElement(alertMessage).getText();
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }
    @Test
    public void checkLoginActionNegativePageObject()
    {
        String expectedMessage = "Możliwe, że nie potwierdziłeś swojego konta lub 3 razy użyłeś złego hasła. Sprawdź pocztę lub spróbuj później.";
        mainPage.clickOnLoginLink();
        loginPage.login("test1@test.pl", "test1Password");
        assertThat(loginPage.getAlertText()).isEqualTo(expectedMessage);
    }
    @Test
    public void checkSeleniumRemoteJobs()
    {
        mainPage.clickOnItJobsTab();
        itJobsPage.clickOnRemoteJobs()
                .selectSelenium();
        assertThat(itJobsPage.getJobOffersCount())
                .isGreaterThan(1)
                .isLessThan(5);
    }
    @Test
    public void clickOnMapButton() {
        mainPage.clickOnItJobsTab();
        itJobsPage.clickOnMapButton();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}




