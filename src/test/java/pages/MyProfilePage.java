package pages;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CredsLoader;

import java.util.List;

public class MyProfilePage extends BasePage {
    private final By bookingButton = By.id("nav-paymentmethod-tab");
    private final By upcommingButton = By.xpath("//label[text()='Upcoming']");
    private final By viewDeatils = By.xpath("(//a[text()='View Details'])[1]");
    private final By bookingId = By.xpath("(//h5)[2]");
    private final By totalAmmunt = By.xpath("(//h1)[6]");
    private final By name = By.xpath("(//h5)[5]");
    private final By cancelButton = By.xpath("//button[text()='Cancel Bookings']");
    private final By cancelReason = By
            .xpath("//label[text()='Reason For Cancellation']/following-sibling::select[@class=\"form-select\"]");
    private final By comment = By.xpath("//textarea[@placeholder=\"Enter Comment\"]");
    private final By cancelThisBookingButton = By.xpath("//*[text()='Cancel this booking']");
    private final By closePopUpButton = By.xpath("(//button[@class=\"btn-close\"])[2]");
    private final By okButton = By.xpath("//*[text()='OK']");

    private final By congratsMessage = By.xpath("//*[contains(text(),'Congrats')]");

    private final By cancelledText = By.xpath("//p[contains(text(),'Cancelled')]");
    private final By confirmationText = By.xpath("//p[contains(text(),'Confirmation')]");
    private final By viewDetailsList = By.xpath("//a[contains(text(),'View Details')]");
    private final By CancelledStatus = By.xpath("//label[text()='Cancelled']");
    private final By completeStatus = By.xpath("//label[text()='Completed']");
    private final By addressType = By.xpath("//select[@id='address_type']");
    private final By pincodevalue = By.xpath("//label[text()='Pincode*']/following-sibling::div/input");
    private final By address = By.xpath("//label[text()='Address*']/following-sibling::div/input");
    private final By saveButton = By.xpath("//button[text()='Save']");
    private final By updateSuccessMessage = By.xpath("//*[contains(text(),'Personal details updated successfully.')]");
    private final By panCardPreview = By
            .xpath("//h6[text()='PAN Card']/preceding-sibling::div//div[@id='imagePreview']");
    private final By documentButton = By.xpath("//button[@id=\"nav-personaldetails-tab\"]");
    private final By profileDropdown = By.xpath("//button[@id='dropdown-basic']");
    private final By logout = By.xpath("//a[contains(text(),'Logout')]");
    private final By logoutPopup = By.xpath("//button[contains(text(),'Yes, logout!')]");
    private final By pendingList = By.xpath("//*[text()='View Details']");
    public String pendingListIndex = "(//*[text()='View Details'])[%s]";
    private final By uploadPanCard = By.xpath("//input[@id=\"imageUploadpan\"]");
    private final By saveChangesButton = By.xpath("//button[@id=\"submit_process\" and text()='Save changes']");
    private final By successUploadNotification = By.xpath("//div[contains(text(),'Success')]");
    private final By aadharFrontImage = By.xpath("//input[@id=\"imageUploadfront\"]");
    private final By aadharBackImage = By.xpath("//input[@id=\"imageUploadback\"]");
    private final By licenseFrontImage = By.xpath("//input[@id=\"imageUploadlicence\"]");
    private final By licenseBackImage = By.xpath("//input[@id=\"imageUploadlicencebck\"]");
    private final By closeUploadSuccessNotification = By.xpath("//button[@aria-label=\"close\"]");

    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    public void clickBookingButton() {
        moveToElementAndClick(bookingButton);
    }

    public void clickOnProfileDropDown() {
        clickOnElement(profileDropdown);
    }

    public void clickOnYesLogout() {
        clickOnElement(logoutPopup);
    }

    public void clickOnLogOut() {
        waitUntilElementIsDisplayed(logout);
        clickOnElement(logout);
    }

    public void clickUpcomming() {

        moveToElementAndClick(upcommingButton);
    }

    public void clickViewDetails() {
        clickOnElement(viewDeatils);
    }

    public boolean verifyBookingId() {
        boolean result = false;
        waitUntilElementIsDisplayed(bookingId);
//CheckoutPage.bookingIdValue
        if (driver.findElement(bookingId).getText().trim().equals(CheckoutPage.bookingIdValue)) {
            result = true;
        }
        return result;
    }

    public boolean verifyAmount() {
        boolean result = true;
        waitUntilElementIsDisplayed(totalAmmunt);
        String value = driver.findElement(totalAmmunt).getText().replace("₹", "").trim();
        if (value.equals(CheckoutPage.amountValue)) {
            result = true;
        }
        return result;
    }

    public boolean verifiesName(String firstName, String lastName) {
        boolean result = false;
        waitUntilElementIsDisplayed(name);
        String value1 = driver.findElement(name).getText();
        String value2 = firstName + " " + lastName;
        if (value1.contains(value2)) {
            result = true;
        }
        return result;
    }

    public void cancelBooking() throws InterruptedException {
        Thread.sleep(2000);
        moveToElementAndClick(cancelButton);
        selectFromDropDown(cancelReason, "Others");
        enterTextOnElement(comment, "cancel the booking");
        clickOnElement(cancelThisBookingButton);
        clickOnElement(okButton);
    }

    public void clickCancelled() {

        moveToElementAndClick(CancelledStatus);
    }

    public void clickCompeleteStatus() {
        moveToElementAndClick(completeStatus);
    }

    public boolean verifyCongratsMessageIsDisplayed() {
        waitUntilElementIsDisplayed(congratsMessage);
        return driver.findElement(congratsMessage).isDisplayed();
    }

    public boolean verifyTheCancelledList() {
        boolean result = false;
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cancelledText));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(viewDetailsList));
        List<WebElement> cancelledList = driver.findElements(cancelledText);
        List<WebElement> viewDeatils = driver.findElements(viewDetailsList);
        if (cancelledList.size() == viewDeatils.size()) {
            result = true;
        }
        return result;
    }

    public boolean verifyTheCompletedList() {
        boolean result = false;
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cancelledText));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(viewDetailsList));
        List<WebElement> cancelledList = driver.findElements(cancelledText);
        List<WebElement> confirmationList = driver.findElements(confirmationText);
        List<WebElement> viewDeatils = driver.findElements(viewDetailsList);

        if (cancelledList.size() + confirmationList.size() == viewDeatils.size()) {
            result = true;
        }
        return result;
    }

    public void updateDeatils(String addressdata, String pincode) {
        waitUntilElementIsDisplayed(addressType);
        selectFromDropDown(addressType, "Permanent");
        waitUntilElementIsDisplayed(address);
        clearTextBox(driver.findElement(address));
        enterTextOnElement(address, addressdata);
        waitUntilElementIsDisplayed(pincodevalue);
        clearTextBox(driver.findElement(pincodevalue));
        enterTextOnElement(pincodevalue, pincode);
        moveToElementAndClick(saveButton);
    }

    public boolean verifyMessage() {
        waitUntilElementIsDisplayed(updateSuccessMessage);
        return driver.findElement(updateSuccessMessage).isDisplayed();
    }

    public boolean verifyPanCard() {
        waitUntilElementIsDisplayed(panCardPreview);
        return driver.findElement(panCardPreview).isDisplayed();
    }

    public void clickDocumentButton() {

        clickOnElement(documentButton);
    }

    public void uploadPanCardDocument() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        uploadDocument(uploadPanCard, System.getProperty("user.dir") + new CredsLoader().getProperty("PAN_CARD"));
        clickOnElement(saveChangesButton);

    }

    public boolean verifySuccessNotification() {
        waitUntilElementIsDisplayed(successUploadNotification);
        return driver.findElement(successUploadNotification).isDisplayed();
    }

    public void uploadFrontAadharCard() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        uploadDocument(aadharFrontImage,
                System.getProperty("user.dir") + new CredsLoader().getProperty("AADHARCARD_FRONT"));
        clickOnElement(saveChangesButton);

    }

    public void uploadBackAadharCard() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        uploadDocument(aadharBackImage,
                System.getProperty("user.dir") + new CredsLoader().getProperty("AADHARCARD_BACK"));
        clickOnElement(saveChangesButton);

    }

    public void uploadFrontDrivingLicense() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        uploadDocument(licenseFrontImage,
                System.getProperty("user.dir") + new CredsLoader().getProperty("DRIVINGLICENSE_FRONT"));
        clickOnElement(saveChangesButton);

    }

    public void uploadBackDrivingLicense() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        uploadDocument(licenseBackImage,
                System.getProperty("user.dir") + new CredsLoader().getProperty("DRIVINGLICENSE_BACK"));
        clickOnElement(saveChangesButton);

    }

    public void verifyAndCancel() throws InterruptedException {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(pendingList));

        List<WebElement> pending = driver.findElements(pendingList);
        for (int i = 1; i <= pending.size(); i++) {
            String pendingLoc = getDynamicPath(pendingListIndex, "" + i);
            {
                waitUntilElementIsDisplayed(By.xpath(pendingLoc));
                moveToElementAndClick(By.xpath(pendingLoc));
                if (new MyProfilePage(driver).verifyBookingId()) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    new MyProfilePage(driver).cancelBooking();
                    break;
                } else {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    moveToElementAndClick(bookingButton);
                }
            }
        }
    }

    public void clickCloseSuccessNotification() {
        clickUsingJS(driver, closeUploadSuccessNotification);
        driver.navigate().refresh();
        clickOnElement(documentButton);
    }

    public boolean verifyLogoutUrl() {
        return verifyUrl(new CredsLoader().getProperty("url"));
    }
}
