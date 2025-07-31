package automationCucumber;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class MyStepdefs {

    private final WebDriver driver = Hooks.driver;

    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {
        driver.get("https://askomdch.com/store");
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() throws InterruptedException {
        String selector = "a[aria-label='Add “Blue Shoes” to your cart']";
        driver.findElement(By.cssSelector(selector)).click();
        Thread.sleep(3000);  // Replace with explicit wait if possible
        driver.findElement(By.cssSelector("a[title='View cart']")).click();
    }

    @And("I'm on the checkout page")
    public void iMOnTheCheckoutPage() {
        driver.findElement(By.cssSelector(".checkout-button")).click();
    }

    @Then("I provide billing details")
    public void iProvideBillingDetails(List<Map<String, String>> billingDetails) {
        Map<String, String> data = billingDetails.get(0);

        driver.findElement(By.id("billing_first_name")).clear();
        driver.findElement(By.id("billing_first_name")).sendKeys(data.get("firstname"));

        driver.findElement(By.id("billing_last_name")).clear();
        driver.findElement(By.id("billing_last_name")).sendKeys(data.get("lastname"));

        driver.findElement(By.id("billing_address_1")).clear();
        driver.findElement(By.id("billing_address_1")).sendKeys(data.get("address_line1"));

        driver.findElement(By.id("billing_city")).clear();
        driver.findElement(By.id("billing_city")).sendKeys(data.get("city"));

        Select stateSelect = new Select(driver.findElement(By.id("billing_state")));
        stateSelect.selectByVisibleText(data.get("state"));

        driver.findElement(By.id("billing_postcode")).clear();
        driver.findElement(By.id("billing_postcode")).sendKeys(data.get("zip"));

        driver.findElement(By.id("billing_email")).clear();
        driver.findElement(By.id("billing_email")).sendKeys(data.get("email"));
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        driver.findElement(By.id("place_order")).click();
    }

    @Then("The order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        String expectedMessage = "Thank you. Your order has been received.";
        String actualMessage = driver.findElement(By.cssSelector(".woocommerce-notice")).getText().trim();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    // You can also keep your Add to Cart steps here or in another class
}
