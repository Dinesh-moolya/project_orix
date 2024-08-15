package context;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import pages.*;
import utilities.ConfigLoader;
import utilities.CredsLoader;
import java.util.Map;

public class TestContext {
    public WebDriver driver;
    public CredsLoader credsLoader;
    public ConfigLoader configLoader;
    public Scenario scenario;
    public Map testData;
    public HomePage homePage;
    public SignUpPage signUpPage;
    public SignInPage signInPage;
    public UserHomePage userHomePage;
    public CarsPage carsPage;

    public BookSummaryPage bookSummaryPage;
    public CustomerinfoPage customerinfoPage;
    public CheckoutPage checkoutPage;
    public FleetsPage fleetsPage;
    public MyProfilePage myProfilePage;
    public BookingDetailsPage bookingDetailsPage;
}
