package linnik.uipages;

import io.qameta.allure.Step;
import linnik.Singleton.Singleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage() {
        this.driver = Singleton.getDriver();
    }

    private final String URL = "https://demo.reportportal.io/ui/#login";
    private final By LOGIN_GUTTON = By.xpath("//button[@class='bigButton__big-button--BmG4Q bigButton__rounded-corners--c_Xiz bigButton__color-organish--gj0Mz']");

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    @Step
    public HomePage open() {
        try {
            driver.get(URL);
            return this;
        } catch (NullPointerException e) {
            logger.info("Attempted to open web driver, but driver failed to initialize.");
            logger.error("Driver is not initialized", e);
            throw e;
        } catch (Exception e) {
            logger.info("Attempted to open web driver, but an error occurred.");
            logger.error("Unexpected error occurred while trying to open the URL: " + URL, e);
            throw e;
        }
    }

    @Step
    public Dashboards clickLogin() {
        Singleton.Wait(LOGIN_GUTTON);
        try {
            Singleton.clickElement(LOGIN_GUTTON);
        } catch (NoSuchElementException e) {
            logger.info("Attempted to click but element not found.");
            logger.error("Element to click not found");
            throw e;
        }
        catch (StaleElementReferenceException e) {
            logger.info("Attempted to click but an error occurred.");
            logger.error("An error occurred while attempting to click.");
            throw e;
        }
        return new Dashboards();
    }
}
