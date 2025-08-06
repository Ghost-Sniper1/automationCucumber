//package automationCucumber;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.By;
//
//public class LoginFeat {
//
//    @Given("I am on the account page")
//    public void iAmOnTheAccountPage() {
//        Hooks.driver.get("https://askomdch.com/account");
//    }
//    @When("I enter {string} into the {string} field")
//    public void iEnterIntoTheField(String value, String fieldName) {
//        By fieldSelector;
//
//        switch (fieldName.toLowerCase()) {
//            case "username or email address ":
//                fieldSelector = By.id("username");
//                break;
//            case "password":
//                fieldSelector = By.id("password");
//                break;
//            default:
//                throw new IllegalArgumentException("Unsupported field name: " + fieldName);
//        }
//        Hooks.driver.findElement(fieldSelector).sendKeys(value);
//    }
//    @And("I click the {string} button")
//    public void iClickTheButton(String buttonText) {
//        By buttonSelector;
//
//        switch (buttonText.toLowerCase()) {
//            case "login":
//                buttonSelector = By.xpath("//button[normalize-space()='Log in']");
//                break;
//            default:
//                throw new IllegalArgumentException("Unsupported button text: " + buttonText);
//        }
//        Hooks.driver.findElement(buttonSelector).click();
//    }
//    @And("I navigate on the home page")
//    public void iNavigateOnTheHomePage() {
//        Hooks.driver.get("https://askomdch.com");
//    }
//
//    @Then("I should add the product {string} to the cart")
//    public void iShouldAddTheProductToTheCart(String productName) throws InterruptedException{
//        String selector = String.format("//a[@aria-label='Add “%s” to your cart']", productName);
//        Hooks.driver.findElement(By.xpath(selector)).click();
//    }
//}
