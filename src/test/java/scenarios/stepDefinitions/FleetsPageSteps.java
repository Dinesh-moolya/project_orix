package scenarios.stepDefinitions;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import org.testng.Assert;
import pages.FleetsPage;
import pages.UserHomePage;

public class FleetsPageSteps {
    private FleetsPage fleetsPage;
    private UserHomePage userHomePage;
    private Scenario scenario;

    public FleetsPageSteps(TestContext context) {
        this.fleetsPage = context.fleetsPage;
        this.userHomePage = context.userHomePage;
        this.scenario = context.scenario;
    }

    @And("User clicks on fleet car")
    public void userClicksOnFleetCar() {
        Assert.assertTrue(fleetsPage.clickViewDetailButton());
    }

    @And("User clicks on location button and selects {string} under popular city section in fleets")
    public void userClicksOnLocationButtonAndSelectsUnderPopularCitySectionInFleets(String city)
            throws InterruptedException {
        userHomePage.clickLocationDropDownButton();
        userHomePage.selectPopularCity(city);
        Thread.sleep(1000);
        Assert.assertTrue(userHomePage.verifyMonthlySelectedCity(city));
        scenario.log("user select the city fleet section Daily rental " +city);
    }

    @And("User clicks on location button and selects {string} under popular city section in Monthly Subcription in fleet")
    public void userClicksOnLocationButtonAndSelectsUnderPopularCitySectionInMonthlySubcriptionInFleet(String city)
            throws InterruptedException {
        userHomePage.clickLocationDropDownButton();
        userHomePage.selectPopularCity(city);
        Assert.assertTrue(userHomePage.verifyMonthlySelectedCity(city));
        Thread.sleep(1000);
        userHomePage.clickPickUpDropDown();
        scenario.log("user select the city fleet section Daily rental " +city);
    }

}
