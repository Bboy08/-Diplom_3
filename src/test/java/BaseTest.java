import api.client.UserApiClient;
import api.model.CreateUserRequest;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import static api.helper.UserGenerator.getRandomUser;
import static api.helper.UserGenerator.getRandomUserWithInvalidPass;

public class BaseTest {
    public WebDriver driver;
    CreateUserRequest createUserRequest;
    CreateUserRequest createUserRequestWithInvalidPassword;
    UserApiClient userApiClient;


    @Before
    public void before() {
        String browserName = System.getProperty("browserName");
        driver = WebDriverFactory.get(browserName);
        createUserRequest = getRandomUser();
        createUserRequestWithInvalidPassword = getRandomUserWithInvalidPass();
        userApiClient = new UserApiClient();
    }


    @After
    public void after() {
        driver.quit();
    }

}
