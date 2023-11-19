import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;
import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {
    @Test
    public void checkSuccessfulRegistration() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
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
    public void checkUnsuccessfulRegistration() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.openPage();
        mainPage.clickButtonLoginToAccount();
        loginPage.clickRegisterLink();
        registerPage.registrationFields(createUserRequestWithInvalidPassword.getName(), createUserRequestWithInvalidPassword.getEmail(), createUserRequestWithInvalidPassword.getPassword());
        registerPage.clickRegistrationButton();
        assertTrue(registerPage.invalidPasswordTextIsDisplayed());
    }
}
