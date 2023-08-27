import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.pages.HeaderPage;
import site.nomoreparties.stellarburgers.pages.MainPageAfterLogin;
import site.nomoreparties.stellarburgers.pages.SignInPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TransitionFromProfileToConstructorTest extends BaseTest {
    static WebDriver staticDriver;
    private static HeaderPage headerPage = new HeaderPage(staticDriver);

    private final By toClickElement;

    public TransitionFromProfileToConstructorTest(By toClickElement) {
        this.toClickElement = toClickElement;
    }

    @Parameterized.Parameters(name = "Переход из личного кабинета в конструктор через кнопку: {0}")
    public static Object[][] dataForMakingTest() {
        return new Object[][]{
                {headerPage.getConstructorButton()},
                {headerPage.getStellarBurgersButton()},
        };
    }

    @Before
    public void init() {
        createUser();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.doSignIn(EMAIL, PASSWORD);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.personalAccountButtonClick();
    }

    @Test
    public void transitToConstructorSuccess() {
        driver.findElement(toClickElement).click();
        MainPageAfterLogin mainPageAfterLogin = new MainPageAfterLogin(driver);
        assertTrue(mainPageAfterLogin.isMakeOrderButtonDisplayed());
    }

}
