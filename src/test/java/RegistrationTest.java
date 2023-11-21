import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {
    MainPage mainPage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @Before
    public void setup() {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Test
    @DisplayName("Check Successful Registration")
    @Description("проверка успешной регистрации")
    public void checkSuccessfulRegistration() {
        mainPage.openPage();
        mainPage.clickButtonLoginToAccount();
        loginPage.clickRegisterLink();
        registerPage.registrationFields(createUserRequest.getName(), createUserRequest.getEmail(), createUserRequest.getPassword());
        registerPage.clickRegistrationButton();
        assertTrue(loginPage.loginButtonIsDisplayed());
        String accessToken = userApiClient.loginUser(createUserRequest).body().jsonPath().getString("accessToken");
        userApiClient.deleteUser(accessToken.substring(7));
    }

    @Test
    @DisplayName("Check Unsuccessful Registration")
    @Description("проверка ошибки для некорректного пароля. Если ошибка не отображается, то скорее всего создался юзер и его надо удалить")
    public void checkUnsuccessfulRegistration() {
        boolean exceptionOccurred = false;
        try {
            mainPage.openPage();
            mainPage.clickButtonLoginToAccount();
            loginPage.clickRegisterLink();
            registerPage.registrationFields(createUserRequestWithInvalidPassword.getName(), createUserRequestWithInvalidPassword.getEmail(), createUserRequestWithInvalidPassword.getPassword());
            registerPage.clickRegistrationButton();
            assertTrue(registerPage.invalidPasswordTextIsDisplayed());
        } catch (Exception e) {
            exceptionOccurred = true;
            e.printStackTrace();
            Assert.fail("Тест завершился с ошибкой: " + e.getMessage());
        } finally {
            // Проверяем, возникло ли исключение, прежде чем удалять пользователя
            if (exceptionOccurred) {
                String accessToken = userApiClient.loginUser(createUserRequest).body().jsonPath().getString("accessToken");
                userApiClient.deleteUser(accessToken.substring(7));
            }
        }
    }
}
