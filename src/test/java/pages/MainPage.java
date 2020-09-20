package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {


        String url = "https://login.pracuj.pl/";

        public MainPage(WebDriver givenDriver){
            driver = givenDriver;
        }

        public void clickOnLoginLink(){
            By loginLink = By.xpath("//*[@data-test='section-desktopLayout']//a[@data-test='anchor-login']" );
            driver.findElement(loginLink).click();
        }

        public void clickOnItJobsTab(){
            By itJobsTab = By.xpath("//*[@data-test='section-desktopLayout']//a[@data-test='anchor-codeJobs']");
            driver.findElement(itJobsTab).click();
        }
}



