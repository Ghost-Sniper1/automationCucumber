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
import pages.CartPage;
import pages.StorePage;

import java.time.Duration;

public class AddToCartSteps {
    private final WebDriver driver = DriverFactory.getDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    StorePage storePage = new StorePage(driver);

    @Given("I'm on the Store page")
    public void iMOnTheStorePage() {
//        driver.get("https://askomdch.com/store");

        /*Implementation using Page Object Model*/
        storePage.load("https://askomdch.com/store");
    }

    @When("I add a {string} to the cart")
    public void iAddAToTheCart(String productName) throws InterruptedException {
//        By addToCartButton = By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
//        driver.findElement(addToCartButton).click();
//        By viewCartButton = By.cssSelector("a[title='View cart']");
//        wait.until(ExpectedConditions.elementToBeClickable(viewCartButton)).click();

        /*Implementation using Page Object Model*/
        storePage.addToCart(productName);
    }


    @Then("I should see {int} {string} in the cart")
    public void iShouldSeeInTheCart(int quantity, String productName) {
//        By productNameField = By.cssSelector("td.product-name a");
//        String actualProductName = driver.findElement(productNameField).getText();
//
//        By productQuantityField = By.cssSelector("input[type='number']");
//        String actualQuantity = driver.findElement(productQuantityField).getAttribute("value");
//
//        Assert.assertEquals(actualProductName, productName);
//        assert actualQuantity != null;
//        Assert.assertEquals(Integer.parseInt(actualQuantity), quantity);

        /*Implementation using Page Object Model*/
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(productName, cartPage.getProductName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }
}






