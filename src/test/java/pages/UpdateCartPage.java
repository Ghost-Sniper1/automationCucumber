package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


}
