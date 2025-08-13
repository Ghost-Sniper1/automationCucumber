package automationCucumber;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AccountMgtPage;

import java.time.Duration;

public class PasswordRecoveryStepsDefinitions {

    private final WebDriver driver = DriverFactory.getDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    private final AccountMgtPage accountMgtPage = new AccountMgtPage(driver);

    @Given("I am on the Account page for password recovery")
    public void iAmOnTheAccountPageForPasswordRecovery() {
//        driver.get("https://askomdch.com/account");

        /* POM Implementation for Password Recovery */
        accountMgtPage.load();

    }

    @When("I click the {string} link")
    public void iClickTheLink(String lostPasswordLink) {
//        By linkLocator = By.xpath("//a[normalize-space()='" + lostPasswordLink + "']");
//        driver.findElement(linkLocator).click();

        /* POM Implementation for Password Recovery */
        accountMgtPage.clickResetPasswordButton();

    }

    @And("I enter {string} into {string} field")
    public void iEnterIntoField(String userInput, String fieldLabel) {
//        By fieldLocator;
//        if (fieldLabel.equals("Username or email")) {
//            fieldLocator = By.id("user_login");
//        } else {
//            throw new IllegalArgumentException("Unsupported field: " + fieldLabel);
//        }
//        driver.findElement(fieldLocator).clear();
//        driver.findElement(fieldLocator).sendKeys(userInput);

        /* POM Implementation for Password Recovery */
        if (fieldLabel.equals("Username or email")){
            accountMgtPage.enterEmailOrUsername(userInput);
        }
        else {
            throw new IllegalArgumentException("Unsupported field label: " + fieldLabel);
        }
    }

    @And("I click the {string} button to have my password reset")
    public void iClickTheButtonToHaveMyPasswordReset(String buttonLabel) {
//        if (buttonLabel.equalsIgnoreCase("RESET PASSWORD")) {
//            WebElement resetPasswordBtn = driver.findElement(By.xpath("//button[normalize-space()='Reset password']"));
//            resetPasswordBtn.click();
//        } else {
//            throw new IllegalArgumentException("Unsupported button: " + buttonLabel);
//        }

        /* POM Implementation for Password Recovery */
        if (buttonLabel.equalsIgnoreCase("RESET PASSWORD")) {
            accountMgtPage.clickResetPasswordButton();
        } else {
            throw new IllegalArgumentException("Unsupported button: " + buttonLabel);
        }
    }

    @Then("I should see a confirmation message")
    public void iShouldSeeAConfirmationMessage() {
//        By confirmationMessageLocator = By.xpath("//div[@role='alert']");
//        String expectedMessage = "Password reset email has been sent.";
//        String actualMessage = driver.findElement(confirmationMessageLocator).getText();
//        if (!actualMessage.equals(expectedMessage)) {
//            throw new AssertionError("Expected message: '" + expectedMessage + "', but got: '" + actualMessage + "'");
//        }

        /* POM Implementation for Password Recovery */
        String expectedMessage = "Password reset email has been sent.";
        String actualMessage = accountMgtPage.getResetConfirmationAlertText();
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected message: '" + expectedMessage + "', but got: '" + actualMessage + "'");
        }
    }


    @Then("I should see the error message {string}")
    public void iShouldSeeTheErrorMessage(String expectedMessage) {
//        By errorMessageLocator = By.xpath("//ul[@class='woocommerce-error']//li");
//        String actualMessage = wait.until(driver -> driver.findElement(errorMessageLocator)).getText().trim();
//        if (!actualMessage.equals(expectedMessage)) {
//            throw new AssertionError("Expected error message: '" + expectedMessage + "', but got: '" + actualMessage + "'");
//        }

        /* POM Implementation for Password Recovery */
        String actualMessage = accountMgtPage.getResetErrorAlertText();
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected error message: '" + expectedMessage + "', but got: '" + actualMessage + "'");
        }
    }
}
