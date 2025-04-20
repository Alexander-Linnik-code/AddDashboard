package linnik.singleton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Singleton {
    private static WebDriver driver;

    private Singleton() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--incognito");
            options.addArguments("--disable-infobars");
            options.addArguments("profile.default_content_setting_values.password_manager_enabled=0");
            options.addArguments("profile.default_content_setting_values.autofill_enabled=0");
            options.addArguments("--disable-popup-blocking");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


    public static void clickElement(By element) {
        driver.findElement(element).click();
    }

    public static void setTextElement(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    public static void Wait(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
