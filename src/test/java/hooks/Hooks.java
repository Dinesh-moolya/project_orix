package hooks;

import context.TestContext;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pages.*;
import utilities.ConfigLoader;
import utilities.CredsLoader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Hooks {
    private WebDriver driver;
    private final TestContext context;
    private static Map<String, String> testData;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setUp(Scenario scenario) {
        driver = DriverFactory.initializeDriver();
        context.driver = driver;
        context.credsLoader = new CredsLoader();
        context.configLoader = new ConfigLoader();
        context.scenario = scenario;
        context.testData = new HashMap<>();
        context.homePage = new HomePage(context.driver);
        context.signUpPage = new SignUpPage(context.driver);
        context.signInPage = new SignInPage(context.driver);
        context.userHomePage = new UserHomePage(context.driver);
        context.carsPage = new CarsPage(context.driver);
        context.bookSummaryPage = new BookSummaryPage(context.driver);
        context.customerinfoPage = new CustomerinfoPage(context.driver);
        context.checkoutPage = new CheckoutPage(context.driver);
        context.fleetsPage = new FleetsPage(context.driver);
        context.myProfilePage = new MyProfilePage(context.driver);
        context.bookingDetailsPage = new BookingDetailsPage(context.driver);
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        // Take screenshot if the scenario failed
        if (scenario.isFailed()) {
            File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image");
        }

        if (driver != null) {
        }
         driver.quit();
    }

}
