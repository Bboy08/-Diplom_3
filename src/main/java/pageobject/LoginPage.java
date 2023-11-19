package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    // URL логина
    private static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";

    // Кнопка "Войти" на странице входа
    private static final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");

    // Кнопка/Ссылка на страницу регистрации
    private static final By REGISTER = By.linkText("Зарегистрироваться");


    // Поле "Email"
    private static final By EMAIL = By.xpath(".//input[@name='name']");

    // Поле "Пароль"
    private static final By PASSWORD = By.xpath(".//input[@name='Пароль']");
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу логирования")
    public void openLoginUrl() {
        driver.get(LOGIN_URL);
    }
    @Step("Кликнуть на ссылку страницы регистрации")
    public void clickRegisterLink() {
        driver.findElement(REGISTER).click();
    }

    @Step("Кнопка 'Войти' на странице логина отображается")
    public boolean loginButtonIsDisplayed() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }
    @Step("Ввести email")
    public void inputEmail(String EMAIL1) {
        WebElement name = driver.findElement(EMAIL);
        name.clear();
        name.sendKeys(EMAIL1);
    }
    @Step("Кликнуть на кнопку Войти ")
    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }
    @Step("Ввести пароль")
    public void inputPassword(String PASSWORD1) {
        WebElement name = driver.findElement(PASSWORD);
        name.clear();
        name.sendKeys(PASSWORD1);
    }
    @Step("Заполнить поля email и password")
    public void loginFields(String EMAIL, String PASSWORD) {
        inputEmail(EMAIL);
        inputPassword(PASSWORD);

    }

    public String loginUrlIsDisplayed() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.urlToBe(LOGIN_URL));
        return driver.getCurrentUrl();
    }

}
