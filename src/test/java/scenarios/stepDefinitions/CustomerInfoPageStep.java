package scenarios.stepDefinitions;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.CustomerinfoPage;

public class CustomerInfoPageStep {
    private CustomerinfoPage customerinfoPage;
    private Scenario scenario;

    public CustomerInfoPageStep(TestContext context) {
        this.customerinfoPage = context.customerinfoPage;
        this.scenario = context.scenario;
    }

    @Then("^User verifies the \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
    public void User_verifies_the_data(String fname, String lname, String gender, String dob)
            throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(customerinfoPage.verifiUserDetails(fname, lname, gender, dob));
        scenario.log("user successfully verifies the personal data " +fname+" "+ lname+" "+gender+" "+dob);
    }

    @And("^User enters edis the DOB \"([^\"]*)\"$")
    public void userEntersEdisTheDOB(String dob) {
        customerinfoPage.enterDob(dob);
    }

    @Then("User click Next button")
    public void userClickNextButton() {
        Assert.assertTrue(customerinfoPage.clickNextButton());
        scenario.log("user successfully click on Next button");
    }

    @And("^User enter the pan number \"([^\"]*)\" and click validate button$")
    public void userEnterThePanNumberAndClickValidateButton(String pan) {
        customerinfoPage.enterDocumentVerificationDetails("Pan", pan);
    }

    @And("^User verifies the pan number \"([^\"]*)\"$")
    public void userVerifiesThePanNumber(String pan) {
        Assert.assertTrue(customerinfoPage.enterDocumentVerificationDetails("PAN", pan));
        scenario.log("user successfully verify upload pan number "+ pan);
    }

    @And("User edits and verifies the address {string} {string} {string} {string}")
    public void userVerifiesTheAddress(String addresstype, String state, String pincode, String address)
            throws InterruptedException {
        customerinfoPage.clickCommunicationButton();
        Thread.sleep(1000);
        customerinfoPage.clickCommunicationDropDown("addreessType", "Permanent");
        customerinfoPage.clickCommunicationDropDown("state", "Karnataka");
        customerinfoPage.enterPincodeAndAddress("560100", "Banglore");
        Assert.assertTrue(customerinfoPage.verifiCommunicationAddress(addresstype, state, pincode, address));
        customerinfoPage.clickSaveButton();
        scenario.log("user verifies the communication address " + addresstype+" "+ state+" "+pincode+" "+ address);
    }

    @Then("User click proceed to check out button")
    public void userClickProceedToCheckOutButton() {
        Assert.assertTrue(customerinfoPage.clickChechoutButton());
        scenario.log("user successfully click on proceed to check out button");
    }

    @Then("User clicks on Agree & Proceed")
    public void userClicksOnAgreeProceed() {
        Assert.assertTrue(customerinfoPage.clickAgreeAndProceed());
        scenario.log("user successfully select the Agree and Proceed checkbox");
    }

}
