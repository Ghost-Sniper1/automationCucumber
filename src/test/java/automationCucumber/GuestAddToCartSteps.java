package automationCucumber;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CheckoutPage;
import pages.StorePage;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class GuestAddToCartSteps {

    private final WebDriver driver = DriverFactory.getDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    StorePage storePage = new StorePage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    // Guest Customer Make an Order Steps Definition
    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {
//        driver.get("https://askomdch.com/store");

        /*Implementation using Page Object Model*/
        storePage.load("https://askomdch.com/store");
    }

    @And("I have a {string} in the cart")
    public void iHaveProductInCart(String productName) {
//        String selector = "a[aria-label='Add “" + productName + "” to your cart']";
//        driver.findElement(By.cssSelector(selector)).click();
//
//        By viewCartBtn = By.cssSelector("a[title='View cart']");
//        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn)).click();

        /*Implementation using Page Object Model*/
        storePage.addToCart(productName);
    }


    @And("I'm on the checkout page")
    public void iMOnTheCheckoutPage() {
        driver.findElement(By.cssSelector(".checkout-button")).click();
    }

    @Then("I provide billing details")
    public void iProvideBillingDetails(List<Map<String, String>> billingDetails) {
//        Map<String, String> data = billingDetails.get(0);
//
//        driver.findElement(By.id("billing_first_name")).clear();
//        driver.findElement(By.id("billing_first_name")).sendKeys(data.get("firstname"));
//
//        driver.findElement(By.id("billing_last_name")).clear();
//        driver.findElement(By.id("billing_last_name")).sendKeys(data.get("lastname"));
//
//        driver.findElement(By.id("billing_address_1")).clear();
//        driver.findElement(By.id("billing_address_1")).sendKeys(data.get("address_line1"));
//
//        driver.findElement(By.id("billing_city")).clear();
//        driver.findElement(By.id("billing_city")).sendKeys(data.get("city"));
//
//        Select stateSelect = new Select(driver.findElement(By.id("billing_state")));
//        stateSelect.selectByVisibleText(data.get("state"));
//
//        driver.findElement(By.id("billing_postcode")).clear();
//        driver.findElement(By.id("billing_postcode")).sendKeys(data.get("zip"));
//
//        driver.findElement(By.id("billing_email")).clear();
//        driver.findElement(By.id("billing_email")).sendKeys(data.get("email"));

        /*Implementation using Page Object Model*/

        checkoutPage.setBillingDetails(billingDetails.get(0).get("firstname"),
                billingDetails.get(0).get("lastname"),
                billingDetails.get(0).get("address_line1"),
                billingDetails.get(0).get("city"),
                billingDetails.get(0).get("state"),
                billingDetails.get(0).get("zip"),
                billingDetails.get(0).get("email"));
    }

    @And("I place an order")
    public void i_place_an_order() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='place_order']")));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='place_order']"))).click();

        /*Implementation using Page Object Model*/
        checkoutPage.placeOrder();
    }
}
