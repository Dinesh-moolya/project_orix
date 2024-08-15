package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.CredsLoader;

public class SignUpPage extends BasePage {
    private final By loginhereLink = By.xpath("//a[contains(text(),'Login here !')]");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginHereLink() {
        clickOnElement(loginhereLink);
    }

    public boolean verifySignInUrl() {
        return verifyUrl(new CredsLoader().getProperty("SIGNIN_PAGE"));
    }

}
