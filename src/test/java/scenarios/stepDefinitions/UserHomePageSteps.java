package scenarios.stepDefinitions;

import context.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.UserHomePage;
import utilities.CredsLoader;

public class UserHomePageSteps {
    private UserHomePage userHomePage;
    private Scenario scenario;
    public static String userFromDate = null;
    public String userToDate = null;


    public UserHomePageSteps(TestContext context) {
        this.userHomePage = context.userHomePage;
        this.scenario = context.scenario;
    }

    @Then("User validates the user name {string}")
    public void userValidatesTheUserName(String name) {
        userHomePage.closeNotificationPopUp();
        Assert.assertTrue(userHomePage.verifyName(name));
        scenario.log("user successfully verify the user name " +name);
    }

    @And("User clicks on location button and selects {string} under popular city section")
    public void userClicksOnLocationButtonAndSelectsUnderPopularCitySection(String city) throws InterruptedException {
        userHomePage.clickLocationDropDownButton();
        userHomePage.selectPopularCity(city);
        Thread.sleep(1000);
        Assert.assertTrue(userHomePage.verifySelectedCity(city));
        scenario.log("user successfully select the popular city " +city);
    }

    @And("^User select from date \"([^\"]*)\" and to date \"([^\"]*)\"$")
    public void userSelectFromDateAndToDate(String fromDate, String toDate) throws InterruptedException {
        Thread.sleep(2000);
        userFromDate = fromDate;
        userHomePage.clickAndChooseYear(fromDate, "FROM", "");
        Thread.sleep(2000);
        userHomePage.selectMonthAndDate(fromDate, "FROM");
        Thread.sleep(2000);
        userHomePage.selectDay(fromDate);
        Thread.sleep(1000);
        userHomePage.selectTime("10:30:AM", "FROM");
        Thread.sleep(2000);
        userHomePage.clickAndChooseYear(toDate, "TO", "");
        Thread.sleep(2000);
        userHomePage.selectMonthAndDate(toDate, "TO");
        Thread.sleep(2000);
        userHomePage.selectDay(toDate);
        Thread.sleep(1000);
        userHomePage.selectTime("2:30:PM", "TO");
        scenario.log("user successfully select FromDate and ToDate");
    }

    @And("User clicks in Monthly Subscription")
    public void userClicksInMonthlySubscription() {
        try {
            Thread.sleep(2000);
            Assert.assertTrue(userHomePage.clickMothlySubscription());
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        scenario.log("user successfully click on Monthly Subscription");
    }

    @And("User click on search button")
    public void userClickOnSearchButton() {
        userHomePage.clickSearchButton();
        scenario.log("user successfully click on search button and navigate to car page");
    }

    @And("User select from date {string}")
    public void userSelectFromDate(String fromDate) throws InterruptedException {
        userHomePage.clickPickDate();
        userHomePage.clickAndChooseYear(fromDate, "FROM", "MONTHLY");
        Thread.sleep(2000);
        userHomePage.selectMonthAndDate(fromDate, "FROM");
        Thread.sleep(2000);
        userHomePage.selectDay(fromDate);
        Thread.sleep(2000);
        userHomePage.selectTime(fromDate, "FROM");
        scenario.log("user successfully select FromDate");
    }

    @And("User clicks on location button and selects {string} under popular city section in Monthly Subcription")
    public void userClicksOnLocationButtonAndSelectsUnderPopularCitySectionInMonthlySubcription(String city) {
        userHomePage.clickLocationDropDownButton();
        userHomePage.selectPopularCity(city);
        Assert.assertTrue(userHomePage.verifyMonthlySelectedCity(city));
        scenario.log("user successfully select the location in monthly subscription"+ city);
    }

    @And("User click on Monthly Subscription search button")
    public void userClickOnMonthlySubscriptionSearchButton() {
        Assert.assertTrue(userHomePage.clickMonthlySaerch());
        scenario.log("user successfully click on Monthly subscription");
    }

    @Then("User click on Fleet link")
    public void userClickOnFleetLink() {
        Assert.assertTrue(userHomePage.clickFleetButton());
        scenario.log("user successfully click on Fleet section");
    }

    @And("User selects From date and To Date along with from time {string} and to time {string}")
    public void UserSelectsFromDateAndToDateAlongWith(String fromTime, String toTime) throws InterruptedException {
        Thread.sleep(2000);
        userHomePage.clickAndChooseYear("fromDate", "FROM", "");
        Thread.sleep(1000);
        userHomePage.selectMonthAndDate("fromDate", "FROM");
        Thread.sleep(1000);
        userHomePage.selectTime(fromTime, "FROM");
        Thread.sleep(2000);
        userHomePage.clickAndChooseYear("toDate", "TO", "");
        Thread.sleep(2000);
        userHomePage.selectMonthAndDate("toDate", "TO");
        Thread.sleep(1000);
        userHomePage.selectTime(toTime, "TO");
        Thread.sleep(1000);
        Assert.assertTrue(userHomePage.verifyPickDateValue(fromTime));
        Assert.assertTrue(userHomePage.verifyDropDateValue(toTime));
       // scenario.log("user select pickupDate and returnDate " +userHomePage.);
        scenario.log("user select FromDate ToDate along with FromTime and ToTime");
    }

    @And("User select from date {string}and time {string}")
    public void userSelectFromDateAndTime(String fromDate, String fromTime) throws Exception {
        userHomePage.clickPickDate();
        Thread.sleep(2000);
        userHomePage.clickAndChooseYear(fromDate, "FROM", "MONTHLY");
        Thread.sleep(2000);
        userHomePage.selectMonthAndDate(fromDate, "FROM");
        Thread.sleep(1000);
        userHomePage.selectTime(fromTime, "FROM");
        Assert.assertTrue(userHomePage.verifyPickDateValue(fromTime));
        scenario.log("user select FromDate and FromTime");
    }

    @Then("User click on FAQS link and verify the page")
    public void userClickOnFAQSLinkAndVerifyThePage() {
        userHomePage.clickFAQsButton();
        Assert.assertTrue(userHomePage.verifyUrl(new CredsLoader().getProperty("FAQS_PAGE")));
        scenario.log("user successfully navigate to FAQS page");
    }

    @And("User click on ContactUs link and verify the page")
    public void userClickOnContactUsLinkAndVerifyThePage() {
        userHomePage.clickContactUs();
        Assert.assertTrue(userHomePage.verifyUrl(new CredsLoader().getProperty("CONTACTUS_PAGE")));
        scenario.log("user successfully navigate to CONTACTUS page");
    }

    @And("User click on AboutUs and verify the page")
    public void userClickOnAboutUsAndVerifyThePage() {
        userHomePage.clickAboutUs();
        Assert.assertTrue(userHomePage.verifyUrl(new CredsLoader().getProperty("ABOUTUS_PAGE")));
        scenario.log("user successfully navigate to ABOUTUS page");
    }

    @And("User click on fleet and verify the page")
    public void userClickOnFleetAndVerifyThePage() {
        userHomePage.clickFleet();
        Assert.assertTrue(userHomePage.verifyUrl(new CredsLoader().getProperty("FLEETS_PAGE")));
        scenario.log("user successfully navigate to FLEETS page");
    }

    @And("User click on deals and verify the page")
    public void userClickOnDelasAndVerifyThePage() {
        userHomePage.clickDeals();
        Assert.assertTrue(userHomePage.verifyUrl(new CredsLoader().getProperty("DEALS_PAGE")));
        scenario.log("user successfully navigate to DEALS page");
    }

    @And("User select from date {string}and time {string} for fleets")
    public void userSelectFromDateAndTimeForFleets(String fromDate, String fromTime) throws Exception {
        userHomePage.clickAndChooseYear(fromDate, "FROM", "MONTHLY");
        Thread.sleep(2000);
        userHomePage.selectMonthAndDate(fromDate, "FROM");
        Thread.sleep(1000);
        userHomePage.selectTime(fromTime, "FROM");
        scenario.log("");
    }
}
