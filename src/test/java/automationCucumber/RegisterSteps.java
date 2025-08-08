package automationCucumber;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RegisterSteps {
        private final WebDriver driver = DriverFactory.getDriver();
        private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        @Given("I am on the account page")
        public void iAmOnTheAccountPage() {
            driver.get("https://askomdch.com/account");
        }

        @When("I enter {string} into the {string} field")
        public void i_enter_into_the_field(String value, String fieldName) {
            By fieldSelector;

            switch (fieldName.toLowerCase()) {
                case "username":
                    fieldSelector = By.id("reg_username");
                    break;
                case "email address":
                    fieldSelector = By.id("reg_email");
                    break;
                case "password":
                    fieldSelector = By.id("reg_password");
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported field name: " + fieldName);
            }

            WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(fieldSelector));
            field.clear();
            field.sendKeys(value);
        }

        @And("I click the {string} button")
        public void i_click_the_button(String buttonText) {
            By registerButton = By.cssSelector("button[name='register']");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
        }

        @Then("I should be redirected to my personal dashboard")
        public void i_should_be_redirected_to_my_personal_dashboard() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            By dashboardPage = By.xpath("//div[@class='woocommerce']");

            String dashboardText = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(dashboardPage))
                    .getText().toLowerCase();

            Assert.assertTrue(dashboardText.contains("hello"), "Dashboard greeting not found.");
        }

    @Then("I should see the registration error message {string}")
    public void iShouldSeeTheRegistrationErrorMessage(String expectedMessage) {
        By errorMessageLocator = By.xpath("//ul[contains(@class,'woocommerce-error')]//li");
        String actualMessage = wait.until(driver -> driver.findElement(errorMessageLocator)).getText().trim();
        if (!actualMessage.equals(expectedMessage)) {
            throw new AssertionError("Expected error message: '" + expectedMessage + "', but got: '" + actualMessage + "'");
        }
    }
}