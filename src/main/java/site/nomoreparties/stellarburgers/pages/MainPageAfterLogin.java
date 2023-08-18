package site.nomoreparties.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageAfterLogin {
    private final By makeOrderButton = By.xpath(".//div[@class = 'BurgerConstructor_basket__container__2fUl3 mt-10']/button");
    private final By breadControl = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]");
    private final By souceControl = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]/span");
    private final By fillingControl = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]/span");
    private final By breadLabel = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[1]");
    private final By souseLabel = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[2]");
    private final By fillingLabel = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[2]/h2[3]");
    private WebDriver driver;

    public MainPageAfterLogin(WebDriver driver) {
        this.driver = driver;
    }

    public By getBreadControl() {
        return breadControl;
    }

    public By getSouceControl() {
        return souceControl;
    }

    public By getFillingControl() {
        return fillingControl;
    }

    public By getBreadLabel() {
        return breadLabel;
    }

    public By getSouseLabel() {
        return souseLabel;
    }

    public By getFillingLabel() {
        return fillingLabel;
    }

    public boolean isMakeOrderButtonDisplayed() {
        return driver.findElement(makeOrderButton).isDisplayed();
    }

    public void makeOrderButtonDownload() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(makeOrderButton)));
    }
}
