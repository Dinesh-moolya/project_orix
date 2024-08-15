package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CredsLoader;
import utilities.PropertyUtils;

import java.time.Duration;
import java.time.LocalDate;

public class HomePage extends BasePage {
    private final By loginOrSignupButton = By.xpath("//a[contains(text(),'Login')] ");
    private final By recieveNotificationButton = By.xpath("alt=\"Please Click on allow\"");
    private final By closeButtom = By.xpath("//div[@id=\"nvpush_cross\"]");

    public HomePage(WebDriver driver) {
        super(driver);

    }

    public void enterUrl() {
        goTo(new CredsLoader().getProperty("url"));
    }

    public boolean verifyHomePageUrl() {
        return verifyUrl(new CredsLoader().getProperty("HOME_PAGE"));
    }

    public boolean verifyLoginOrSignupButton() {
        return verifyElementIsDisplayed(loginOrSignupButton);
    }

    public boolean verifySignUpUrl() {
        return verifyUrl(new CredsLoader().getProperty("SIGNUP_PAGE"));
    }

    public void clickLoginOrSignupButton() {
        waitUntilElementIsDisplayed(loginOrSignupButton);
        clickOnElement(loginOrSignupButton);
    }

    public boolean verifyLogoutUrl() {
        return verifyUrl(new CredsLoader().getProperty("url"));
    }

}
