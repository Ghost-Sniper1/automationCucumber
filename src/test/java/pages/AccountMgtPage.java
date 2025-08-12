package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountMgtPage extends BasePage {

    @FindBy(id = "reg_username")
    private WebElement regUsernameFld;

    @FindBy(id = "reg_email")
    private WebElement regEmailFld;

    @FindBy(id = "reg_password")
    private WebElement regPasswordFld;

    @FindBy(name = "register")
    private WebElement registerBtn;

    @FindBy(css = ".woocommerce-error li")
    private WebElement errorMessage;

    @FindBy(css = ".woocommerce")
    private WebElement dashboardText;

    public AccountMgtPage(WebDriver driver) {
        super(driver);
    }

    public AccountMgtPage enterRegUsername(String username) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(regUsernameFld));
        e.clear();
        e.sendKeys(username);
        return this;
    }

    public AccountMgtPage enterRegEmail(String email) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(regEmailFld));
        e.clear();
        e.sendKeys(email);
        return this;
    }

    public AccountMgtPage enterRegPassword(String password) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(regPasswordFld));
        e.clear();
        e.sendKeys(password);
        return this;
    }

    public AccountMgtPage clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerBtn)).click();
        return this;
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
    }

    public String getDashboardText() {
        return wait.until(ExpectedConditions.visibilityOf(dashboardText)).getText();
    }

    public AccountMgtPage load() {
        driver.get("https://askomdch.com/account");
        return this;
    }

    public AccountMgtPage setRegistrationDetails(String username, String email, String password) {
        return enterRegUsername(username)
                .enterRegEmail(email)
                .enterRegPassword(password);
    }
}