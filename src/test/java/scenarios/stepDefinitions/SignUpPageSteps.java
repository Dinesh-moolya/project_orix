package scenarios.stepDefinitions;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.SignUpPage;

public class SignUpPageSteps {
    private SignUpPage signUpPage;
    private Scenario scenario;

    public SignUpPageSteps(TestContext context) {

        this.signUpPage = context.signUpPage;
        this.scenario = context.scenario;
    }

    @Then("User click on LoginHere button")
    public void userClickOnLoginHereButton() {
        signUpPage.clickLoginHereLink();
        Assert.assertTrue(signUpPage.verifySignInUrl());
        scenario.log("user successfully navigate to signin page");
    }

}
