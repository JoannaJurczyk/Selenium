package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    WebDriver driver;
    String url = "https://login.pracuj.pl/";

    public LoginPage(WebDriver givenDriver){
        driver = givenDriver;
    }

    public void login(String email, String password){
        By emailInput = By.xpath( "//input[@data-test='input-email']");

        driver.findElement(emailInput).sendKeys(email);

        By passwordInput = By.xpath("//input[@data-test='input-password']");
        driver.findElement(passwordInput).sendKeys(password);

        By loginButton= By.xpath("//button[@data-test='button-login']");
        driver.findElement(loginButton).click();
    }

    public String getAllertText(){

        By alertMessage = By.xpath("//*[@data-test='text-feedback-message']");
        return driver.findElement(alertMessage).getText();
    }

}
