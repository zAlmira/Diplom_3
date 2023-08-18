import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import site.nomoreparties.stellarburgers.api.client.CreateUserClient;
import site.nomoreparties.stellarburgers.api.client.DeleteUserClient;
import site.nomoreparties.stellarburgers.api.client.LoginClient;
import site.nomoreparties.stellarburgers.api.model.CreateUserModel;
import site.nomoreparties.stellarburgers.api.model.LoginModel;
import site.nomoreparties.stellarburgers.api.model.LoginResponseModel;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected final String EMAIL = "almoon@almoon.ru";
    protected final String PASSWORD = "almoonpassword";
    protected final String NAME = "almoon";
    protected final String INCORRECT_PASSWORD = "almoo";
    WebDriver driver;
    ChromeOptions options;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        /*options = new ChromeOptions();
        options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);*/
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    protected void createUser() {
        CreateUserClient createUserClient = new CreateUserClient();
        createUserClient.doCreateUser(new CreateUserModel(EMAIL, PASSWORD, NAME));
    }

    protected void deleteUser(String email, String password) {
        LoginClient loginClient = new LoginClient();
        Response loginResponse = loginClient.doLogin(new LoginModel(email, password));
        LoginResponseModel loginResponseModel = loginResponse.body().as(LoginResponseModel.class);
        if (loginResponseModel.getSuccess().equals("true")) {
            DeleteUserClient deleteUserClient = new DeleteUserClient();
            deleteUserClient.doDeleteUser(loginResponseModel.getAccessTokenWithoutBearer(loginResponseModel.getAccessToken()));
        }
    }

    @After
    public void closeDriver() {
        deleteUser(EMAIL, PASSWORD);
        driver.quit();
    }
}
