import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProfileTest extends BaseTest {
    @Test
    public void сheckTransitionOnProfileByClick() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        String accessToken = userApiClient.createUser(createUserRequest).body().jsonPath().getString("accessToken");
        mainPage.openPage();
        mainPage.clickButtonPersonalAccount();
        loginPage.loginFields(createUserRequest.getEmail(), createUserRequest.getPassword());
        loginPage.clickLoginButton();
        mainPage.clickButtonPersonalAccount();
        assertTrue(profilePage.logoutButtonIsDisplayed());
        userApiClient.deleteUser(accessToken.substring(7));
    }

    @Test
    public void сheckTransitionFromProfileToConstructorByConstructor() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        String accessToken = userApiClient.createUser(createUserRequest).body().jsonPath().getString("accessToken");
        loginPage.openLoginUrl();
        loginPage.loginFields(createUserRequest.getEmail(), createUserRequest.getPassword());
        loginPage.clickLoginButton();
        mainPage.clickButtonPersonalAccount();
        mainPage.clickConstructorButton();
        assertTrue(mainPage.constructorIsDisplayed());
        userApiClient.deleteUser(accessToken.substring(7));
    }

    @Test
    public void сheckTransitionFromProfileToConstructorByLogo() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        String accessToken = userApiClient.createUser(createUserRequest).body().jsonPath().getString("accessToken");
        loginPage.openLoginUrl();
        loginPage.loginFields(createUserRequest.getEmail(), createUserRequest.getPassword());
        loginPage.clickLoginButton();
        mainPage.clickButtonPersonalAccount();
        mainPage.clickLogoButton();
        assertTrue(mainPage.constructorIsDisplayed());
        userApiClient.deleteUser(accessToken.substring(7));
    }

    @Test
    public void сheckLogoutFromAccount() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        String accessToken = userApiClient.createUser(createUserRequest).body().jsonPath().getString("accessToken");
        loginPage.openLoginUrl();
        loginPage.loginFields(createUserRequest.getEmail(), createUserRequest.getPassword());
        loginPage.clickLoginButton();
        mainPage.clickButtonPersonalAccount();
        profilePage.clickLogoutButton();
        assertEquals(loginPage.loginUrlIsDisplayed(), "https://stellarburgers.nomoreparties.site/login");
        userApiClient.deleteUser(accessToken.substring(7));
    }
}
