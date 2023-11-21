package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    // URL формы регистрации
    private static final String REGISTER_URL = "https://stellarburgers.nomoreparties.site/register";

    // Поле "Имя"
    private static final By NAME = By.xpath(".//form/fieldset[1]//input");

    // Поле "Email"
    private static final By EMAIL = By.xpath(".//form/fieldset[2]//input");

    // Поле "Пароль"
    private static final By PASSWORD = By.xpath(".//form/fieldset[3]//input");

    // Кнопка "Зарегистрироваться"
    private static final By REGISTRATION_BUTTON = By.xpath(".//button[text()='Зарегистрироваться']");

    // Текст ошибки "Некорректный парроль"
    private static final By INVALID_PASSWORD = By.xpath(".//p[@class='input__error text_type_main-default']");

    // Ссылка на страницу регистрации
    private static final By LOGIN_BUTTON = By.linkText("Войти");

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openRegisterUrl() {
        driver.get(REGISTER_URL);
    }
    @Step("Заполнить поле Имя")
    public void inputName(String NAME1) {
        WebElement name = driver.findElement(NAME);
        name.clear();
        name.sendKeys(NAME1);
    }
    @Step("Заполнить поле email")
    public void inputEmail(String EMAIL1) {
        WebElement name = driver.findElement(EMAIL);
        name.clear();
        name.sendKeys(EMAIL1);
    }
    @Step("Заполнить поле пароль")
    public void inputPassword(String PASSWORD1) {
        WebElement name = driver.findElement(PASSWORD);
        name.clear();
        name.sendKeys(PASSWORD1);
    }
    @Step("Заполнить поля регистрации")
    public void registrationFields(String NAME, String EMAIL, String PASSWORD) {
        inputName(NAME);
        inputEmail(EMAIL);
        inputPassword(PASSWORD);
    }
    @Step("Кликнуть на кнопку Зарегистрироваться")
    public void clickRegistrationButton() {
        driver.findElement(REGISTRATION_BUTTON).click();
    }
    @Step("Текст ошибки 'Некорректный пароль' отображается")
    public boolean invalidPasswordTextIsDisplayed() {
        return driver.findElement(INVALID_PASSWORD).isDisplayed();
    }
    @Step("Кликнуть на кнопку Войти")
    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }
}
