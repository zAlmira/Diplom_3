import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HeaderPage;
import site.nomoreparties.stellarburgers.pages.PrivateAccountPage;
import site.nomoreparties.stellarburgers.pages.SignInPage;

import static org.junit.Assert.assertTrue;

public class TransitionToProfileTest extends BaseTest {

    @Before
    public void init() {
        createUser();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.doSignIn(EMAIL, PASSWORD);
    }

    @Test
    @DisplayName("Переход в личный кабинет по кнопке Личный кабинет")
    public void transitionToProfileTest() {
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.personalAccountButtonClick();
        PrivateAccountPage privateAccountPage = new PrivateAccountPage(driver);
        assertTrue(privateAccountPage.isProfileHrefDisplayed());
    }

}
