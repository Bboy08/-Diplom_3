import org.junit.Test;
import pageobject.MainPage;
import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {
    @Test
    public void сheckBunSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickSauceButton();
        mainPage.clickBunButton();
        assertTrue("Кнопка Булки не работает", mainPage.clickBunButtonWorks());
    }

    @Test
    public void сheckSauceSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickSauceButton();
        assertTrue("Кнопка Соусы не работает", mainPage.clickSauceButtonWorks());
    }

    @Test
    public void сheckFillingSection() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.clickFillingButton();
        assertTrue("Кнопка Начинки не работает", mainPage.clickFillingButtonWorks());
    }
}
