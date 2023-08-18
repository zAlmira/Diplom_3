package site.nomoreparties.stellarburgers.pages;

import org.openqa.selenium.By;

public class ForgotPasswordPage {
    private final By signInButton = By.xpath(".//a[@href = '/login' and text() = 'Войти']");

    public By getSignInButton() {
        return signInButton;
    }
}
