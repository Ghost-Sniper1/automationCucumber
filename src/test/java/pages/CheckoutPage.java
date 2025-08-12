package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{
    @FindBy(id = "billing_first_name")
    private WebElement billingFirstNameField;

    @FindBy(id = "billing_last_name")
    private WebElement billingLastNameField;

    @FindBy(id = "billing_address_1")
    private WebElement billingAddressField;

    @FindBy(id = "billing_city")
    private WebElement billingCityField;

    @FindBy(id = "billing_state")
    private WebElement billingStateDropDown;

    @FindBy(id = "billing_postcode")
    private WebElement billingZipField;

    @FindBy(id = "billing_email")
    private WebElement billingEmailField;

    @FindBy(id = "place_order")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']")
    private WebElement noticeTxt;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterBillingFirstName(String billingFirstName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingFirstNameField));
        e.clear();
        e.sendKeys(billingFirstName);
        return this;
    }

    public CheckoutPage enterBillingLastName(String billingLastName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingLastNameField));
        e.clear();
        e.sendKeys(billingLastName);
        return this;
    }

    public CheckoutPage enterBillingAddressLineOne(String billingAddressLineOne){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingAddressField));
        e.clear();
        e.sendKeys(billingAddressLineOne);
        return this;
    }

    public CheckoutPage enterBillingCity(String billingCity){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingCityField));
        e.clear();
        e.sendKeys(billingCity);
        return this;
    }
    public CheckoutPage selectBillingState(String billingStateName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingStateDropDown));
        Select stateSelect = new Select(e);
        stateSelect.selectByVisibleText(billingStateName);
        return this;
    }

    public CheckoutPage enterBillingPostcode(String billingZip){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingZipField));
        e.clear();
        e.sendKeys(billingZip);
        return this;
    }
    public CheckoutPage enterBillingEmail(String billingEmail){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingEmailField));
        e.clear();
        e.sendKeys(billingEmail);
        return this;
    }

    public CheckoutPage setBillingDetails(String billingFirstName, String billingLastName,
                                          String billingAddressOne, String billingCity,
                                          String billingStateName, String billingZip,
                                          String billingEmail){
        return enterBillingFirstName(billingFirstName).
                enterBillingLastName(billingLastName).
                enterBillingAddressLineOne(billingAddressOne).
                enterBillingCity(billingCity).
                selectBillingState(billingStateName).
                enterBillingPostcode(billingZip).
                enterBillingEmail(billingEmail);
    }

    public void placeOrder(){
        wait.until(ExpectedConditions.visibilityOf(placeOrderButton)).click();
    }

    public String getNotice(){
        return wait.until(ExpectedConditions.visibilityOf(noticeTxt)).getText();
    }
}
