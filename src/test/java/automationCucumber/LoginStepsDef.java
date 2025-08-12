package automationCucumber;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AccountMgtPage;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LoginStepsDef {

    private final WebDriver driver = DriverFactory.getDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    private final AccountMgtPage accountMgtPage = new AccountMgtPage(driver);
    private String username, password;

    // Step Definitions for Login Feature
    @Given("I am on the Account page for login")
    public void iAmOnTheAccountPageForLogin() {
//        driver.get("https://askomdch.com/account");

        /* POM Implementation for login */
        accountMgtPage.load();
    }

    @When("I enter {string} into the {string} field for login")
    public void iEnterIntoTheFieldForLogin(String inputValue, String fieldLabel) {
//        WebElement field;
//        switch (fieldLabel) {
//            case "Username or email address":
//                field = driver.findElement(By.id("username"));
//                break;
//            case "Password":
//                field = driver.findElement(By.id("password"));
//                break;
//            default:
//                throw new IllegalArgumentException("Unsupported field: " + fieldLabel);
//        }
//        field.clear();
//        field.sendKeys(inputValue);

        /* POM Implementation for login */
        switch (fieldLabel.toLowerCase()){
            case "username or email address":
                username = inputValue;
                break;
                case "password":
                    password = inputValue;
                    accountMgtPage.setLoginDetails(username, password);
                    break;
            default:
                throw new IllegalArgumentException("Unsupported field: " + fieldLabel);
        }
    }


    @And("I click the {string} button for regular login")
    public void iClickTheButtonForRegularLogin(String buttonLabel) {
//        if (buttonLabel.equalsIgnoreCase("LOG IN")) {
//            WebElement loginButton = driver.findElement(By.name("login"));
//            loginButton.click();
//        } else {
//            throw new IllegalArgumentException("Unsupported button: " + buttonLabel);
//        }

        /* POM Implementation for login */
        if (buttonLabel.equalsIgnoreCase("LOG IN")) {
            accountMgtPage.clickLoginButton();
        }else{
            throw new IllegalStateException("Unsupported button label: " + buttonLabel);
        }
    }
    @Then("I should be redirected to the {string} page as an authenticated user")
    public void iShouldBeRedirectedToThePageAsAnAuthenticatedUser(String expectedPageName) {
//        WebElement accountContent = driver.findElement(By.cssSelector(".woocommerce-MyAccount-content"));
//        String contentText = accountContent.getText().toLowerCase();
//
//        boolean containsGreeting = contentText.contains("hello") && contentText.contains("log out");
//        Assert.assertTrue(containsGreeting, "User is not authenticated or not on the 'My account' page.");

         /* POM Implementation for login */
        String dashboardText = accountMgtPage.getDashboardText().toLowerCase();
        Assert.assertTrue(dashboardText.contains("hello") && dashboardText.contains("log out"),
                "User is not authenticated or not on the 'My account' page.");

    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String expectedOutput) {
//        By errorMessage = By.cssSelector("ul[role='alert'] li");
//        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
//        String errorText = errorElement.getText();
//        assertEquals(expectedOutput, errorText);

        /* POM Implementation for login */
        Assert.assertEquals(accountMgtPage.getErrorMessage().trim(), expectedOutput,
                "Error message doesn't match expected output");
    }

}
