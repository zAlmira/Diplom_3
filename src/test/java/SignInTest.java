import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.pages.*;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class SignInTest extends BaseTest {
    static WebDriver staticDriver;
    private static MainPage mainPage = new MainPage(null);
    private static HeaderPage headerPage = new HeaderPage(staticDriver);

    private static ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    private static RegistrationPage registrationPage = new RegistrationPage(staticDriver);
    private final String email;
    private final String password;
    private final String url;
    private final By by;

    public SignInTest(String email, String password, String url, By by) {
        this.email = email;
        this.password = password;
        this.url = url;
        this.by = by;
    }

    @Parameterized.Parameters(name = "Успешная авторизация через кнопку: {3} ")
    public static Object[][] dataForMakingTest() {
        return new Object[][]{
                {"almoon@almoon.ru", "almoonpassword", "", mainPage.getSignInButton()},
                {"almoon@almoon.ru", "almoonpassword", "", headerPage.getPersonalAccountButton()},
                {"almoon@almoon.ru", "almoonpassword", "register", registrationPage.getSignInButton()},
                {"almoon@almoon.ru", "almoonpassword", "forgot-password", forgotPasswordPage.getSignInButton()},
        };
    }

    @Before
    public void init() {
        createUser();
    }

    @Test
    public void signInSuccess() {
        driver.get("https://stellarburgers.nomoreparties.site/" + url);
        driver.findElement(by).click();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.doSignIn(email, password);
        MainPageAfterLogin mainPageAfterLogin = new MainPageAfterLogin(driver);
        mainPageAfterLogin.makeOrderButtonDownload();
        assertTrue(mainPageAfterLogin.isMakeOrderButtonDisplayed());
    }


}
