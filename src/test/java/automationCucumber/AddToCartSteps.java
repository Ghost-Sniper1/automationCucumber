package automationCucumber;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddToCartSteps {
    private final WebDriver driver = DriverFactory.getDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("I'm on the Store page")
    public void iMOnTheStorePage() {
        driver.get("https://askomdch.com/store");
    }

    @When("I add a {string} to the cart")
    public void iAddAToTheCart(String productName) throws InterruptedException {
        By addToCartButton = By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
        driver.findElement(addToCartButton).click();
        By viewCartButton = By.cssSelector("a[title='View cart']");
        wait.until(ExpectedConditions.elementToBeClickable(viewCartButton)).click();
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
}






