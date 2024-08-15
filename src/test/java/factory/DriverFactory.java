package factory;

import constants.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver initializeDriver() {
        WebDriver driver;
        String browser = System.getProperty("browser", String.valueOf(Browser.CHROME));

        switch (Browser.valueOf(browser.toUpperCase())) {
            case CHROME -> {
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_setting_values.notifications", 1);
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.setExperimentalOption("prefs", prefs);
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("screen-resolution", "800x600");
                chromeOptions.setExperimentalOption("prefs",
                        Collections.singletonMap("autofill.credit_card_enabled", false));
                chromeOptions.addArguments("--incognito");
//                chromeOptions.addArguments("--headless");
//                if (System.getProperty("browserMode", "normal").equalsIgnoreCase("headless")) {
//                    chromeOptions.addArguments("--headless");
//                    chromeOptions.addArguments("window-size=1920,1080");
//                }
//                if (System.getProperty("debugMode", "false").equalsIgnoreCase("true"))
//                    chromeOptions.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
                driver = new ChromeDriver(chromeOptions);

            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (System.getProperty("browserMode", "normal").equalsIgnoreCase("headless")) {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
            }
            default -> throw new RuntimeException("Invalid Browser: " + browser);
        }
        driver.manage().window().maximize();
        return driver;
    }
}
