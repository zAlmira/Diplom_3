package site.nomoreparties.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final By signInButton = By.xpath(".//button[text() = 'Войти в аккаунт']");
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getSignInButton() {
        return signInButton;
    }

}
