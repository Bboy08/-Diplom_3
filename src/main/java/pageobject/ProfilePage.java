package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    // Кнопка "Выход"
    private static final By LOGOUT_BUTTON = By.xpath(".//button[text()='Выход']");

    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Кликнуть на Выход")
    public void clickLogoutButton() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(LOGOUT_BUTTON));
        driver.findElement(LOGOUT_BUTTON).click();
    }
    @Step("Кнопка Выход отображается")
    public boolean logoutButtonIsDisplayed() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(LOGOUT_BUTTON));
        return driver.findElement(LOGOUT_BUTTON).isDisplayed();
    }

}
