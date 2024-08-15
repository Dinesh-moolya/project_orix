package scenarios.stepDefinitions;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.MyProfilePage;
import utilities.CredsLoader;

public class MyProfilePageStep {
    private MyProfilePage myProfilePage;
    private Scenario scenario;

    public MyProfilePageStep(TestContext context) {
        this.myProfilePage = context.myProfilePage;
        this.scenario = context.scenario;
    }

    @Then("User goes to my profile page and click Booking button")
    public void userGoesToMyProfilePageAndClickBookingButton() throws InterruptedException {
        myProfilePage.goTo(new CredsLoader().getProperty("PROFILE_PAGE"));
        Assert.assertTrue(myProfilePage.verifyUrl(new CredsLoader().getProperty("PROFILE_PAGE")));
        myProfilePage.clickBookingButton();
        scenario.log("user successfully navigate to profile page and click on Booking button");
    }

    @And("User click on Upcoming filter and click on View details")
    public void userClickOnUpcomingFilterAndClickOnViewDetails() {
        myProfilePage.clickUpcomming();
        Assert.assertTrue(true);
        scenario.log("user successfully select the upcoming filter");
    }

    @Then("User click on cancels the booking by click on cancel button")
    public void userClickOnCancelsTheBookingByClickOnCancelButton() throws InterruptedException {
        myProfilePage.verifyAndCancel();
        Assert.assertTrue(myProfilePage.verifyCongratsMessageIsDisplayed());
        scenario.log("user successfully select the cancel Booking option and cancel");
    }

    @Then("User verifies the cancelled list")
    public void userVerifiesTheCancelledList() {
        Assert.assertTrue(myProfilePage.verifyTheCancelledList());
        scenario.log("user successfully verifies the cancelled list");
    }

    @And("User clicked on cancel status")
    public void userClickedOnCancelStatus() {
        myProfilePage.clickCancelled();
        scenario.log("user click on cancel status");
    }

    @Then("User lands in My Profile")
    public void userLandsInMyProfile() {
        myProfilePage.goTo(new CredsLoader().getProperty("PROFILE_PAGE"));
        scenario.log("user successfully navigate to My Profile page");
    }

    @Then("User edits and save the profiles")
    public void userEditsAndSaveTheProfiles() {
        myProfilePage.updateDeatils("Banglore RR nagar", "560098");
        scenario.log("user successfully updates the profile " );
    }

    @Then("User verify the update successfully message")
    public void userVerifyTheUpdateSuccessfullyMessage() {
        Assert.assertTrue(myProfilePage.verifyMessage());
        scenario.log("user verifies the successful message");
    }

    @Then("User click on Document button")
    public void userClickOnDocumentButton() {
        myProfilePage.clickDocumentButton();
        scenario.log("user successfully click on Document button");
    }

    @Then("User verify the pan card")
    public void userVerifyThePanCard() {
        Assert.assertTrue(myProfilePage.verifyPanCard());
        scenario.log("user successfully verifies the pan number");
    }

    @And("User upload and verifies Aadhaar Front and Aadhaar Back files")
    public void userUploadAndVerifiesAadhaarFrontAndAadhaarBackFiles() {
        myProfilePage.uploadFrontAadharCard();
        Assert.assertTrue(myProfilePage.verifySuccessNotification());
        myProfilePage.clickCloseSuccessNotification();
        myProfilePage.uploadBackAadharCard();
        Assert.assertTrue(myProfilePage.verifySuccessNotification());
        myProfilePage.clickCloseSuccessNotification();
        scenario.log("user successfully verifies the upload Aadhaar Front and Back page");
    }

    @And("User upload and verifies Driving licence Front and Driving licence Back")
    public void userUploadAndVerifiesDrivingLicenceFrontAndDrivingLicenceBack() {
        myProfilePage.uploadFrontDrivingLicense();
        Assert.assertTrue(myProfilePage.verifySuccessNotification());
        myProfilePage.clickCloseSuccessNotification();
        myProfilePage.uploadBackDrivingLicense();
        Assert.assertTrue(myProfilePage.verifySuccessNotification());
        myProfilePage.clickCloseSuccessNotification();
        scenario.log("user verifies the upload Driving License Front and Back page");
    }

    @And("User uploads Pan Card")
    public void userUploadsPanCard() {
        myProfilePage.uploadPanCardDocument();
        Assert.assertTrue(myProfilePage.verifySuccessNotification());
        myProfilePage.clickCloseSuccessNotification();
        scenario.log("user verifies the upload pan card");
    }

    @And("User clicked on completed status")
    public void userClickedOnCompletedStatus() {
        myProfilePage.clickCompeleteStatus();
        scenario.log("user select the completed status");
    }

    @Then("User verifies the completed list")
    public void userVerifiesTheCompletedList() {
        myProfilePage.verifyTheCompletedList();
        scenario.log("user verifies completed list");
    }

    @And("User click on logout and verifies navigate to Login page")
    public void userClickOnLogout() {
        myProfilePage.clickOnProfileDropDown();
        myProfilePage.clickOnLogOut();
        myProfilePage.clickOnYesLogout();
        Assert.assertTrue(myProfilePage.verifyLogoutUrl());
        scenario.log("user successfully navigate to Login page");
    }

}
