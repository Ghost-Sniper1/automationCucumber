package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UpdateCartPage extends BasePage{

    public UpdateCartPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//td[@class='product-name']//a[normalize-space()='")
    private WebElement productNameFld;

    @FindBy(xpath = "']/ancestor::tr//input[@type='number']")
    private WebElement quantityFld;

    @FindBy(xpath = "//button[normalize-space()='Update cart']")
    private WebElement updateCartBtn;


    public void setProductQuantity(String productName, String quantity) {
        String quantityXpath = "//td[@class='product-name']//a[normalize-space()='" + productName + "']/ancestor::tr//input[@type='number']";
        WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(quantityXpath)));
        quantityField.clear();
        quantityField.sendKeys(quantity);
    }

    public void clickUpdateCart() {
        wait.until(ExpectedConditions.elementToBeClickable(updateCartBtn)).click();
    }

    public void updateProductQuantity(String productName, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be at least 1 — received: " + quantity);
        }
        setProductQuantity(productName, String.valueOf(quantity));
        clickUpdateCart();
    }

}
