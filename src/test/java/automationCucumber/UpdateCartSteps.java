package automationCucumber;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class UpdateCartSteps {
    private final WebDriver driver = DriverFactory.getDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));





    @Then("The order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
        By confirmationMessage = By.xpath("//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']");
        String actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage))
                .getText().trim();

        String expectedMessage = "Thank you. Your order has been received.";
        Assert.assertEquals(actualMessage, expectedMessage);
    }






    @When("I update the quantity of {string} in the cart to {int}")
    public void iUpdateTheQuantityOfInTheCartTo(String productName, int newQuantity) {
        if (newQuantity <= 0) {
            throw new IllegalArgumentException("Quantity must be at least 1 — received: " + newQuantity);
        }

        // Locate the quantity input related to the product name
        String xpath = "//td[@class='product-name']//a[normalize-space()='" + productName + "']/ancestor::tr//input[@type='number']";
        By quantityField = By.xpath(xpath);

        wait.until(ExpectedConditions.visibilityOfElementLocated(quantityField));
        driver.findElement(quantityField).clear();
        driver.findElement(quantityField).sendKeys(String.valueOf(newQuantity));

        // Click the "Update cart" button
        By updateCartButton = By.xpath("//button[normalize-space()='Update cart']");
        wait.until(ExpectedConditions.elementToBeClickable(updateCartButton)).click();
    }



}
