package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FleetsPage extends BasePage {
    private final By viewDeatilsButton = By.xpath("(//a[contains(text(),'View Details')])[1]");

    public FleetsPage(WebDriver driver) {
        super(driver);
    }

    public boolean clickViewDetailButton() {
        boolean result = false;
        result = isDisplayed(viewDeatilsButton);
        clickOnElement(viewDeatilsButton);
        return result;
    }
}
