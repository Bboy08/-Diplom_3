import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProfileTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    String accessToken;
    @Before
    public void setup() {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        accessToken = userApiClient.createUser(createUserRequest).body().jsonPath().getString("accessToken");
    }

    @Test
    @DisplayName("Check Transition to Profile by Clicking")
    @Description("переход по клику на «Личный кабинет»")
    public void сheckTransitionOnProfileByClick() {
        ProfilePage profilePage = new ProfilePage(driver);
        mainPage.openPage();
        mainPage.clickButtonPersonalAccount();
        loginPage.loginFields(createUserRequest.getEmail(), createUserRequest.getPassword());
        loginPage.clickLoginButton();
        mainPage.clickButtonPersonalAccount();
        assertTrue(profilePage.logoutButtonIsDisplayed());
    }

    @Test
    @DisplayName("Check Transition from Profile to Constructor by Constructor")
    @Description("переход по клику на «Конструктор»")
    public void сheckTransitionFromProfileToConstructorByConstructor() {
        loginPage.openLoginUrl();
        loginPage.loginFields(createUserRequest.getEmail(), createUserRequest.getPassword());
        loginPage.clickLoginButton();
        mainPage.clickButtonPersonalAccount();
        mainPage.clickConstructorButton();
        assertTrue(mainPage.constructorIsDisplayed());
    }

    @Test
    @DisplayName("Check Transition from Profile to Constructor by Logo")
    @Description("переход по клику на логотип Stellar Burgers")
    public void сheckTransitionFromProfileToConstructorByLogo() {
        loginPage.openLoginUrl();
        loginPage.loginFields(createUserRequest.getEmail(), createUserRequest.getPassword());
        loginPage.clickLoginButton();
        mainPage.clickButtonPersonalAccount();
        mainPage.clickLogoButton();
        assertTrue(mainPage.constructorIsDisplayed());
    }

    @Test
    @DisplayName("Check Logout from Account")
    @Description("выход по кнопке «Выйти» в личном кабинете")
    public void сheckLogoutFromAccount() {
        ProfilePage profilePage = new ProfilePage(driver);
        loginPage.openLoginUrl();
        loginPage.loginFields(createUserRequest.getEmail(), createUserRequest.getPassword());
        loginPage.clickLoginButton();
        mainPage.clickButtonPersonalAccount();
        profilePage.clickLogoutButton();
        assertEquals(loginPage.loginUrlIsDisplayed(), "https://stellarburgers.nomoreparties.site/login");
    }
    @After
    public void cleanUp() {
        userApiClient.deleteUser(accessToken.substring(7));
    }
}
