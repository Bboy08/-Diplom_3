package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage {

    // URL формы восстановления пароля
    private static final String RESTORE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    // Ссылка на страницу входа
    private static final By LOGIN_BUTTON = By.linkText("Войти");

    private WebDriver driver;

    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открыть страницу восстановления пароля")
    public void openRestoreUrl() {
        driver.get(RESTORE_URL);
    }
    @Step("Кликнуть на кнопку Войти")
    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }
}
