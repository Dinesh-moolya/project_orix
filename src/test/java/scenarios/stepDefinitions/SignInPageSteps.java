package scenarios.stepDefinitions;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BasePage;
import pages.SignInPage;

public class SignInPageSteps {
    private SignInPage signInPage;
    private Scenario scenario;

    public SignInPageSteps(TestContext context) {
        this.signInPage = context.signInPage;
        this.scenario = context.scenario;
    }

    @Then("^User enters the Mobile number \\\"([^\\\"]*)\\\" and click login button$")
    public void userEntersTheMobileNumberAndClickLoginButton(String number) throws InterruptedException {
        signInPage.clickAndSelectCountries("India");
        // Thread.sleep(3000);
        signInPage.enterMobileNumber(number);
        signInPage.clickLoginButton();
        Assert.assertTrue(signInPage.verifyNotification());
        signInPage.closeNotification();
        scenario.log("user entered the mobile number " + number);
    }

    @Then("User enters the Otp {string} and click on validate button")
    public void userEntersTheOtpAndClickOnValidateButton(String otp) {
        signInPage.enterOtp(otp);
        Assert.assertTrue(signInPage.verifyValidateButton());
        signInPage.clickValidateButton();
        scenario.log("user entered the otp " + otp);
    }

}
