package pages;

import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CustomerinfoPage extends BasePage {
    private final By userName = By.xpath("//input[@name=\"firstName\"]");
    private final By lastName = By.xpath("//input[@name=\"lastName\"]");
    private final By dobTextbox = By.xpath("//input[@disabled=\"true\"]");
    private final By genderTextbox = By.xpath("//select[@name=\"gender\"]");
    private final By genderbox = By.xpath("(//div[@class=\"input-group\"])[3]");
    private final By nextButton = By.xpath("//button[text()=\"Next\"]");
    private final By documentVerification = By.xpath("//span[text()=\"Document Verification\"]");
    private final String documentTextbox = "//input[@placeholder='%s']";
    private final String documentValidateButton = "//input[@placeholder='%s']/following-sibling::button";
    private final By communicationAddress = By.xpath("//button[text()=\"Communication Address\"]");
    private final String addressDropDown = "//select[@name='%s']";
    private final By addressType = By.xpath("//select[@name=\"addreessType\"]");
    private final By state = By.xpath("//select[@name=\"state\"]");
    private final By pincode = By.xpath("//input[@name=\"pincode\"]");
    private final By address = By.xpath("//input[@name=\"address\"]");
    private final By saveButton = By.xpath("//button[text()=\"Save\"]");
    private final By checkOutButton = By.xpath("//button[text()=\"Proceed to checkout\"]");
    private final By agreeAndProceed = By.xpath("//button[contains(text(),'Agree & Proceed')]");
    private final By cancelPopup = By.xpath("//*[@aria-label='close']//*[name()='svg']");
    private final By totalAmount = By.xpath("//h6[text()='Total Amount']/following-sibling::h6");

    public CustomerinfoPage(WebDriver driver) {
        super(driver);
    }

    public void enterUserName(String name) {
        waitUntilElementIsDisplayed(userName);
        driver.findElement(userName).sendKeys(name);
    }

    public void enterLastName(String name) {
        waitUntilElementIsDisplayed(lastName);
        driver.findElement(lastName).sendKeys(name);
    }

    public void selectDobDate(String date) {
        sendValueToTextField(driver.findElement(dobTextbox), date, driver);
    }

    public void selectGender(String gender) {
        waitUntilElementIsDisplayed(genderTextbox);
        selectGender(gender);
    }

    public boolean clickNextButton() {
        boolean result = false;
        waitUntilElementIsDisplayed(nextButton);
        result = isDisplayed(nextButton);
        moveToElementAndClick(nextButton);
        return result;
    }

    public void clickDocumentVerification() {
        waitUntilElementIsDisplayed(documentVerification);
        moveToElementAndClick(documentVerification);
    }

    public boolean enterDocumentVerificationDetails(String data, String value) {
        String placeholderdata = "";
        boolean result = false;
        if (data.equals("PAN")) {

            placeholderdata = "Enter PAN Number";
            String path = getDynamicPath(documentTextbox, placeholderdata);
            waitUntilElementIsDisplayed(By.xpath(path));
            waitUntilElementIsDisplayed(By.xpath(path));
            String panvalue = driver.findElement(By.xpath(path)).getAttribute("value");
            if (panvalue.equals(value)) {
                return true;
            } else {
            }
        }
        return result;
    }

    public void clickCommunicationButton() {

        waitUntilElementIsDisplayed(communicationAddress);
        moveToElementAndClick(communicationAddress);
    }

    public void clickCommunicationDropDown(String data, String value) {
        if (data.equalsIgnoreCase("addreessType")) {

            selectFromDropDown(By.xpath(getDynamicPath(addressDropDown, "addreessType")), value);
        } else if (data.equalsIgnoreCase("state")) {
            selectFromDropDown(By.xpath(getDynamicPath(addressDropDown, "state")), value);
        }
    }

    public void enterPincodeAndAddress(String pincodeData, String addressData) throws InterruptedException {
        waitUntilElementIsDisplayed(pincode);
        Thread.sleep(1000);
        moveToElementAndClick(pincode);
        clearTextBox(driver.findElement(pincode));
        enterTextOnElement(pincode, pincodeData);
        waitUntilElementIsDisplayed(address);
        moveToElementAndClick(address);
        clearTextBox(driver.findElement(address));
        enterTextOnElement(address, addressData);
    }

    public void clickSaveButton() throws InterruptedException {
        waitUntilElementIsDisplayed(saveButton);
        moveToElementAndClick(saveButton);
        try {
            Thread.sleep(900);
        } catch (Exception e) {
            e.printStackTrace();
        }
        moveToElementAndClick(cancelPopup);
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean clickChechoutButton() {
        boolean result = false;
        waitUntilElementIsDisplayed(checkOutButton);
        result = isDisplayed(checkOutButton);
        moveToElementAndClick(checkOutButton);
        return result;
    }

    public boolean verifiUserDetails(String fname, String lname, String gender, String dob) {
        boolean result = false;
        waitUntilElementIsDisplayed(userName);
        waitUntilElementIsDisplayed(lastName);
        waitUntilElementIsDisplayed(genderTextbox);
        waitUntilElementIsDisplayed(dobTextbox);
        waitUntilElementIsDisplayed(totalAmount);
        String newtotalAmount = null;
        newtotalAmount = driver.findElement(totalAmount).getText().replace("₹", "\u20B9").split(" ")[1];
        if (driver.findElement(userName).getAttribute("value").toLowerCase().trim().equalsIgnoreCase(fname)
                && driver.findElement(lastName).getAttribute("value").toLowerCase().trim().equalsIgnoreCase(lname)
                && getSelectedValue(driver.findElement(genderTextbox)).contains(gender)
                && driver.findElement(dobTextbox).getAttribute("value").replace(" ", "").trim().contains(dob)
                && newtotalAmount.equals(BookSummaryPage.amount.replace("₹", "\u20B9").split(" ")[1])) {
            result = true;
        }
        return result;
    }

    public void enterDob(String value) {
        sendValueToTextField(driver.findElement(dobTextbox), value, driver);
    }

    public boolean verifiCommunicationAddress(String addresstype, String state1, String pincodevalue,
                                              String addressvalue) {
        boolean result = false;
        if (getSelectedValue(driver.findElement(addressType)).contains(addresstype)
                && getSelectedValue(driver.findElement(state)).contains(state1)
                && driver.findElement(pincode).getAttribute("value").contains(pincodevalue)
                && driver.findElement(address).getAttribute("value").contains(addressvalue)) {
            result = true;
        }
        return result;
    }

    public boolean clickAgreeAndProceed() {
        boolean result = false;
        waitUntilElementIsDisplayed(agreeAndProceed);
        result = isDisplayed(agreeAndProceed);
        clickOnElement(agreeAndProceed);
        return result;
    }
}
