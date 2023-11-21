import org.junit.Before;
import org.junit.Test;
import pageobject.MainPage;
import static org.junit.Assert.assertTrue;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;

public class ConstructorTest extends BaseTest {
    MainPage mainPage;

    @Before
    public void setup() {
        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Check bun section")
    @Description("Проверка перехода к разделу Булки")
    public void сheckBunSection() {
        mainPage.openPage();
        mainPage.clickSauceButton();
        mainPage.clickBunButton();
        assertTrue("Кнопка Булки не работает", mainPage.clickBunButtonWorks());
    }

    @Test
    @DisplayName("Check sauce section")
    @Description("Проверка перехода к разделу Соусы")
    public void сheckSauceSection() {
        mainPage.openPage();
        mainPage.clickSauceButton();
        assertTrue("Кнопка Соусы не работает", mainPage.clickSauceButtonWorks());
    }

    @Test
    @DisplayName("Check filling section")
    @Description("Проверка перехода к разделу Начинки")
    public void сheckFillingSection() {
        mainPage.openPage();
        mainPage.clickFillingButton();
        assertTrue("Кнопка Начинки не работает", mainPage.clickFillingButtonWorks());
    }
}
