import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.pages.MainPageAfterLogin;
import site.nomoreparties.stellarburgers.pages.SignInPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ConstructorTest extends BaseTest {
    static WebDriver staticDriver;
    private static MainPageAfterLogin mainPageAfterLogin = new MainPageAfterLogin(staticDriver);
    private final By byFrom;
    private By byTo;

    public ConstructorTest(By byFrom, By byTo) {
        this.byFrom = byFrom;
        this.byTo = byTo;
    }

    @Parameterized.Parameters(name = "Переход к разделу {1} в конструкторе")
    public static Object[][] dataForMakingTest() {
        return new Object[][]{
                {mainPageAfterLogin.getFillingControl(), mainPageAfterLogin.getFillingLabel()},
                {mainPageAfterLogin.getSouceControl(), mainPageAfterLogin.getSouseLabel()},
                {mainPageAfterLogin.getBreadControl(), mainPageAfterLogin.getBreadLabel()},
        };
    }

    @Before
    public void init() {
        createUser();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.doSignIn(EMAIL, PASSWORD);
    }

    @Test
    public void transitionInConstructor() {
        driver.findElement(byFrom).click();
        assertTrue(driver.findElement(byTo).isDisplayed());
    }

}
