package site.nomoreparties.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
    private final By personalAccountButton = By.xpath(".//p[text() = 'Личный Кабинет']");
    private final By stellarBurgersButton = By.xpath(".//div[@class = 'AppHeader_header__logo__2D0X2']/a");
    private final By constructorButton = By.xpath(".//nav[@class= 'AppHeader_header__nav__g5hnF']/ul/li[1]/a");
    private WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void personalAccountButtonClick() {
        driver.findElement(personalAccountButton).click();
    }

    public By getStellarBurgersButton() {
        return stellarBurgersButton;
    }

    public By getConstructorButton() {
        return constructorButton;
    }

    public By getPersonalAccountButton() {
        return personalAccountButton;
    }
}
