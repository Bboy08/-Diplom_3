import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;
import pageobject.RestorePasswordPage;
import static org.junit.Assert.assertTrue;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;

public class LoginTest extends BaseTest {
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
    @DisplayName("Check Login Through 'Login To Account' Button On Main Page")
    @Description("Вход по кнопке «Войти в аккаунт» на главной")
    public void checkLoginThroughLoginToAccountButtonOnMainPage() {
        mainPage.openPage();
        mainPage.clickButtonLoginToAccount();
        loginPage.loginFields(createUserRequest.getEmail(), createUserRequest.getPassword());
        loginPage.clickLoginButton();
        assertTrue(mainPage.loginSuccessful());
    }

    @Test
    @DisplayName("Check Login Through 'Personal Account' Button On Main Page")
    @Description("Вход через кнопку «Личный кабинет»")
    public void checkLoginThroughPersonalAccountButtonOnMainPage() {
        mainPage.openPage();
        mainPage.clickButtonPersonalAccount();
        loginPage.loginFields(createUserRequest.getEmail(), createUserRequest.getPassword());
        loginPage.clickLoginButton();
        assertTrue(mainPage.loginSuccessful());
    }

    @Test
    @DisplayName("Check Login Through Registration Form Button")
    @Description("Вход через кнопку в форме регистрации")
    public void checkLoginThroughRegistrationFormButton() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openRegisterUrl();
        registerPage.clickLoginButton();
        loginPage.loginFields(createUserRequest.getEmail(), createUserRequest.getPassword());
        loginPage.clickLoginButton();
        assertTrue(mainPage.loginSuccessful());
    }

    @Test
    @DisplayName("Check Login Through Restore Form Button")
    @Description("Вход через кнопку в форме восстановления пароля")
    public void checkLoginThroughRestoreFormButton() {
        RestorePasswordPage restorePasswordPage = new RestorePasswordPage(driver);
        restorePasswordPage.openRestoreUrl();
        restorePasswordPage.clickLoginButton();
        loginPage.loginFields(createUserRequest.getEmail(), createUserRequest.getPassword());
        loginPage.clickLoginButton();
        assertTrue(mainPage.loginSuccessful());
    }

    @After
    public void cleanUp() {
        userApiClient.deleteUser(accessToken.substring(7));
    }
}
