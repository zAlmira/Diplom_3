package site.nomoreparties.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final By nameInput = By.xpath(".//form/fieldset[1]/div/div/input");
    private final By emailInput = By.xpath(".//form/fieldset[2]/div/div/input");
    private final By passwordInput = By.xpath(".//form/fieldset[3]/div/div/input");
    private final By signUpButton = By.xpath(".//button[text() = 'Зарегистрироваться']");
    private final By passwordError = By.xpath(".//p[text() = 'Некорректный пароль']");
    private final By signInButton = By.xpath(".//a[@href = '/login' and text() = 'Войти']");
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getSignInButton() {
        return signInButton;
    }


    public void doRegistration(String name, String email, String password) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(signUpButton).click();
    }

    public boolean isPasswordErrorDisplayed() {
        return driver.findElement(passwordError).isDisplayed();
    }

}
