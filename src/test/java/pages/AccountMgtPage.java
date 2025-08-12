package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountMgtPage extends BasePage {

    @FindBy(id = "reg_username")
    private WebElement userName;

    @FindBy(id = "reg_email")
    private WebElement email;

    @FindBy(id = "reg_password")
    private WebElement password;

    public AccountMgtPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement loginUserName;

    @FindBy(id = "password")
    private WebElement loginPassword;

}
