package scenarios.stepDefinitions;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.BookingDetailsPage;
import pages.CheckoutPage;

public class CheckoutPageSteps {
    private CheckoutPage checkoutPage;
    private BookingDetailsPage bookingDetailsPage;
    private Scenario scenario;

    public CheckoutPageSteps(TestContext context) {

        this.checkoutPage = context.checkoutPage;
        this.bookingDetailsPage = context.bookingDetailsPage;
        this.scenario = context.scenario;
    }

    @Then("^User verifies the Choose the payment Title \"([^\"]*)\"$")
    public void User_verifies_the_Choose_the_payment_Title(String title) throws InterruptedException {
        Assert.assertEquals(checkoutPage.getPaymentTitle(), title);
        scenario.log("user successfully select Debit card payment "+ title);
    }

    @Then("User verifies the Total amount")
    public void userVerifiesTheTotalAmount() {
        Assert.assertTrue(checkoutPage.VerifiTheAmount());
        scenario.log("user successfully verified Total amount");
    }

    @And("^User Verifies the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and car name in Daily Rentals$")
    public void userVerifiesTheAndCarNameinDailyRentals(String pickuptime, String returntime, String state) {
        Assert.assertTrue(checkoutPage.verifiDetails(pickuptime, returntime, state, false));
        scenario.log("user successfully verifies pickupTime returnTime "+ pickuptime+ returntime);
    }

    @And("User Verifies the {string} {string} {string} and car name")
    public void userVerifiesTheAndCarName(String pickuptime, String state) {
        Assert.assertTrue(checkoutPage.verifyMonthSubscriptionDetails(pickuptime, state));
        scenario.log("user successfully verifies pickupTime ReturnTime "+ pickuptime);
    }

    @And("User enter {string} {string} {string} {string}")
    public void userEnter(String name, String number, String month, String year) {
        Assert.assertTrue(checkoutPage.completePayment(name, number, month, year));
        scenario.log("user successfully enter the Debit card details "+name +number+ month+ year);
    }

    @Then("User click on success button")
    public void userClickOnSuccessButton() {
        Assert.assertTrue(checkoutPage.clickSuccessButton());
        scenario.log("user successfully click on success button");
    }

    @Then("User verifies {string} , Payment successfully message , amount and BookingId")
    public void userVerifiesPaymentSuccessfullyMessageAmountAndBookingId(String number) throws InterruptedException {
        Assert.assertTrue(bookingDetailsPage.verifySuccessfulTransaction(number));
        scenario.log("user successfully verifies the Booking Details");
    }

    @And("User Verifies the details {string} and {string}")
    public void userVerifiesTheDetailsAnd(String pickuptime, String state) {
        Assert.assertTrue(checkoutPage.verifyMonthSubscriptionDetails(pickuptime, state));
        scenario.log("user successfully verifies the pickupTime");
    }

    @And("User Verifies the modified {string} {string} {string} and car name")
    public void userVerifiesTheModifiedAndCarName( String pickuptime, String returntime, String city) {
        Assert.assertTrue(checkoutPage.verifiDetails(pickuptime, returntime, city, true));
        scenario.log("user successfully verifies the modified Dates and Time");
    }

    @And("User choose the NetBanking option")
    public void userChooseTheNetBankingOption() throws InterruptedException {
        checkoutPage.clickOnNetBanking();
        checkoutPage.clickOnBankName();
        scenario.log("user successfully select the NetBanking");
    }

    @And("User verifies payment method and bankName {string} {string}")
    public void userVerifiesPaymentMethodAndBankName(String paymentMethod, String bankName) {
        Assert.assertEquals(checkoutPage.getNetBanking(),paymentMethod);
        Assert.assertEquals(checkoutPage.getBankName(),bankName);
        scenario.log("user successfully verifies the Payment method and BankName " +" "+paymentMethod+" "+bankName);
    }
}
