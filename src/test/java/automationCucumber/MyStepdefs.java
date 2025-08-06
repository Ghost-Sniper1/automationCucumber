package automationCucumber;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class MyStepdefs {

    private final WebDriver driver = Hooks.driver;


    // Add to Cart Steps Definition
    @Given("I'm on the Store page")
    public void iMOnTheStorePage() {
        driver.get("https://askomdch.com/store");
    }

    @When("I add a {string} to the cart")
    public void iAddAToTheCart(String productName) throws InterruptedException {
        By addToCartButton = By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
        driver.findElement(addToCartButton).click();
        By viewCartButton = By.cssSelector("a[title='View cart']");
        Thread.sleep(5000);
        driver.findElement(viewCartButton).click();
    }


    @Then("I should see {int} {string} in the cart")
    public void iShouldSeeInTheCart(int quantity, String productName) {
        By productNameField = By.cssSelector("td.product-name a");
        String actualProductName = driver.findElement(productNameField).getText();

        By productQuantityField = By.cssSelector("input[type='number']");
        String actualQuantity = driver.findElement(productQuantityField).getAttribute("value");

        Assert.assertEquals(actualProductName, productName);
        Assert.assertEquals(Integer.parseInt(actualQuantity), quantity);
    }


    // Guest Customer Make an Order Steps Definition
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
    public void i_place_an_order() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Wait for presence (element is in the DOM)
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("place_order")));

        // Wait for clickable and then click
        wait.until(ExpectedConditions.elementToBeClickable(By.id("place_order"))).click();
    }


    @Then("The order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        By confirmationMessage = By.xpath("//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']");

        String actualMessage = wait
                .until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage))
                .getText().trim();

        String expectedMessage = "Thank you. Your order has been received.";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

}
