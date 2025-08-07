package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver initializeDriver(){
        System.setProperty("webdriver.chrome.driver", "D:\\Jaja - TS\\OnBoarding\\Week 3\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    public static WebDriver getDriver(){
        return driver;
    }
}

