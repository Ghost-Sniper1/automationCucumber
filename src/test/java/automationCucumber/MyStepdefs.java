package automationCucumber;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class MyStepdefs {

    private final WebDriver driver = Hooks.driver;

    @Given("I'm on the Store page")
    public void i_m_on_the_store_page() {
        driver.get("https://askomdch.com/store");
    }

    @When("I add a {string} to the cart")
    public void i_add_a_product_to_the_cart(String productName) throws InterruptedException {
        String selector = String.format("//a[@aria-label='Add “%s” to your cart']", productName);
        driver.findElement(By.xpath(selector)).click();
        driver.findElement(By.cssSelector("a[title='View cart']")).click();
    }


    @Then("I should see {int} {string} in the cart")
    public void i_should_see_in_the_cart(int quantity, String productName) {
        By productNameField = By.cssSelector("td[class='product-name'] a");
        String actualProductName = driver.findElement(productNameField).getText();

        By productQuantityField = By.cssSelector("input[type='number']");
        String actualQuantity = driver.findElement(productQuantityField).getAttribute("value");

        Assert.assertEquals(productName, actualProductName);
        Assert.assertEquals(quantity, Integer.parseInt(actualQuantity));
    }


    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {
        driver.get("https://askomdch.com/store");
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() throws InterruptedException {
        String selector = "a[aria-label='Add “Blue Shoes” to your cart']";
        driver.findElement(By.cssSelector(selector)).click();
        Thread.sleep(3000);
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
    public void i_place_an_order() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("place_order"))).click();
    }

    @Then("The order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        By confirmationMessage = By.cssSelector(".woocommerce-thankyou-order-received");

        String actualMessage = wait
                .until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage))
                .getText().trim();

        String expectedMessage = "Thank you. Your order has been received.";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

}
