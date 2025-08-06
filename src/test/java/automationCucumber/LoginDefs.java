//package automationCucumber;
//
//import io.cucumber.java.en.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//
//public class LoginDefs {
//
//    private final WebDriver driver = Hooks.driver;
//
//    @Given("I am on the Account page")
//    public void i_am_on_the_account_page() {
//        driver.get("https://askomdch.com/account");
//    }
//
//    @When("I enter {string} into the {string} field")
//    public void iEnterIntoTheField(String inputValue, String fieldLabel) {
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
//    }
//
//    @And("I click the {string} button")
//    public void iClickTheButton(String buttonLabel) {
//        if (buttonLabel.equalsIgnoreCase("LOG IN")) {
//            WebElement loginButton = driver.findElement(By.name("login"));
//            loginButton.click();
//        } else {
//            throw new IllegalArgumentException("Unsupported button: " + buttonLabel);
//        }
//    }
//
//    @Then("I should be redirected to the {string} page as an authenticated user")
//    public void iShouldBeRedirectedToThePageAsAnAuthenticatedUser(String expectedPageName) {
//        WebElement accountContent = driver.findElement(By.cssSelector(".woocommerce-MyAccount-content"));
//        String contentText = accountContent.getText().toLowerCase();
//
//        boolean containsGreeting = contentText.contains("hello") && contentText.contains("log out");
//        Assert.assertTrue(containsGreeting, "User is not authenticated or not on the 'My account' page.");
//    }
//}