package site.nomoreparties.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrivateAccountPage {


    private final By profileHref = By.xpath(".//a[text() = 'Профиль']");
    private final By loginOutButton = By.xpath("//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button");
    WebDriver driver;

    public PrivateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProfileHrefDisplayed() {
        return driver.findElement(profileHref).isDisplayed();
    }

    public void loginOutButtonClick() {
        driver.findElement(loginOutButton).click();
    }

}
