package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CredsLoader;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class CarsPage extends BasePage {
    private final By allCars = By.xpath("//div[@class='list_sec desktop_sc']//*[text()='Book Now ']");
    public final String filterOption = "//label[text()='%s']/preceding-sibling::input[@type=\"checkbox\"]";
    public final String filteredData = "//div[@class=\"list_sec desktop_sc\"]//p[text()='%s']";
    private final By totalCars = By.xpath("//div[@class=\"list_sec desktop_sc\"]//h1");
    public static String carNameValue;
    private final By unlimitedKm = By
            .xpath("(//*[text()='Book Now ']/../../../preceding-sibling::div[2]//p[text()='Unlimited'])[3]");
    private final By oneTwentyKmsPerDay = By.xpath("(//p[text()='120kms/day'])[3]");
    private final By modifiedLocation = By.xpath("//span[contains(text(),'Location')] ");
    public String modifiedCity = "//h4/following-sibling::ul//li//span[text()='%s']";
    public String yearDropDown = "//div[contains(text(),'%s')]/../following-sibling::button";
    public String yearButton = "//div[@role=\"radiogroup\"]//button[contains(text(),'%s')]";
    private final By previousMonth = By.xpath("//button[@title=\"Previous month\"]");
    private final By nextMonth = By.xpath("//button[@title=\"Next month\"]");
    public String day = "//button[text()='%s']";
    public UserHomePage userHomePage = new UserHomePage(driver);
    public static String previousModifiedDate;
    private final By modifySearchButton = By.xpath("//a[text()='Modify Search']");
    public static LocalDate modifiedFromGivenDate;
    public static LocalDate modifiedToGivenDate;

    public CarsPage(WebDriver driver) {
        super(driver);
    }

    public boolean clickBookNow() {
        boolean result = false;
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allCars));
        List<WebElement> cars = driver.findElements(allCars);
        //int value = getRandomNumberInRange(1,cars.size());
        int value = 6;
        waitUntilElementIsDisplayed(
                By.xpath(getDynamicPath("(//div[@class='list_sec desktop_sc']//div//h1)[%s]", String.valueOf(value))));
        carNameValue = driver
                .findElement(By.xpath(
                        getDynamicPath("(//div[@class='list_sec desktop_sc']//div//h1)[%s]", String.valueOf(value))))
                .getText();
        waitUntilElementIsDisplayed(By.xpath(getDynamicPath("(//*[text()='Book Now '])[%s]", String.valueOf(value))));
        result = isDisplayed(By.xpath(getDynamicPath("(//*[text()='Book Now '])[%s]", String.valueOf(value))));
        moveToElementAndClick(By.xpath(getDynamicPath("(//*[text()='Book Now '])[%s]", String.valueOf(value))));
        return result;
    }

    public boolean clickSubscriptionBookNowButton() {
        boolean result = false;
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allCars));
        List<WebElement> cars = driver.findElements(allCars);
        //int value = getRandomNumberInRange(1,cars.size());
        int value = 6;
        waitUntilElementIsDisplayed(
                By.xpath(getDynamicPath("(//div[@class='list_sec desktop_sc']//div//h1)[%s]", String.valueOf(value))));
        carNameValue = driver
                .findElement(By.xpath(
                        getDynamicPath("(//div[@class='list_sec desktop_sc']//div//h1)[%s]", String.valueOf(value))))
                .getText();
        waitUntilElementIsDisplayed(By.xpath(getDynamicPath("(//*[text()='Book Now '])[%s]", String.valueOf(value))));
        result = isDisplayed(By.xpath(getDynamicPath("(//*[text()='Book Now '])[%s]", String.valueOf(value))));
        moveToElementAndClick(By.xpath(getDynamicPath("(//*[text()='Book Now '])[%s]", String.valueOf(value))));
        return result;
    }

    public void clickUnlimitedKmButton() {
        moveToElementAndClick(unlimitedKm);
    }

    public void clickOneTwentyKmsPerDay() {
        moveToElementAndClick(oneTwentyKmsPerDay);
    }

    public void clickOnChooseFilterOption(String value) {
        try {

            String path = getDynamicPath(filterOption, value);
            Thread.sleep(3000);
            waitUntilElementIsDisplayed(By.xpath(path));
            moveToElementAndClick(By.xpath(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verifyFilterData(String fuelType, String transmissionType, String luggageValue,
                                    String seatingValue) {
        waitUntilAllElementIsDisplayed(totalCars);
        boolean result = false;
        String fuel = getDynamicPath(filteredData, fuelType);
        String transmission = getDynamicPath(filteredData, transmissionType);
        String luggage = getDynamicPath(filteredData, luggageValue);
        String Seating = getDynamicPath(filteredData, seatingValue);
        waitUntilAllElementIsDisplayed(By.xpath(fuel));
        waitUntilAllElementIsDisplayed(By.xpath(transmission));
        waitUntilAllElementIsDisplayed(By.xpath(luggage));
        waitUntilAllElementIsDisplayed(By.xpath(Seating));
        List<WebElement> fuelList = driver.findElements(By.xpath(fuel)).stream().collect(Collectors.toList());
        List<WebElement> transmissionList = driver.findElements(By.xpath(transmission)).stream()
                .collect(Collectors.toList());
        List<WebElement> luggageList = driver.findElements(By.xpath(luggage)).stream().collect(Collectors.toList());
        List<WebElement> SeatingList = driver.findElements(By.xpath(Seating)).stream().collect(Collectors.toList());
        List<WebElement> totalCarsList = driver.findElements(totalCars);
        if (fuelList.size() == totalCarsList.size() && transmissionList.size() == totalCarsList.size()
                && luggageList.size() == totalCarsList.size() && SeatingList.size() == totalCarsList.size()) {
            result = true;
        }
        return result;
    }

    public void clickModifiedCity(String city) {
        clickOnElement(modifiedLocation);
        waitUntilElementIsDisplayed(By.xpath(getDynamicPath(modifiedCity, city)));
        clickOnElement(By.xpath(getDynamicPath(modifiedCity, city)));
    }

    public void clickAndChooseModifiedYear(String defaultDate, String modifiedDate, String type)
            throws InterruptedException {
        if (type.equals("FROM")) {
            LocalDate defaultLocalDate = UserHomePage.fromGivenDate;
            LocalDate modifiedLocalFromDate = defaultLocalDate
                    .plusDays(Long.parseLong(new CredsLoader().getProperty("MODIFY_DAILY_PLUS_DAYS")));
            modifiedFromGivenDate = modifiedLocalFromDate;

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
            String defaultLocalMonthYear = defaultLocalDate.format(formatter);
            waitUntilElementIsDisplayed(By.xpath(getDynamicPath(yearDropDown, defaultLocalMonthYear)));
            clickOnElement(By.xpath(getDynamicPath(yearDropDown, defaultLocalMonthYear)));
            waitUntilElementIsDisplayed(
                    By.xpath(getDynamicPath(yearButton, String.valueOf(modifiedLocalFromDate.getYear()))));
            clickOnElement(By.xpath(getDynamicPath(yearButton, String.valueOf(modifiedLocalFromDate.getYear()))));
        } else if (type.equals("TO")) {
            LocalDate defaultLocalToDate = UserHomePage.toGivenDate;
            LocalDate modifiedLocalToDate = defaultLocalToDate
                    .plusDays(Long.parseLong(new CredsLoader().getProperty("MODIFY_DAILY_PLUS_DAYS")));
            modifiedToGivenDate = modifiedLocalToDate;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
            String defaultLocalMonthYear = defaultLocalToDate.format(formatter);
            waitUntilElementIsDisplayed(By.xpath(getDynamicPath(yearDropDown, defaultLocalMonthYear)));
            clickOnElement(By.xpath(getDynamicPath(yearDropDown, defaultLocalMonthYear)));
            waitUntilElementIsDisplayed(
                    By.xpath(getDynamicPath(yearButton, String.valueOf(modifiedLocalToDate.getYear()))));
            clickOnElement(By.xpath(getDynamicPath(yearButton, String.valueOf(modifiedLocalToDate.getYear()))));
        }
    }

    public void chooseModifiedMonth(String defaultDate, String modifiedDate, String type) {
        if (type.equals("FROM")) {

            LocalDate defaultLocalDate = UserHomePage.fromGivenDate;
            LocalDate modifiedLocalFromDate = modifiedFromGivenDate;
            int defaultMonth = defaultLocalDate.getMonthValue();
            int modifiedMonth = modifiedLocalFromDate.getMonthValue();
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
                clickOnElement(By.xpath(getDynamicPath(day, String.valueOf(modifiedLocalFromDate.getDayOfMonth()))));
            }

            clickOnElement(By.xpath(getDynamicPath(day, String.valueOf(modifiedLocalFromDate.getDayOfMonth()))));
        } else if (type.equals("TO")) {
            LocalDate defaultLocalToDate = UserHomePage.toGivenDate;
            LocalDate modifiedLocalToDate = modifiedToGivenDate;
            int defaultMonth = defaultLocalToDate.getMonthValue();
            int modifiedMonth = modifiedLocalToDate.getMonthValue();
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
                clickOnElement(By.xpath(getDynamicPath(day, String.valueOf(modifiedLocalToDate.getDayOfMonth()))));
            }
            clickOnElement(By.xpath(getDynamicPath(day, String.valueOf(modifiedLocalToDate.getDayOfMonth()))));
        }
    }

    public void selectModifiedTime(String time, String type) {
        userHomePage.selectTime(time, type);
    }

    public void clickModifySearchButton() {
        clickOnElement(modifySearchButton);
    }

}
