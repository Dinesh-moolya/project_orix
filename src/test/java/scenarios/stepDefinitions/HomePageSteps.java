package scenarios.stepDefinitions;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;

public class HomePageSteps {
    private HomePage homePage;
    private Scenario scenario;

    public HomePageSteps(TestContext context) {
        this.homePage = context.homePage;
        this.scenario = context.scenario;
    }

    @Given("User enters the url and lands in the Home page")
    public void userEntersTheUrlAndLandsInTheHomePage() throws InterruptedException {
        homePage.enterUrl();
        Assert.assertTrue(homePage.verifyHomePageUrl());
        scenario.log("User successfully navigate to Home Page");
    }

    @When("User click on Login or Signup button")
    public void userClickOnLoginOrSignupButton() {
        Assert.assertTrue(homePage.verifyLoginOrSignupButton());
        homePage.clickLoginOrSignupButton();
        Assert.assertTrue(homePage.verifySignUpUrl());
        scenario.log("User successfully navigate to SignUp Page");
    }

}
