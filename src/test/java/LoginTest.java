import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;
import pageobject.RestorePasswordPage;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkLoginThroughLoginToAccountButtonOnMainPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        String accessToken = userApiClient.createUser(createUserRequest).body().jsonPath().getString("accessToken");
        mainPage.openPage();
        mainPage.clickButtonLoginToAccount();
        loginPage.loginFields(createUserRequest.getEmail(), createUserRequest.getPassword());
        loginPage.clickLoginButton();
        assertTrue(mainPage.loginSuccessful());
        userApiClient.deleteUser(accessToken.substring(7));
    }

    @Test
    public void checkLoginThroughPersonalAccountButtonOnMainPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        String accessToken = userApiClient.createUser(createUserRequest).body().jsonPath().getString("accessToken");
        mainPage.openPage();
        mainPage.clickButtonPersonalAccount();
        loginPage.loginFields(createUserRequest.getEmail(), createUserRequest.getPassword());
        loginPage.clickLoginButton();
        assertTrue(mainPage.loginSuccessful());
        userApiClient.deleteUser(accessToken.substring(7));
    }

    @Test
    public void checkLoginThroughRegistrationFormButton() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        String accessToken = userApiClient.createUser(createUserRequest).body().jsonPath().getString("accessToken");
        registerPage.openRegisterUrl();
        registerPage.clickLoginButton();
        loginPage.loginFields(createUserRequest.getEmail(), createUserRequest.getPassword());
        loginPage.clickLoginButton();
        assertTrue(mainPage.loginSuccessful());
        userApiClient.deleteUser(accessToken.substring(7));
    }

    @Test
    public void checkLoginThroughRestoreFormButton() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RestorePasswordPage restorePasswordPage = new RestorePasswordPage(driver);
        String accessToken = userApiClient.createUser(createUserRequest).body().jsonPath().getString("accessToken");
        restorePasswordPage.openRestoreUrl();
        restorePasswordPage.clickLoginButton();
        loginPage.loginFields(createUserRequest.getEmail(), createUserRequest.getPassword());
        loginPage.clickLoginButton();
        assertTrue(mainPage.loginSuccessful());
        userApiClient.deleteUser(accessToken.substring(7));
    }
}
