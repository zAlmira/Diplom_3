package site.nomoreparties.stellarburgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageAfterLogin {
    private final By makeOrderButton = By.xpath(".//div[@class = 'BurgerConstructor_basket__container__2fUl3 mt-10']/button");
    private final By breadControl = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Булки']");
    private final By souceControl = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Соусы']");
    private final By fillingControl = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3][@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text() = 'Начинки']");
    private final By ingredientLabel = By.xpath("//*[@id=\"root\"]/div/main/section[1]/div[1]/div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span");
    private final WebDriver driver;

    public MainPageAfterLogin(WebDriver driver) {
        this.driver = driver;
    }

    public void breadControlClick() {
        driver.findElement(breadControl).click();
    }

    public void souceControlClick() {
        driver.findElement(souceControl).click();

    }

    public void fillingControlClick() {
        driver.findElement(fillingControl).click();
    }

    public String ingredientLabelGetText() {
        String ingredientLabelText = driver.findElement(ingredientLabel).getText();
        return ingredientLabelText;
    }

    public boolean isMakeOrderButtonDisplayed() {
        return driver.findElement(makeOrderButton).isDisplayed();
    }

    public void makeOrderButtonDownload() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(makeOrderButton)));
    }

}
