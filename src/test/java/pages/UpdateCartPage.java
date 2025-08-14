package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpdateCartPage extends BasePage{

    public UpdateCartPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//button[normalize-space()='Update cart']")
    private WebElement updateCartBtn;
}
