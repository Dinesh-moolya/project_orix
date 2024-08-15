package pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CredsLoader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserHomePage extends BasePage {
    private final By userName = By.xpath("//button[contains(text(),'Anil')]");
    private final By locationDropDownButton = By.xpath("//*[text()='Location']/img");

    public String popularCity = "//ul//li//span[contains(text(),'%s')]";
    private final By monthlySubscriptionSearch = By.xpath("//a[contains(text(),'Search')]");
    private final By selectedCity = By
            .xpath("//div[contains(text(),'Daily Rentals ')]/../../following-sibling::div//ul//li[1]/span/label");
    private final By monthlySelectedCity = By
            .xpath("//a[contains(text(),'Daily Rentals')]/../../following-sibling::div//ul//li[1]//label");
    private String yearDropDown = "//div[contains(text(),'%s')]/../following-sibling::button";
    public String yearButton = "//div[@role=\"radiogroup\"]//button[contains(text(),'%s')]";
    private final By previousMonth = By.xpath("//button[@title='Previous month']");
    private final By nextMonth = By.xpath("//button[@title='Next month']");
    private final By pickupdateButton = By.xpath("//span[contains(text(),'Pick-Up Date')]");
    private String day = "//div[@role='row']//button[text()='%s']";
    private final By hourUpArrowButton = By.xpath("(//div//i)[2]");
    private final By hourDownArrowButton = By.xpath("(//div//i)[3]");
    private final By minUpArrowButton = By.xpath("(//div//i)[4]");
    private final By minutes = By.xpath("//div[@class='min_edit']");
    private final By meridianArrowButton = By.xpath("(//div//i)[6]");
    private final By meridianValue = By.xpath("//div[@class=\"am_pm_edit\"]");
    private final By minutesValue = By.xpath("//div[@class='min_edit']");
    private final By hourValue = By
            .xpath("//h6[text()=\"Pick-up time\"]/following-sibling::div//div//div[@class=\"hour_edit\"]");
    private final By saveButton = By.xpath("//button[contains(text(),\"Save\")]");
    private final By returnSave = By.xpath("//button[text()=\"Save\"]");
    private final By returnHour = By.xpath("//div[@class='hour_edit']");
    private final By searchButton = By.xpath("//button[contains(text(),'Search')]");
    private final By monthlySubscription = By.xpath("//li//span[text()='Monthly Subscription']");
    private final By fleetButton = By.xpath("//a[contains(text(),'Fleets')]");
    private final By pickUpDateDropDown = By.xpath("//span[contains(text(),'Pick-Up Date')]");
    public static String prev;
    public static LocalDate futureDate;
    private final By faqs = By.xpath("//a[contains(text(),'FAQ’s')]");
    private final By contactUs = By.xpath("//a[normalize-space()='Contact Us']");
    private final By aboutUs = By.xpath("//a[normalize-space()=\'About Us\']");
    private final By fleets = By.xpath("//a[normalize-space()='Fleets']");
    private final By deals = By.xpath("//ul[@class='nav-links']//a[normalize-space()='Deals']");

    public static LocalDate fromGivenDate;
    public static LocalDate toGivenDate;
    public static LocalDate monthlyToGivenDate;

    private final By cancelPopup = By.xpath("//*[@aria-label='close']//*[name()='svg']");
    public static String getpicDate;
    private final By pickUpDateText = By.xpath("//span[text()='Pick-Up Date']/following-sibling::div");
    public static String dropDate;
    private final By dropDateText = By.xpath("//span[text()='Return Date']/following-sibling::div");

    public UserHomePage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyName(String name) {
        boolean result = false;
        waitUntilElementIsDisplayed(userName);
        if (driver.findElement(userName).getText().trim().equals(name)) {
            result = true;
        }
        return result;
    }

    public boolean verifyPickDateValue(String time) {
        waitUntilElementIsDisplayed(pickUpDateText);
        String date = driver.findElement(pickUpDateText).getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        LocalDate givenDate = UserHomePage.fromGivenDate;
        if (givenDate.format(formatter).equals(date.split(" ")[0])
                && date.split(" ")[1].concat(":" + date.split(" ")[2]).contains(time)) {
            return true;
        }
        return false;
    }

    public boolean verifyDropDateValue(String time) {
        waitUntilElementIsDisplayed(dropDateText);
        String date = driver.findElement(dropDateText).getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        LocalDate toDate = UserHomePage.toGivenDate;
        if (toDate.format(formatter).equals(date.split(" ")[0])
                && date.split(" ")[1].concat(":" + date.split(" ")[2]).contains(time)) {
            return true;
        }
        return false;
    }

    public boolean clickFleetButton() {
        boolean result = false;
        result = isDisplayed(fleetButton);
        clickOnElement(fleetButton);
        return result;
    }

    public void clickPickUpDropDown() {
        clickOnElement(pickUpDateDropDown);
    }

    public boolean clickMonthlySaerch() {
        boolean result = false;
        result = isDisplayed(monthlySubscriptionSearch);
        clickOnElement(monthlySubscriptionSearch);
        return result;
    }

    public void clickPickDate() {
        waitUntilElementIsDisplayed(pickupdateButton);
        clickOnElement(pickupdateButton);
    }

    public void clickLocationDropDownButton() {
        clickOnElement(locationDropDownButton);
    }

    public void closeNotificationPopUp() {
        if (isDisplayed(cancelPopup)) {
            wait.until(ExpectedConditions.elementToBeClickable(cancelPopup));

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            clickOnElement(cancelPopup);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void selectPopularCity(String city) {
        waitUntilElementIsDisplayed(By.xpath(getDynamicPath(popularCity, city)));
        clickOnElement(By.xpath(getDynamicPath(popularCity, city)));
    }

    public boolean clickMothlySubscription() {
        boolean result = false;
        waitUntilElementIsDisplayed(monthlySubscription);
        result = isDisplayed(monthlySubscription);
        clickOnElement(monthlySubscription);
        return result;
    }

    public boolean verifySelectedCity(String city) {
        boolean result = false;
        waitUntilElementIsDisplayed(selectedCity);
        if (driver.findElement(selectedCity).getText().trim().toLowerCase().contains(city.toLowerCase())) {
            result = true;
        }
        return result;
    }

    public boolean verifyMonthlySelectedCity(String city) {
        boolean result = false;
        waitUntilElementIsDisplayed(monthlySelectedCity);
        if (driver.findElement(monthlySelectedCity).getText().trim().toLowerCase().contains(city.toLowerCase())) {
            result = true;
        }
        return result;
    }

    public void clickAndChooseYear(String year, String type, String scheduleType) throws InterruptedException {
        // todays date
        LocalDate today = LocalDate.now();
        if (today.getDayOfMonth() == getDaysInMonthFunction(
                StringUtils.capitalize(String.valueOf(today.getMonth()).toLowerCase()),
                String.valueOf(today.getYear()))) {
            today = today.plusDays(1);
        }
        LocalDate givenLocalDate = today.plusDays(Long.parseLong(new CredsLoader().getProperty("DAILY_PLUS_DAYS")));

        if (scheduleType.equals("MONTHLY")) {
            monthlyToGivenDate = givenLocalDate
                    .plusDays(Long.parseLong(new CredsLoader().getProperty("MONTHLY_PLUS-DAYS")));
        }
        if (type.equals("FROM")) {
            // generating the dynamic xpath
            fromGivenDate = givenLocalDate;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
            String defaultLocalMonthYear = today.format(formatter);
            waitUntilElementIsDisplayed(By.xpath(getDynamicPath(yearDropDown, defaultLocalMonthYear)));
            clickOnElement(By.xpath(getDynamicPath(yearDropDown, defaultLocalMonthYear)));
            Thread.sleep(2000);
            waitUntilElementIsDisplayed(By.xpath(getDynamicPath(yearButton, String.valueOf(givenLocalDate.getYear()))));
            clickOnElement(By.xpath(getDynamicPath(yearButton, String.valueOf(givenLocalDate.getYear()))));
        }
        if (type.equals("TO")) {
            LocalDate defaultLocalDate = fromGivenDate;
            LocalDate givenLocaTolDate = defaultLocalDate.plusDays(5);
            toGivenDate = givenLocaTolDate;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
            String defaultLocalMonthYear = defaultLocalDate.format(formatter);
            waitUntilElementIsDisplayed(By.xpath(getDynamicPath(yearDropDown, defaultLocalMonthYear)));
            moveToElementAndClick(By.xpath(getDynamicPath(yearDropDown, defaultLocalMonthYear)));
            waitUntilElementIsDisplayed(
                    By.xpath(getDynamicPath(yearButton, String.valueOf(givenLocaTolDate.getYear()))));
            clickOnElement(By.xpath(getDynamicPath(yearButton, String.valueOf(givenLocaTolDate.getYear()))));
        }
    }

    public void selectMonthAndDate(String date, String type) throws InterruptedException {
        LocalDate today = LocalDate.now();
        if (today.getDayOfMonth() == getDaysInMonthFunction(
                StringUtils.capitalize(String.valueOf(today.getMonth()).toLowerCase()),
                String.valueOf(today.getYear()))) {
            today = today.plusDays(1);
        }
        LocalDate givenLocalDate = null;
        if (type.equals("FROM")) {
            givenLocalDate = fromGivenDate;
            int defaultMonth = today.getMonthValue();
            int modifiedMonth = givenLocalDate.getMonthValue();
            if (defaultMonth - modifiedMonth < 0) {
                for (int i = defaultMonth; i < modifiedMonth; i++) {
                    moveToElementAndClick(nextMonth);
                }
            } else if (defaultMonth - modifiedMonth > 0) {
                for (int i = modifiedMonth; i > defaultMonth; i--) {
                    clickOnElement(previousMonth);
                }
            }
            if (defaultMonth == modifiedMonth) {
            }
            Thread.sleep(1000);
            clickOnElement(By.xpath(getDynamicPath(day, String.valueOf(givenLocalDate.getDayOfMonth()))));
        }
        if (type.equals("TO")) {
            LocalDate defaultLocalDate = fromGivenDate;
            LocalDate givenLocaTolDate = null;
            givenLocaTolDate = toGivenDate;
            int defaultMonth = defaultLocalDate.getMonthValue();
            int modifiedMonth = givenLocaTolDate.getMonthValue();
            if (defaultMonth - modifiedMonth < 0) {
                for (int i = defaultMonth; i < modifiedMonth; i++) {
                    clickOnElement(nextMonth);
                }
            } else if (defaultMonth - modifiedMonth > 0) {
                for (int i = modifiedMonth; i > defaultMonth; i--) {
                    clickOnElement(previousMonth);
                }
            }
            if (defaultMonth == modifiedMonth) {
                clickOnElement(By.xpath(getDynamicPath(day, String.valueOf(givenLocaTolDate.getDayOfMonth()))));
            }
            clickOnElement(By.xpath(getDynamicPath(day, String.valueOf(givenLocaTolDate.getDayOfMonth()))));
        }
    }

    public void selectDay(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate newdate = LocalDate.parse(date, formatter);
        String userday = String.valueOf(newdate.getDayOfMonth());
        clickOnElement(By.xpath(getDynamicPath(day, userday)));
    }

    public void selectTime(String time, String type) {
        By data = null;
        if (type.equals("FROM")) {
            waitUntilElementIsDisplayed(hourValue);
            data = hourValue;
        } else if (type.equals("TO")) {
            waitUntilElementIsDisplayed(returnHour);
            data = returnHour;
        }
        int currentTime = Integer.parseInt(driver.findElement(data).getText());
        int giveTime = Integer.parseInt(time.split(":")[0]);
        int result = currentTime - giveTime;
        if (result > 0) {
            for (int i = currentTime; i > giveTime; i--) {
                clickOnElement(hourDownArrowButton);
            }
        } else if (result < 0) {
            for (int i = currentTime; i < giveTime; i++) {
                clickOnElement(hourUpArrowButton);
            }
        }
        waitUntilElementIsDisplayed(minutesValue);
        String currentMin = driver.findElement(minutesValue).getText();
        if (currentMin.equals(time.split(":")[1])) {

        } else {
            clickOnElement(minUpArrowButton);
        }
        waitUntilElementIsDisplayed(meridianValue);
        String currentMeridianValue = driver.findElement(meridianValue).getText();
        if (currentMeridianValue.equals(time.split(":")[2])) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clickOnElement(returnSave);
        } else {
            clickOnElement(meridianArrowButton);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clickOnElement(returnSave);
        }
    }

    public void clickSearchButton() {
        clickOnElement(searchButton);
    }

    public void clickFAQsButton() {
        clickOnElement(faqs);
    }

    public void clickContactUs() {
        clickOnElement(contactUs);
    }

    public void clickAboutUs() {
        clickOnElement(aboutUs);
    }

    public void clickFleet() {
        clickOnElement(fleets);
    }

    public void clickDeals() {
        clickOnElement(deals);
    }

}
