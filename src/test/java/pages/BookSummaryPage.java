package pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookSummaryPage extends BasePage {

    private final By pickupLocation = By
            .xpath("//p[contains(text(),\"Pickup Location | Time | Charges\")]/following-sibling::button");
    private final By dropLocation = By
            .xpath("//p[contains(text(),\"Drop Location | Time | Charges\")]/following-sibling::button");
    private final String locationPopUp = "//tr//div[contains(text(),'%s')]";
    private final By addressTextBox = By
            .xpath("//p[text()=\"Pickup Location | Time | Charges\"]/following-sibling::div/textarea");
    private final By proceedButton = By.xpath("//button[text()=\"Proceed\"]");
    private final String promoCode = "(//p[contains(text(),'Select A Promo Code')]/following-sibling::table//td[3])[1]";
    private final By promoCodeButton = By.xpath("//input[@placeholder='Promo Code']");
    private final By pickupDateTime = By
            .xpath("(//h3[contains(text(),\"Location:\")]/following-sibling::div/div/p)[1]");
    private final By dropDateTime = By.xpath("(//h3[contains(text(),\"Location:\")]/following-sibling::div/div/p)[4]");

    private final By totalAmount = By.xpath("//h1[contains(text(),'Total Amount')]/following-sibling::h1/span");
    public static String amount;
    private final String Charges = "(//p[contains(text(),'Rental Charges')]/../../following-sibling::div/p)[%s]";
    private final By closePromoPopup = By
            .xpath("//h5[contains(text(),'Available Promo Codes')]/following-sibling::button/button");
    private final By carName = By.xpath("//div[@class=\"car_detail car_pic\"]//div//h1");
    private final By nearByLocationCost = By
            .xpath("//td[contains(text(),'Nearby Locations')]/following-sibling::td[2]");
    private final By doorStepDeliveryCost = By
            .xpath("//td[contains(text(),'Doorstep Delivery ')]/following-sibling::td[2]");
    private final By airPortLocation = By.xpath("//td[contains(text(),'Airport Locations ')]/following-sibling::td[2]");
    public String location = "//*[contains(text(),'%s')]";
    private final By termAndCondition = By.xpath("//label[contains(text(),'I agree to the')]/preceding-sibling::input");
    private final By luggageCheckBox = By
            .xpath("//label[contains(text(),'Luggage carrier (Subject to availability)')]/preceding-sibling::input");
    private final By tripProtectionCheckBox = By
            .xpath("//label[contains(text(),'Trip Protection Plan')]/preceding-sibling::input");

    private final By dropTextBox = By
            .xpath("//p[text()=\"Drop Location | Time | Charges\"]/following-sibling::div/textarea");

    public static double pickupAndDropCharges = 0;
    public static double pickUpCharges = 0;
    public static double dropCharges = 0;

    public static String getPickUpAddress;
    public static String getDropAddress;

    public static String newDate;

    public BookSummaryPage(WebDriver driver) {
        super(driver);
    }

    public String getPicUpAddress() {
        waitUntilElementIsDisplayed(addressTextBox);
        return driver.findElement(addressTextBox).getText();
    }

    public String getDropAddress() {
        waitUntilElementIsDisplayed(dropTextBox);
        return driver.findElement(dropTextBox).getText();
    }

    public void selectPickupLocation(String chossenLocation, String address) throws InterruptedException {
        waitUntilElementIsDisplayed(pickupLocation);
        clickOnElement(pickupLocation);
        String selectedLocation = getDynamicPath(locationPopUp, chossenLocation);
        Thread.sleep(1000);
        waitUntilElementIsDisplayed(By.xpath(selectedLocation));
        waitUntilElementIsDisplayed(By.xpath(selectedLocation));
        clickOnElement(By.xpath(selectedLocation));
        waitForTextTobePresentInTextBox(addressTextBox, address);
    }

    public void selectDropLocation(String choosenLocation, String address) {
        waitUntilElementIsDisplayed(dropLocation);
        clickOnElement(dropLocation);
        String selectedLocation = getDynamicPath(locationPopUp, choosenLocation);
        waitUntilElementIsDisplayed(By.xpath(selectedLocation));
        waitUntilElementIsDisplayed(By.xpath(selectedLocation));
        clickOnElement(By.xpath(selectedLocation));
        waitForTextTobePresentInTextBox(addressTextBox, address);
    }

    public String getAddress() {
        waitUntilElementIsDisplayed(addressTextBox);
        return driver.findElement(addressTextBox).getText();
    }

    public String getDoorStepDropAddress() {
        waitUntilElementIsDisplayed(dropTextBox);
        return driver.findElement(dropTextBox).getText();
    }

    public boolean clickProceedButton() {
        boolean result = false;
        waitUntilElementIsDisplayed(totalAmount);
        amount = driver.findElement(totalAmount).getText();
        waitUntilElementIsDisplayed(proceedButton);
        result = isDisplayed(totalAmount);
        moveToElementAndClick(proceedButton);
        return result;
    }

    public boolean clickPromoCode(String promocodeData) {
        boolean result = false;
        waitUntilElementIsDisplayed(promoCodeButton);
        result = isDisplayed(promoCodeButton);
//        scrollToElement(driver,driver.findElement(promoCodeButton));
        moveToElementAndClick(promoCodeButton);
//        waitUntilElementIsDisplayed(By.xpath(promoCode));
//        clickOnElement(By.xpath(promoCode));
        closePopUp();
        return result;

    }

    public boolean verifyPickupDateTime(String date) {
        boolean result = false;
        newDate = date;
        waitUntilElementIsDisplayed(nearByLocationCost);
        waitUntilElementIsDisplayed(nearByLocationCost);
        pickUpCharges = Double
                .parseDouble(driver.findElement(nearByLocationCost).getText().replace("₹", "\u20B9").split(" ")[1]);
        System.out.println("charges %%%%%%" + pickUpCharges);
        try {
            Thread.sleep(2000);
            waitUntilElementIsDisplayed(pickupDateTime);
            waitUntilElementIsDisplayed(dropDateTime);
            String pickupDateValue = driver.findElement(pickupDateTime).getText().split(",")[1];
            String dropDateValue = driver.findElement(dropDateTime).getText().split(",")[1];
            System.out.println(getdateDetails("day", date) + "****" + getdateDetails("month", date) + "*****"
                    + getdateDetails("year", date));
            System.out.println(pickupDateValue.split(" ")[1] + "****" + pickupDateValue.split(" ")[2] + "****"
                    + pickupDateValue.split(" ")[3]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean verifyPickupAndDropDateTime(String pickup, String drop) {
        waitUntilElementIsDisplayed(nearByLocationCost);
        waitUntilElementIsDisplayed(nearByLocationCost);
        dropCharges = Double
                .parseDouble(driver.findElement(nearByLocationCost).getText().replace("₹", "\u20B9").split(" ")[1]);
        boolean result = false;
        waitUntilElementIsDisplayed(pickupDateTime);
        waitUntilElementIsDisplayed(dropDateTime);
        String pickupDateValue = driver.findElement(pickupDateTime).getText().split(",")[1];
        String dropDateValue = driver.findElement(dropDateTime).getText().split(",")[1];
        if (getdateDetails("day", pickup).contains(pickupDateValue.split(" ")[1])
                && StringUtils.capitalize(getdateDetails("month", pickup).toLowerCase())
                .equalsIgnoreCase(StringUtils.capitalize(pickupDateValue.split(" ")[2]))
                && getdateDetails("day", drop).contains(dropDateValue.split(" ")[1])
                && StringUtils.capitalize(getdateDetails("month", drop).toLowerCase())
                .startsWith(StringUtils.capitalize(dropDateValue.split(" ")[2]))) {
            result = true;
        }
        return result;
    }

    public String verifyTotalCharges(String subscriptionType, String pickUpLocation) {
        boolean result = false;
        double locationCharges = 0;
        String value;
        double refundableValue;
        waitUntilElementIsDisplayed(totalAmount);
        if (subscriptionType.equals("DAILY")) {
            waitUntilElementIsDisplayed(totalAmount);
            amount = driver.findElement(totalAmount).getText().replace("₹", "\u20B9").split(" ")[1].replace(",", "");
        }
        if (subscriptionType.equals("MONTHLY")) {
            waitUntilElementIsDisplayed(totalAmount);
            amount = driver.findElement(totalAmount).getText().replace("₹", "\u20B9").split(" ")[1].replace(",", "");
        }
        return amount;
    }

    public void closePopUp() {
        waitUntilElementIsDisplayed(closePromoPopup);
        clickOnElement(closePromoPopup);
    }

    public boolean verifyCarName() {
        boolean result = false;
        waitUntilElementIsDisplayed(carName);
        String car = driver.findElement(carName).getText();
        if (car.equals(CarsPage.carNameValue.toUpperCase())) {
            result = true;
        }
        return result;
    }

    public void chooseLocation(String choosenLocation) {
        waitUntilElementIsDisplayed(pickupLocation);
        clickOnElement(pickupLocation);
        waitUntilElementIsDisplayed(By.xpath(getDynamicPath(location, choosenLocation)));
        clickOnElement(By.xpath(getDynamicPath(location, choosenLocation)));
    }

    public boolean clickLuggageAndTripProtectionPlan() throws InterruptedException {

        boolean result = false;
        Thread.sleep(2000);
        scrollToElement(driver.findElement(luggageCheckBox));

        wait.until(ExpectedConditions.elementToBeClickable(luggageCheckBox));
        clickUsingJS(driver, luggageCheckBox);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(tripProtectionCheckBox));
        result = isDisplayed(tripProtectionCheckBox);
        clickUsingJS(driver, tripProtectionCheckBox);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        moveToElementAndClick(termAndCondition);
        return result;
    }

    public void selectPickUpDoorStepDeliveryLocation(String chossenLocation, String address) {
        waitUntilElementIsDisplayed(pickupLocation);
        clickOnElement(pickupLocation);
        String selectedLocation = getDynamicPath(locationPopUp, chossenLocation);
        waitUntilElementIsDisplayed(By.xpath(selectedLocation));
        waitUntilElementIsDisplayed(By.xpath(selectedLocation));
        clickOnElement(By.xpath(selectedLocation));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitUntilElementIsDisplayed(addressTextBox);
        clickOnElement(addressTextBox);
        enterTextUsingJS(driver, driver.findElement(addressTextBox), address);
        driver.findElement(addressTextBox).sendKeys(Keys.ENTER);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectDropDoorStepDeliveryLocation(String choosenLocation, String address) {
        waitUntilElementIsDisplayed(dropLocation);
        clickOnElement(dropLocation);
        String selectedLocation = getDynamicPath(locationPopUp, choosenLocation);
        waitUntilElementIsDisplayed(By.xpath(selectedLocation));
        waitUntilElementIsDisplayed(By.xpath(selectedLocation));
        clickOnElement(By.xpath(selectedLocation));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitUntilElementIsDisplayed(dropTextBox);
        clickOnElement(dropTextBox);
        enterTextUsingJS(driver, driver.findElement(dropTextBox), address);
        driver.findElement(dropTextBox).sendKeys(Keys.ENTER);
        driver.findElement(dropTextBox).sendKeys(Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
