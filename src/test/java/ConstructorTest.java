import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.MainPageAfterLogin;
import site.nomoreparties.stellarburgers.pages.SignInPage;

import static org.junit.Assert.assertEquals;

public class ConstructorTest extends BaseTest {


    @Before
    public void init() {
        createUser();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.doSignIn(EMAIL, PASSWORD);
    }

    @Test
    @DisplayName("Переход в раздел Начинки в конструкторе")
    public void transitionInConstructorToFillingTest() {
        MainPageAfterLogin mainPageAfterLogin = new MainPageAfterLogin(driver);
        mainPageAfterLogin.fillingControlClick();
        assertEquals("Начинки", mainPageAfterLogin.ingredientLabelGetText());
    }

    @Test
    @DisplayName("Переход в раздел Соусы в конструкторе")
    public void transitionInConstructorToSauceTest() {
        MainPageAfterLogin mainPageAfterLogin = new MainPageAfterLogin(driver);
        mainPageAfterLogin.souceControlClick();
        assertEquals("Соусы", mainPageAfterLogin.ingredientLabelGetText());
    }

    @Test
    @DisplayName("Переход в раздел Булки в конструкторе")
    public void transitionInConstructorToBreadTest() {
        MainPageAfterLogin mainPageAfterLogin = new MainPageAfterLogin(driver);
        mainPageAfterLogin.fillingControlClick();
        mainPageAfterLogin.breadControlClick();
        assertEquals("Булки", mainPageAfterLogin.ingredientLabelGetText());
    }

}
