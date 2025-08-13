package pages;

import org.openqa.selenium.TimeoutException;
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

    @FindBy(css = ".woocommerce-MyAccount-content")
    private WebElement dashboardText;

    @FindBy(css = ".woocommerce")
    private WebElement altDashboard;

    @FindBy(id = "username")
    private WebElement loginUsernameFld;

    @FindBy(id = "password")
    private WebElement loginPasswordFld;

    @FindBy(name = "login")
    private WebElement loginBtn;

    @FindBy(xpath = "//a[normalize-space()='Lost your password?']")
    private WebElement forgotPasswordLink;

    @FindBy(id = "user_login")
    private WebElement userNameOrEmailFld;

    @FindBy(className = "woocommerce-Button button")
    private WebElement resetPasswordBtn;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement resetConfirmationAlert;

    @FindBy(xpath = "//ul[@class='woocommerce-error']//li")
    private WebElement resetErrorAlert;

    public AccountMgtPage(WebDriver driver) {
        super(driver);
    }

    public void load() {
        driver.get("https://askomdch.com/account");
    }

    /* Registration Methods */
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

    public void enterRegPassword(String password) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(regPasswordFld));
        e.clear();
        e.sendKeys(password);
    }

    public void clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerBtn)).click();
    }

    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
    }

    public String getDashboardText() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(dashboardText)).getText();
        } catch (TimeoutException e) {
            return wait.until(ExpectedConditions.visibilityOf(altDashboard)).getText();
        }
    }



    public void setRegistrationDetails(String username, String email, String password) {
        enterRegUsername(username)
                .enterRegEmail(email)
                .enterRegPassword(password);
    }

    /* Log In Methods */
    public AccountMgtPage enterLoginUsername(String username) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(loginUsernameFld));
        e.clear();
        e.sendKeys(username);
        return this;
    }

    public void enterLoginPassword(String password) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(loginPasswordFld));
        e.clear();
        e.sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public void setLoginDetails(String username, String password) {
        enterLoginUsername(username)
                .enterLoginPassword(password);
    }

    /* Password Recovery Methods */
    public void clickResetPasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink)).click();
    }

    public void enterEmailOrUsername(String userName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(userNameOrEmailFld));
        e.clear();
        e.sendKeys(userName);
    }

    public void clickResetButton(){
        wait.until(ExpectedConditions.visibilityOf(resetPasswordBtn)).click();
    }

    public String getResetConfirmationAlertText() {
        return wait.until(ExpectedConditions.visibilityOf(resetConfirmationAlert)).getText();
    }

    public String getResetErrorAlertText() {
        return wait.until(ExpectedConditions.visibilityOf(resetErrorAlert)).getText();
    }


}