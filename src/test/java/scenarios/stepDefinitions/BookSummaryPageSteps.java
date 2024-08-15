package scenarios.stepDefinitions;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.BookSummaryPage;

import static pages.BookSummaryPage.getDropAddress;
import static pages.BookSummaryPage.getPickUpAddress;

public class BookSummaryPageSteps {
    private final BookSummaryPage bookSummaryPage;
    private Scenario scenario;

    public BookSummaryPageSteps(TestContext context) {

        this.bookSummaryPage = context.bookSummaryPage;
        this.scenario = context.scenario;
    }

    @Then("^User selects the \"([^\"]*)\" and verifies the pickup \"([^\"]*)\"$")
    public void User_selectes_the_picupLocation_and_verifies_the_pickip_address(String pickupLocation, String address)
            throws InterruptedException {
        bookSummaryPage.selectPickupLocation(pickupLocation, address);
        getPickUpAddress = bookSummaryPage.getAddress();
        Assert.assertEquals(address, bookSummaryPage.getAddress());
        scenario.log("user successfully verifies the pickup location and pickup address");

    }

    @And("^User selects the \"([^\"]*)\" and verifies the drop \"([^\"]*)\"$")
    public void User_selectes_the_picupLocation_and_verifies_the_drop_address(String pickupLocation, String address) {
        bookSummaryPage.selectDropLocation(pickupLocation, address);
        getDropAddress = bookSummaryPage.getDropAddress();
        Assert.assertEquals(address, bookSummaryPage.getAddress());
        scenario.log("user successfully verifies the drop location and drop address");
    }

    @Then("^User select the \"([^\"]*)\"$")
    public void userSelectThePromoCode(String promoCode) {
        Assert.assertTrue(bookSummaryPage.clickPromoCode(promoCode));
        scenario.log("user successfully select the promo code");
        // bookSummaryPage.closePopUp();
    }

    @Then("User click on Proceed Button")
    public void userClickOnProceedButton() {
        Assert.assertTrue(bookSummaryPage.clickProceedButton());
        scenario.log("user successfully click the proceed Button");
    }

    @And("^User verifies the car name \"([^\"]*)\" and return date$")
    public void userVerifiesTheAndReturnDate(String pickupdate) {
        Assert.assertTrue(bookSummaryPage.verifyCarName());
        Assert.assertTrue(bookSummaryPage.verifyPickupDateTime(pickupdate));
        scenario.log("user verifies car name and return date");
    }

    @And("^User verifies the car name \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userVerifiesTheAnd(String pickup, String drop) {
        Assert.assertTrue(bookSummaryPage.verifyCarName());
        Assert.assertTrue(bookSummaryPage.verifyPickupAndDropDateTime(pickup, drop));
        scenario.log("user verifies car name pickup location drop location");
    }

    @Then("User verifies the Total charges")
    public void userVerifiesTheTotalCharges() {
        Assert.assertNotNull(bookSummaryPage.verifyTotalCharges("DAILY", "Nearby Locations"));
        scenario.log("user successfully verify Total Amount Daily Rental");
    }

    @Then("User verifies the Total charges for Monthly Subscription")
    public void userVerifiesTheTotalChargesForMonthlySubscription() {
        bookSummaryPage.verifyTotalCharges("MONTHLY", "Nearby Locations");
        scenario.log("user successfully verify Total Amount Monthly Subscription");
    }

    @Then("User click on Luggage and Trip Protection plan check box")
    public void userClickOnLuggageAndTripProtectionPlanCheckBox() throws InterruptedException {
        Assert.assertTrue(bookSummaryPage.clickLuggageAndTripProtectionPlan());
    }

    @Then("User selects the {string} and enter the pickup address {string}")
    public void userSelectsTheAndEnterThePickupAddress(String pickupLoc, String address) {
        bookSummaryPage.selectPickUpDoorStepDeliveryLocation(pickupLoc, address);
        Assert.assertEquals(address, bookSummaryPage.getAddress());
        getPickUpAddress = bookSummaryPage.getAddress();
        scenario.log("user successfully select the pickup location"+pickupLoc +"Enter address"+address);
    }

    @And("User selects the {string} and enters the drop address {string}")
    public void userSelectsTheAndEntersTheDropAddress(String dropLoc, String address) {
        bookSummaryPage.selectDropDoorStepDeliveryLocation(dropLoc, address);
        Assert.assertEquals(address, bookSummaryPage.getDoorStepDropAddress());
        getDropAddress = bookSummaryPage.getDoorStepDropAddress();
        scenario.log("user successfully select the pickup location"+dropLoc +"Enter address"+address);
    }

}
