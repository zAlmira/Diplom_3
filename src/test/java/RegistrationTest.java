import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.RegistrationPage;
import site.nomoreparties.stellarburgers.pages.SignInPage;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    @Before
    public void init() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void registrationSuccessTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        SignInPage signInPage = new SignInPage(driver);
        registrationPage.doRegistration(EMAIL, NAME, PASSWORD);
        assertTrue(signInPage.isSignInLabelDisplayed());
    }

    @Test
    @DisplayName("Вывод ошибки Некорректный пароль при регистрации")
    public void registrationWithIncorrectPasswordTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.doRegistration(EMAIL, NAME, INCORRECT_PASSWORD);
        assertTrue(registrationPage.isPasswordErrorDisplayed());
    }

}
