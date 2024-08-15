package pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static pages.CarsPage.carNameValue;

public class CheckoutPage extends BasePage {

    private final By choosePaymentTitle = By.xpath("//h4[contains(text(),'Choose payment method')]");
    private final By totalAmount = By.xpath("//h6[contains(text(),'Total Amount')]/following-sibling::h6");
    private final By state = By.xpath("//h3[contains(text(),'Location:')]/span");
    private final By pickupDate = By.xpath("(//h3[contains(text(),'Location:')]/following-sibling::div//p)[1]");
    private final By pickupTime = By.xpath("(//h3[contains(text(),'Location:')]/following-sibling::div//p)[2]");
    private final By returnDate = By.xpath("//h3[contains(text(),'Location:')]/following-sibling::div/div[3]/p[1]");
    private final By returnTime = By.xpath("//h3[contains(text(),'Location:')]/following-sibling::div/div[3]/p[2]");
    private final By carName = By.xpath("//h2[contains(text(),'Booking summary')]/../following-sibling::div//div//h5");
    private final By cardHolderName = By.xpath("//input[@id=\"name_on_card\"]");
    private final By cardNumber = By.xpath("//*[@id=\"card_number\"]");
    private final By expMonth = By.xpath("//*[@id=\"card_exp_month\"]");
    private final By expYear = By.xpath("//*[@id=\"card_exp_year\"]");
    private final By makePayment = By.xpath("//button[contains(text(),'Make Payment')]");
    private final By successButton = By.xpath("//button[contains(text(),'Success')]");
    private final By cvvCode = By.xpath("//*[@id='security_code']");

    private final By mobileNumber = By.xpath("(//p//span)[2]");
    private final By emailId = By.xpath("(//p//span)[3]");
    private final By amount = By.xpath("(//p//span)[4]");
    private final By bookingId = By.xpath("(//p//span)[5]");
    private final By closePopupButton = By.xpath("//button[@aria-label=\"Close\"]");
    private final By netBanking = By.xpath("//a[contains(text(),'Netbanking')]");
    private  final By bankName = By.xpath("(//h5)[2]");
    public static String bookingIdValue;
    public static String amountValue;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getPaymentTitle() throws InterruptedException {
        // Thread.sleep(1000);
        waitUntilElementIsDisplayed(choosePaymentTitle);
        return driver.findElement(choosePaymentTitle).getText();
    }

    public String getTotalAmount() {
        waitUntilElementIsDisplayed(totalAmount);
        return driver.findElement(totalAmount).getText().split(" ")[1];
    }

    public boolean VerifiTheAmount() {
        BookSummaryPage bookSummaryPage = new BookSummaryPage(driver);
        String amount1 = bookSummaryPage.amount.replace("₹", "\u20B9").split(" ")[1];
        amountValue = getTotalAmount();
        boolean result = false;
        if (Double.parseDouble(amount1.replace(",", "")) == Double.parseDouble(getTotalAmount().replace(",", ""))) {
            result = true;
        }
        return result;
    }

    public boolean verifiDetails(String fromtime, String toTime, String state1, boolean isModified) {
        boolean result = false;
        LocalDate givenFromDate = UserHomePage.fromGivenDate;
        LocalDate givenToDate = UserHomePage.toGivenDate;
        if (isModified) {
            givenFromDate = CarsPage.modifiedFromGivenDate;
            givenToDate = CarsPage.modifiedToGivenDate;
        }
        String day = getdateDetails("day", String.valueOf(givenFromDate));
        String month = StringUtils.capitalize(getdateDetails("month", String.valueOf(givenFromDate)).toLowerCase());
        String year = getdateDetails("year", String.valueOf(givenFromDate));
        String pickup = driver.findElement(pickupDate).getText();
        String pickuptime = driver.findElement(pickupTime).getText().replace(" ", ":");

        String day1 = getdateDetails("day", String.valueOf(givenToDate));
        String month1 = StringUtils.capitalize(getdateDetails("month", String.valueOf(givenToDate)).toLowerCase());
        String year1 = getdateDetails("year", String.valueOf(givenToDate));
        String returndate1 = driver.findElement(returnDate).getText();
        String returntime1 = driver.findElement(returnTime).getText().replace(" ", ":");

        List<String> list1 = new ArrayList<>();
        list1.add(driver.findElement(state).getText());
        list1.add(dayFormatter(pickup.split(" ")[1]));
        list1.add(monthFormatter(pickup.split(" ")[2]));
        list1.add(pickup.split(" ")[3]);
        list1.add(timeFormatter(pickuptime).toUpperCase());
        list1.add(dayFormatter(returndate1.split(" ")[1]));
        list1.add(getMonth(returndate1.split(" ")[2]));
        list1.add(returndate1.split(" ")[3]);
        list1.add(timeFormatter(returntime1).toUpperCase());

        List<String> list2 = new ArrayList<>();
        list2.add(state1);
        list2.add(day);
        list2.add(month);
        list2.add(year);
        list2.add(fromtime);
        list2.add(day1);
        list2.add(month1);
        list2.add(year1);
        list2.add(toTime);
        String carname1 = driver.findElement(carName).getText();
        if (list1.equals(list2) && carname1.toLowerCase().equals(carNameValue.toLowerCase())) {
            result = true;
        }
        return result;
    }

    public boolean verifyMonthSubscriptionDetails(String fromtime, String state1) {
        boolean result = false;
        String day = getdateDetails("day", String.valueOf(UserHomePage.fromGivenDate));
        String month = StringUtils
                .capitalize(getdateDetails("month", String.valueOf(UserHomePage.fromGivenDate)).toLowerCase());
        String year = getdateDetails("year", String.valueOf(UserHomePage.fromGivenDate));
        String pickup = driver.findElement(pickupDate).getText();
        String pickuptime = driver.findElement(pickupTime).getText().replace(" ", ":");

        String day1 = UserHomePage.monthlyToGivenDate.getDayOfMonth() + "";
        String month1 = StringUtils.capitalize(UserHomePage.monthlyToGivenDate.getMonth().toString().toLowerCase());
        String year1 = UserHomePage.monthlyToGivenDate.getYear() + "";
        String returndate1 = driver.findElement(returnDate).getText();
        String returntime1 = driver.findElement(returnTime).getText().replace(" ", ":");

        List<String> list1 = new ArrayList<>();
        list1.add(driver.findElement(state).getText());
        list1.add(dayFormatter(pickup.split(" ")[1]));
        list1.add(monthFormatter(pickup.split(" ")[2]));
        list1.add(pickup.split(" ")[3]);
        list1.add(timeFormatter(pickuptime).toUpperCase());
        list1.add(dayFormatter(returndate1.split(" ")[1]));
        list1.add(getMonth(returndate1.split(" ")[2]));
        list1.add(returndate1.split(" ")[3]);
        list1.add(timeFormatter(returntime1).toUpperCase());

        List<String> list2 = new ArrayList<>();
        list2.add(state1);
        list2.add(day);
        list2.add(month);
        list2.add(year);
        list2.add(fromtime);
        list2.add(day1);
        list2.add(month1);
        list2.add(year1);
        list2.add(fromtime);
        String carname1 = driver.findElement(carName).getText();
        if (list1.equals(list2) && carname1.toLowerCase().equals(carNameValue.toLowerCase())) {
            result = true;
        }
        return result;
    }

    public boolean completePayment(String name, String number, String month, String year) {
        boolean result = false;

        driver.switchTo().frame(0);
        waitUntilElementIsDisplayed(cardHolderName);
        result = isDisplayed(cardHolderName);
        enterTextUsingJS(driver, driver.findElement(cardHolderName), name);
        driver.findElement(cardHolderName).sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);
        waitUntilElementIsDisplayed(cardNumber);
        enterTextUsingJS(driver, driver.findElement(cardNumber), number);
        clickOnElement(cardNumber);
        driver.findElement(cardNumber).sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();

        driver.switchTo().frame(2);
        waitUntilElementIsDisplayed(expMonth);
        enterTextUsingJS(driver, driver.findElement(expMonth), month);
        driver.findElement(expMonth).sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();

        driver.switchTo().frame(3);
        waitUntilElementIsDisplayed(expYear);
        enterTextUsingJS(driver, driver.findElement(expYear), year);
        driver.findElement(expYear).sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();

        driver.switchTo().frame(4);
        waitUntilElementIsDisplayed(cvvCode);
        enterTextUsingJS(driver, driver.findElement(cvvCode), "1234");
        driver.findElement(cvvCode).sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
        moveToElementAndClick(makePayment);
        return result;
    }

    public boolean clickSuccessButton() {
        boolean result = false;
        result = isDisplayed(successButton);
        moveToElementAndClick(successButton);
        return result;
    }

    public void clickOnNetBanking(){
        waitUntilElementIsDisplayed(netBanking);
        moveToElementAndClick(netBanking);
    }

    public String getNetBanking(){
        waitUntilElementIsDisplayed(netBanking);
        return driver.findElement(netBanking).getText();
    }

    public void clickOnBankName() throws InterruptedException {
        Thread.sleep(500);
        waitUntilElementIsDisplayed(bankName);
        moveToElementAndClick(bankName);
    }

    public String getBankName(){
        waitUntilElementIsDisplayed(bankName);
        return driver.findElement(bankName).getText();
    }
}
