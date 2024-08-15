package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SignInPage extends BasePage {
    private final By mobileNumberTextBox = By.xpath("//input[@type=\"tel\"]");
    private final By countryDropDownButton = By.xpath("//input[@type=\"tel\"]/following-sibling::div[1]/div");
    private final By loginButton = By.xpath("//button[contains(text(),'Login')]");

    public String countries = "//li/span[2]";
    private By otpTextBox = By.xpath("//input[@name=\"password\"]");
    private By validateButton = By.xpath("//button[contains(text(),'Validate')]");

    public final By otpSendNotificationCloseButton = By.xpath("//div[@id='custom-id-success']//button");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void enterMobileNumber(String number) {
        waitUntilElementIsDisplayed(mobileNumberTextBox);
        enterTextOnElement(mobileNumberTextBox, number);
    }

    public void clickLoginButton() {
        clickOnElement(loginButton);
    }

    public void clickAndSelectCountries(String country) {
        clickOnElement(countryDropDownButton);
        clickOnElement(By.xpath("//*[text()='India']"));
    }

    public void enterOtp(String otp) {
        enterTextOnElement(otpTextBox, otp);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickValidateButton() {
        clickOnElement(validateButton);
    }

    public boolean verifyNotification() throws InterruptedException {
        boolean result = false;
        return verifyElementIsDisplayed(otpSendNotificationCloseButton);
    }

    public void closeNotification() {
        clickOnElement(otpSendNotificationCloseButton);
    }

    public boolean verifyValidateButton() {
        return verifyElementIsDisplayed(validateButton);
    }

}
