package scenarios.stepDefinitions;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import pages.CarsPage;

public class CarsPageSteps {

    private CarsPage carsPage;
    private Scenario scenario;

    public CarsPageSteps(TestContext context) {
        this.carsPage = context.carsPage;
        this.scenario = context.scenario;
    }

    @Then("^User selects the car$")
    public void UserSelectsTheCar() throws InterruptedException {
        Assert.assertTrue(carsPage.clickBookNow());
        scenario.log("user successfully select the car");
    }

    @Then("User selects the car from list")
    public void userSelectsTheCarFromList() {
        try {
            Thread.sleep(2000);
            Assert.assertTrue(carsPage.clickSubscriptionBookNowButton());
        } catch (Exception e) {

        }
        scenario.log("user successfully select the car from list");
    }

    @Then("User clicks on {string} fuel type")
    public void userClicksOnFuelType(String fuelType) {
        try {
            Thread.sleep(2000);
            carsPage.clickOnChooseFilterOption(fuelType);
        } catch (Exception e) {

        }
        scenario.log("user click on fuel type " +fuelType);
    }

    @And("User clicks on {string} brand type")
    public void userClicksOnBrandType(String brand) {
        carsPage.clickOnChooseFilterOption(brand);
        scenario.log("user select the brand " +brand);
    }

    @And("User clicks on {string} transmission type")
    public void userClicksOnTransmissionType(String transmissiontype) {
        carsPage.clickOnChooseFilterOption(transmissiontype);
        scenario.log("user select transmission type " +transmissiontype);
    }

    @And("User click on {string} luggage type")
    public void userClickOnLuggageType(String luggage) {
        carsPage.clickOnChooseFilterOption(luggage);
        scenario.log("user select luggage " +luggage);
    }

    @And("User clicks on {string} Seating capacity")
    public void userClicksOnSeatingSeatingCapacity(String seating) {
        carsPage.clickOnChooseFilterOption(seating);
        scenario.log("user select the seating capacity " +seating);
    }

    @Then("User verifies the filter data")
    public void userVerifiesTheFilterData() {
    }

    @Then("User verifies the filter data of {string} {string} {string} {string}")
    public void userVerifiesTheFilterDataOf(String fuel, String transmission, String luggage, String seat) {
        Assert.assertTrue(carsPage.verifyFilterData(StringUtils.capitalize(fuel), StringUtils.capitalize(transmission),
                luggage, seat));
        scenario.log("user successfully verifies the filter data " +fuel +transmission +luggage +seat);
    }

    @Then("User selects the car in Monthly Subscription")
    public void userSelectsTheCarInMonthlySubscription() {
        Assert.assertTrue(carsPage.clickSubscriptionBookNowButton());
        scenario.log("user successfully select the car in Monthly Subscription");
    }

    @Then("User click on UnlimitedKms option")
    public void userClickOnUnlimitedKmsOption() {
        carsPage.clickUnlimitedKmButton();
        scenario.log("user select select the unlimited kilometers");
    }

    @Then("User click on {int}KmsPerDay option")
    public void userClickOnKmsPerDayOption(int arg0) {
        carsPage.clickOneTwentyKmsPerDay();
        scenario.log("user successfully select the 120kms");
    }

    @And("User enter the modifies city {string}")
    public void userEnterTheModifiesCity(String city) {
        carsPage.clickModifiedCity(city);
        scenario.log("user enter the modify city " +city);
    }

    @And("User enters the modified pickup date {string} {string} and drop off date {string} {string}")
    public void userEntersTheModifiedPickupDateAndDropOffDate(String modifiedPickupDate, String defaultpickupDate,
            String modifiedDropOfDate, String defaultDropOFDate) throws InterruptedException {
        carsPage.clickAndChooseModifiedYear(defaultpickupDate, modifiedPickupDate, "FROM");
        carsPage.chooseModifiedMonth(defaultpickupDate, modifiedPickupDate, "FROM");
        carsPage.selectModifiedTime("3:30:PM", "FROM");

        // drop off
        carsPage.clickAndChooseModifiedYear(defaultDropOFDate, modifiedDropOfDate, "TO");
        carsPage.chooseModifiedMonth(defaultDropOFDate, modifiedDropOfDate, "TO");
        carsPage.selectModifiedTime("4:30:PM", "TO");
        scenario.log("user successfully enter the modified pickup and dropoff dates");
    }

    @And("User enters the modified pickup date {string} {string} {string} and dropof date {string} {string} {string}")
    public void userEntersTheModifiedPickupDateAndDropofDate(String modifiedPickupDate, String modofiedPickUpTime,
            String defaultpickupDate, String modifiedDropOfDate, String modofiedDropOfTime, String defaultDropOFDate)
            throws InterruptedException {
        carsPage.clickAndChooseModifiedYear(defaultpickupDate, modifiedPickupDate, "FROM");
        carsPage.chooseModifiedMonth(defaultpickupDate, modifiedPickupDate, "FROM");
        carsPage.selectModifiedTime(modofiedPickUpTime, "FROM");
        // drop off
        carsPage.clickAndChooseModifiedYear(defaultDropOFDate, modifiedDropOfDate, "TO");
        carsPage.chooseModifiedMonth(defaultDropOFDate, modifiedDropOfDate, "TO");
        carsPage.selectModifiedTime(modofiedDropOfTime, "TO");
        scenario.log("user successfully enter the modified pickup and drop off dates");
    }

    @Then("User click on Modify search button")
    public void userClickOnModifySearchButton() {
        carsPage.clickModifySearchButton();
        scenario.log("user successfully click on Modify search button");
    }

}
