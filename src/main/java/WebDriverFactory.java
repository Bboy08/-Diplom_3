import api.client.UserApiClient;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    public static WebDriver get(String browserName) {
        switch (browserName) {
            case "chrome":
                return new ChromeDriver();
            case "yandex":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                String path = "src/main/resources/yandexdriver.exe";
                System.setProperty("webdriver.chrome.driver", path);
                return new ChromeDriver(options);
            default:
                throw new RuntimeException("Browser is not detected");
        }
    }

}
