package pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

import static pages.CheckoutPage.amountValue;

public class BookingDetailsPage extends BasePage {
    private final By bookingNumber = By.xpath("//p[contains(text(),'Booking Number')]/../following-sibling::div/h5[1]");
    private final By bookingDate = By.xpath("//p[contains(text(),'Booking Number')]/../following-sibling::div/h5[2]");
    private final By userName = By.xpath("(//p[contains(text(),'User Name')]/following-sibling::h5)[1]");

    private final By bookingId = By.xpath("(//p[contains(text(),'Booking id')]/following-sibling::h5)[1]");

    private final By pickUpLocation = By.xpath("//p[contains(text(),'Pickup location')]/following-sibling::h5");

    private final By dropLocation = By.xpath("//p[contains(text(),'Drop Location')]/following-sibling::h5");
    private final By mobileNumber = By.xpath("//p[contains(text(),'Phone Number')]/following-sibling::h5");

    private final By paymentSuccessful = By.xpath("//h2[text()='Payment Successful']");
    private final By amount = By.xpath("//h1[text()='Total Amount']/following-sibling::h1");
    private final By closePopupButton = By.xpath("//button[@aria-label=\"Close\"]");

    public BookingDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getBookingDate() {
        waitUntilElementIsDisplayed(bookingDate);
        return driver.findElement(bookingDate).getText();
    }

    public boolean verifyBookingNumber() {
        return isDisplayed(bookingId);
    }

    public boolean verifySuccessfulTransaction(String number) throws InterruptedException {

        try {
            Thread.sleep(900);
        } catch (Exception e) {

        }
        clickUsingJS(driver, closePopupButton);
        try {
            Thread.sleep(500);
        } catch (Exception e) {

        }
        boolean result = false;
        waitUntilElementIsDisplayed(mobileNumber);
        waitUntilElementIsDisplayed(amount);
        waitUntilElementIsDisplayed(bookingId);
        waitUntilElementIsDisplayed(bookingDate);
        waitUntilElementIsDisplayed(pickUpLocation);
        waitUntilElementIsDisplayed(dropLocation);
        String pickup = driver.findElement(pickUpLocation).getText();
        String drop = driver.findElement(dropLocation).getText();
        CheckoutPage.bookingIdValue = driver.findElement(bookingId).getText();
        LocalDate givenBookingDate = UserHomePage.fromGivenDate;
        String Month = StringUtils.capitalize(String.valueOf(givenBookingDate.getMonth()).toLowerCase());
        String Day = String.valueOf(givenBookingDate.getDayOfMonth());
        String Year = String.valueOf(givenBookingDate.getYear());
        String DefaultBookingDate = driver.findElement(bookingDate).getText().replace(",", "");
        if (verifyElementIsDisplayed(bookingId) && driver.findElement(mobileNumber).getText().contains("+91" + number)
                && driver.findElement(amount).getText().replace("₹", "\u20B9").split(" ")[1].contains(amountValue)) {
            result = true;
            if (DefaultBookingDate.split(" ")[0].equals(Month) && DefaultBookingDate.split(" ")[1].contains(Day)
                    && DefaultBookingDate.split(" ")[2].equals(Year) && verifyBookingNumber()
                    && pickup.trim().equals(BookSummaryPage.getPickUpAddress.trim())
                    && drop.trim().equals(BookSummaryPage.getDropAddress.trim())) {
                result = true;
            }
        }
        Thread.sleep(1000);
        return result;
    }
}
