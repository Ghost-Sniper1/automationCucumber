package automationCucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setUpDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Jaja - TS\\OnBoarding\\Week 3\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    @After
    public void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}







