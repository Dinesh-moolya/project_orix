package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import java.time.Duration;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAccessor;
import java.util.*;

public class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void goTo(String url) {
        driver.get(url);
    }

    public void clickOnElement(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    public boolean isDisplayed(By element) {
        boolean result = false;
        try {
            waitUntilElementIsDisplayed(element);
            result = driver.findElement(element).isDisplayed();
        } catch (Exception e) {
            System.out.println("element not found");
        }
        return result;
    }

    public void enterTextOnElement(By element, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(value);
    }

    public void moveToElementAndClick(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        WebElement webElement = driver.findElement(element);
        Actions act = new Actions(driver);
        act.moveToElement(webElement).click().build().perform();
    }

    public String getTextOnElement(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).getText();
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitUntilElementIsDisplayed(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public boolean verifyElementIsDisplayed(By element) {
        waitUntilElementIsDisplayed(element);
        return driver.findElement(element).isDisplayed();
    }

    public boolean verifyUrl(String url) {
        boolean result = false;

        wait.until(ExpectedConditions.urlToBe(url));
        if (driver.getCurrentUrl().equals(url)) {
            result = true;
        }
        return result;
    }

    public void enterTextUsingJS(WebDriver driver, WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value='" + text + "';", element);
    }

    public void clickUsingJS(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public void clickUsingJS(WebDriver driver, By element) {
        waitUntilElementIsDisplayed(element);
        WebElement element1 = driver.findElement(element);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element1);
    }

    public String getDynamicPath(String path, String value) {
        return String.format(path, value);
    }

    public String getCurrentMonthAndYear() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        String formattedDate = currentDate.format(formatter);
        return formattedDate;

    }

    public void waitUntilAllElementIsDisplayed(By element) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }

    public String getdateDetails(String dateData, String date) {
        String data = "";
        LocalDate currentDate = LocalDate.parse(date);

        if (dateData.equals("year")) {
            data = currentDate.getYear() + "";

        } else if (dateData.equals("month")) {
            data = currentDate.getMonth().toString();
        } else if (dateData.equals("day")) {
            data = currentDate.getDayOfMonth() + "";
        }
        return data;

    }

    public void waitForTextTobePresentInTextBox(By text, String value) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(text, value));
    }

    public void selectFromDropDown(By element, String value) {
        waitUntilElementIsDisplayed(element);
        Select select = new Select(driver.findElement(element));
        select.selectByVisibleText(value);
    }

    public String getSelectedValue(WebElement element) {
        Select select = new Select(element);
        WebElement selectedOption = select.getFirstSelectedOption();
        return selectedOption.getText();
    }

    public void sendValueToTextField(WebElement element, String data, WebDriver driver) {
        JavascriptExecutor javaScript = (JavascriptExecutor) driver;
        javaScript.executeScript("arguments[0].value='data';", element);
    }

    public String monthFormatter(String month) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("MMM");
        Date date = null;
        try {
            date = inputFormat.parse(month);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        SimpleDateFormat outputFormat = new SimpleDateFormat("MMMM");
        String formattedTime = outputFormat.format(date);
        return formattedTime;
    }

    public String getMonth(String abbreviatedMonth) {
        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMM", Locale.ENGLISH);
        String fullMonthName = null;
        try {
            TemporalAccessor parsedMonth = monthFormatter.parse(abbreviatedMonth);
            fullMonthName = Month.from(parsedMonth).getDisplayName(TextStyle.FULL, Locale.ENGLISH);
            System.out.println("Full month name: " + fullMonthName);
        } catch (DateTimeParseException e) {
            System.out.println("unparsable month: " + e.getMessage());
        }
        return fullMonthName;
    }

    public String timeFormatter(String time) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm:a");
        Date date = null;
        try {
            date = inputFormat.parse(time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        SimpleDateFormat outputFormat = new SimpleDateFormat("h:mm:a");
        String formattedTime = outputFormat.format(date);
        return formattedTime;
    }

    public String dayFormatter(String day) {
        String dateString = day; // Example date in "dd" format
        String result = "";
        try {
            // Parse the date string using SimpleDateFormat with "dd" pattern
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd");
            Date date = inputFormat.parse(dateString);

            // Format the parsed date using SimpleDateFormat with "d" pattern
            SimpleDateFormat outputFormat = new SimpleDateFormat("d");
            String formattedDate = outputFormat.format(date);

            System.out.println("Formatted date: " + formattedDate);
            result = formattedDate;
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
        return result;
    }

    public void clearTextBox(WebElement textbox) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '';", textbox);
    }

    public void uploadDocument(By element, String file) {
        driver.findElement(element).sendKeys(file);
    }

    public int getDaysInMonthFunction(String month, String year) {
        Map<String, Integer> MONTH_DAYS = new HashMap<>();
        MONTH_DAYS.put("January", 31);
        MONTH_DAYS.put("February", 28); // For non-leap years
        MONTH_DAYS.put("March", 31);
        MONTH_DAYS.put("April", 30);
        MONTH_DAYS.put("May", 31);
        MONTH_DAYS.put("June", 30);
        MONTH_DAYS.put("July", 31);
        MONTH_DAYS.put("August", 31);
        MONTH_DAYS.put("September", 30);
        MONTH_DAYS.put("October", 31);
        MONTH_DAYS.put("November", 30);
        MONTH_DAYS.put("December", 31);

        int year1 = Integer.parseInt(year);
        // boolean leapYear = isLeapYear(year1);
        Integer days = MONTH_DAYS.get(month);

        // Handle February in leap years
        if (month.equals("February") && isLeapYear(year1)) {
            days = 29;
        }
        // Return the number of days, or -1 if the month is invalid
        return (days != null) ? days : -1;
    }

    public boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }

    public int getRandomNumberInRange(int min, int max) {
        Random random = new Random();
        if (min > max) {
            throw new IllegalArgumentException("min must be less than or equal to max");
        }
        return random.nextInt((max - min) + 1) + min;
    }

}
