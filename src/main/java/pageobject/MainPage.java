package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    // Главная страница приложения
    private static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    // Кнопка "Войти в аккаунт" на главной странице
    private static final By LOGIN_TO_ACCOUNT = By.xpath(".//button[text()='Войти в аккаунт']");

    // Кнопка "Оформить заказ" на главной странице
    private static final By ORDER_BUTTON = By.xpath(".//button[text()='Оформить заказ']");

    // Ссылка/Кнопка на личный кабинет
    private static final By PERSONAL_ACCOUNT_BUTTON = By.linkText("Личный Кабинет");

    private static final By CONSTRUCTOR_HEADER = By.xpath(".//h1[text()='Соберите бургер']");

    // Ссылка на конструктор
    private static final By CONSTRUCTOR_LINK = By.linkText("Конструктор");

    // Ссылка на конструктор
    private static final By LOGO = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    // Кнопка Булки в конструкторе
    private static final By BUN_BUTTON = By.xpath(".//div[@style='display: flex;']/div[1]");


    // Кнопка Соусы в конструкторе
    private static final By SAUCE_BUTTON = By.xpath(".//div[@style='display: flex;']/div[2]");

    // Кнопка Начинки в конструкторе
    private static final By FILLING_BUTTON = By.xpath(".//div[@style='display: flex;']/div[3]");



    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Открыть главную страницу")
    public void openPage() {
        driver.get(PAGE_URL);
    }

    @Step("Кликнуть на 'Войти в аккаунт'")
    public void clickButtonLoginToAccount() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(LOGIN_TO_ACCOUNT));
        driver.findElement(LOGIN_TO_ACCOUNT).click();
    }
    @Step("Кнопка 'Оформить заказ отображается'")
    public boolean loginSuccessful() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(ORDER_BUTTON));
        return driver.findElement(ORDER_BUTTON).isDisplayed();
    }
    @Step("Кликнуть на 'Личный кабинет'")
    public void clickButtonPersonalAccount() {
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
    }
    @Step("Кликнуть на 'Конструктор'")
    public void clickConstructorButton() {
        driver.findElement(CONSTRUCTOR_LINK).click();
    }
    @Step("Кдикнуть на логотип Stellar Burgers")
    public void clickLogoButton() {
        driver.findElement(LOGO).click();
    }
    @Step("Заголовок конструктора отображается")
    public boolean constructorIsDisplayed() {
        return driver.findElement(CONSTRUCTOR_HEADER).isDisplayed();
    }
    @Step("Кликнуть на Булки")
    public void clickBunButton() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(BUN_BUTTON));
        driver.findElement(BUN_BUTTON).click();
    }
    @Step("Кликнуть на Соусы")
    public void clickSauceButton() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(SAUCE_BUTTON));
        driver.findElement(SAUCE_BUTTON).click();
    }
    @Step("Кликнуть на Начинки")
    public void clickFillingButton() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(FILLING_BUTTON));
        driver.findElement(FILLING_BUTTON).click();
    }
    @Step("Переход к разделку Булки работает")
    public boolean clickBunButtonWorks() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.attributeContains(BUN_BUTTON, "class", "current"));
        return driver.findElement(BUN_BUTTON).getAttribute("class").contains("current");
    }
    @Step("Переход к разделку Начинки работает")
    public boolean clickFillingButtonWorks() {
        return driver.findElement(FILLING_BUTTON).getAttribute("class").contains("current");
    }
    @Step("Переход к разделку Соусы работает")
    public boolean clickSauceButtonWorks() {
        return driver.findElement(SAUCE_BUTTON).getAttribute("class").contains("current");
    }

}
