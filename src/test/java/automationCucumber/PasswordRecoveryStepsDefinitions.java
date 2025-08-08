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

import java.time.Duration;

public class PasswordRecoveryStepsDefinitions {

    private final WebDriver driver = DriverFactory.getDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("I am on the Account page for password recovery")
    public void iAmOnTheAccountPageForPasswordRecovery() {
        driver.get("https://askomdch.com/account");
    }

    @When("I click the {string} link")
    public void iClickTheLink(String lostPasswordLink) {
        By linkLocator = By.xpath("//a[normalize-space()='" + lostPasswordLink + "']");
        driver.findElement(linkLocator).click();
    }

    @And("I enter {string} into {string} field")
    public void iEnterIntoField(String userInput, String fieldLabel) {
        By fieldLocator;
        if (fieldLabel.equals("Username or email")) {
            fieldLocator = By.id("user_login");
        } else {
            throw new IllegalArgumentException("Unsupported field: " + fieldLabel);
        }
        driver.findElement(fieldLocator).clear();
        driver.findElement(fieldLocator).sendKeys(userInput);
    }

    @And("I click the {string} button to have my password reset")
    public void iClickTheButtonToHaveMyPasswordReset(String buttonLabel) {
        if (buttonLabel.equalsIgnoreCase("RESET PASSWORD")) {
            WebElement resetPasswordBtn = driver.findElement(By.xpath("//button[normalize-space()='Reset password']"));
            resetPasswordBtn.click();
        } else {
            throw new IllegalArgumentException("Unsupported button: " + buttonLabel);
        }
    }

    @Then("I should see a confirmation message")
    public void iShouldSeeAConfirmationMessage() {
        By confirmationMessageLocator = By.xpath("//div[@role='alert']");
        String expectedMessage = "Password reset email has been sent.";
        String actualMessage = driver.findElement(confirmationMessageLocator).getText();
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected message: '" + expectedMessage + "', but got: '" + actualMessage + "'");
        }
    }
}
