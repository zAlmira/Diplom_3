package site.nomoreparties.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private final By signInLabel = By.xpath("html/body/div/div/main/div/h2");
    private final By emailInput = By.xpath(".//input[@name = 'name']");
    private final By passwordInput = By.xpath(".//input[@name = 'Пароль']");
    private final By signInButton = By.xpath(".//button[text() = 'Войти']");
    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isSignInLabelDisplayed() {
        return driver.findElement(signInLabel).isDisplayed();
    }

    public void doSignIn(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(signInButton).click();
    }
}
