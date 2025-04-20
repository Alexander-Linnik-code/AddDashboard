package linnik.uipages;

import io.qameta.allure.Step;
import linnik.singleton.Singleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Dashboards {
    private WebDriver driver;

    public Dashboards() {
        this.driver = Singleton.getDriver();
    }

    private final By DASHBOARD = By.xpath("(//i[@class='sidebarButton__btn-icon--xc3y6'])[1]");
    private final By ADD_NEW_DASHBOARD = By.xpath("//span[@class='ghostButton__text--SjHtK']");
    private final By FILLING_NAME_FIELD = By.xpath("//input[@placeholder='Enter dashboard name']");
    private final By ADD_DASHBOARD_BUTTON = By.xpath("//button[@class='bigButton__big-button--BmG4Q bigButton__color-booger--EpRlL']");
    private final By NEW_WIDGET = By.xpath("//span[@class='ghostButton__text--SjHtK' and text()='Add new widget']");
    private final By CHOOSE_PASSING_RATE_SUMMARY = By.xpath("//div[text()='Passing rate summary']");
    private final By NEXT_STEP_BUTTON = By.xpath("//span[text()='Next step']");
    private final By ADD_FILTER_BUTTON = By.xpath("//span[@class='ghostButton__text--SjHtK' and text()='Add filter']");
    private final By FILTER_NAME_FIELD = By.xpath("//input[@placeholder='Input filter name']");
    private final By LAUNCH_NAME_FIELD = By.xpath("//input[@placeholder='Enter name']");
    private final By MORE_BUTTON = By.xpath("//div[@class='entitiesSelector__toggler--_p1QT']");
    private final By OWNER_BUTTON = By.xpath("//span[@class='inputCheckbox__children-container--R83YO' and text()='Owner']");
    private final By ENTER_OWNERS_NAME = By.xpath("//input[@id='downshift-0-input']");
    private final By SUBMIT_BUTTON = By.xpath("//button[text()='Submit']");
    private final By NEXT_STEP_WIDGET_BUTTON = By.xpath("//span[text()='Next step']");
    private final By ADD_WIDGET_BUTTON = By.xpath("//button[@class='bigButton__big-button--BmG4Q bigButton__color-booger--EpRlL']");
    private final By FINISHED_DASHBOARD = By.xpath("//div[@class='widgetHeader__widget-name--vhUok']");

    private static final Logger logger = LogManager.getLogger(Dashboards.class);

    @Step
    public Dashboards clickDashboard() {
        Singleton.Wait(DASHBOARD);
        try {
            Singleton.clickElement(DASHBOARD);
        } catch (NoSuchElementException e) {
            logger.info("Attempted to click but element not found.");
            logger.error("Element to click not found");
            throw e;
        } catch (StaleElementReferenceException e) {
            logger.info("Attempted to click but an error occurred.");
            logger.error("An error occurred while attempting to click.");
            throw e;
        }
        return this;
    }
    @Step
    public Dashboards clickAddNewDashBoard() {
        try {
            Singleton.clickElement(ADD_NEW_DASHBOARD);
        } catch (NoSuchElementException e) {
            logger.info("Attempted to click but element not found.");
            logger.error("Element to click not found");
            Singleton.clickElement(ADD_NEW_DASHBOARD);
            throw e;
        } catch (StaleElementReferenceException e) {
            logger.info("Attempted to click but an error occurred.");
            logger.error("An error occurred while attempting to click.");
            Singleton.clickElement(ADD_NEW_DASHBOARD);
        }
        return this;
    }
    @Step
    public Dashboards addNameDashboard(String name) {
        Singleton.Wait(FILLING_NAME_FIELD);
        Singleton.setTextElement(FILLING_NAME_FIELD, name);
        return this;
    }
    @Step
    public Dashboards clickAddBoard() {
        try {
            Singleton.clickElement(ADD_DASHBOARD_BUTTON);
        } catch (NoSuchElementException e) {
            logger.info("Attempted to click but element not found.");
            logger.error("Element to click not found");
            throw e;
        } catch (StaleElementReferenceException e) {
            logger.info("Attempted to click but an error occurred.");
            logger.error("An error occurred while attempting to click.");
            throw e;
        }
        return this;
    }
    @Step
    public Dashboards clickAddNewWidget() {
        Singleton.Wait(NEW_WIDGET);
        try {
            Singleton.clickElement(NEW_WIDGET);
        } catch (NoSuchElementException e) {
            logger.info("Attempted to click but element not found.");
            logger.error("Element to click not found");
            throw e;
        } catch (StaleElementReferenceException e) {
            logger.info("Attempted to click but an error occurred.");
            logger.error("An error occurred while attempting to click.");
            throw e;
        }
        return this;
    }
    @Step
    public Dashboards clickChoosePassingRateSummary() {
        try {
            Singleton.clickElement(CHOOSE_PASSING_RATE_SUMMARY);
        } catch (NoSuchElementException e) {
            logger.info("Attempted to click but element not found.");
            logger.error("Element to click not found");
            throw e;
        } catch (StaleElementReferenceException e) {
            logger.info("Attempted to click but an error occurred.");
            logger.error("An error occurred while attempting to click.");
            throw e;
        }
        return this;
    }
    @Step
    public Dashboards clickNextStepButton() {
        logger.info("Attempting to scroll down and click the 'Next Step' button.");

        try {
            Actions actions = new Actions(driver);
            actions.scrollByAmount(0, 500).perform();
            logger.info("Scrolled down successfully.");
            Singleton.clickElement(NEXT_STEP_BUTTON);
            logger.info("'Next Step' button clicked successfully.");
        } catch (NoSuchElementException e) {
            logger.error("The 'Next Step' button was not found.", e);
            Singleton.clickElement(NEXT_STEP_BUTTON);
            throw e;
        } catch (Exception e) {
            logger.error("An error occurred while trying to click the 'Next Step' button.", e);
            throw e;
        }

        return this;
    }
    @Step
    public Dashboards clickAddFilterButton() {
        try {
            Singleton.clickElement(ADD_FILTER_BUTTON);
        } catch (NoSuchElementException e) {
            logger.info("Attempted to click but element not found.");
            logger.error("Element to click not found");
            throw e;
        } catch (StaleElementReferenceException e) {
            logger.info("Attempted to click but an error occurred.");
            logger.error("An error occurred while attempting to click.");
            throw e;
        }
        return this;
    }
    @Step
    public Dashboards setFilterField(String text) {
        logger.info("Attempting to set filter field with text: '" + text + "'.");
        try {
            Singleton.setTextElement(FILTER_NAME_FIELD, text);
            logger.info("Filter field set successfully with text: '" + text + "'.");
        } catch (NoSuchElementException e) {
            logger.error("The filter field element was not found.", e);
            throw e;
        } catch (Exception e) {
            logger.error("An error occurred while trying to set the filter field with text: '" + text + "'.", e);
            throw e;
        }
        return this;
    }
    @Step
    public Dashboards setLaunchName(String text) {
        logger.info("Attempting to set launch name with text: '{}'.", text);

        try {
            Singleton.setTextElement(LAUNCH_NAME_FIELD, text);
            logger.info("Launch name set successfully with text: '{}'.", text);
        } catch (NoSuchElementException e) {
            logger.error("The launch name field element was not found.", e);
            throw e;
        } catch (Exception e) {
            logger.error("An error occurred while trying to set the launch name with text: '{}'.", text, e);
            throw e;
        }
        return this;
    }
    @Step
    public Dashboards clickMoreButton() {
        try {
            Singleton.clickElement(MORE_BUTTON);
        } catch (NoSuchElementException e) {
            logger.info("Attempted to click but element not found.");
            logger.error("Element to click not found");
            throw e;
        } catch (StaleElementReferenceException e) {
            logger.info("Attempted to click but an error occurred.");
            logger.error("An error occurred while attempting to click.");
            throw e;
        }
        return this;
    }
    @Step
    public Dashboards clickOwnerButton() {
        try {
            Singleton.clickElement(OWNER_BUTTON);
        } catch (NoSuchElementException e) {
            logger.info("Attempted to click but element not found.");
            logger.error("Element to click not found");
            throw e;
        } catch (StaleElementReferenceException e) {
            logger.info("Attempted to click but an error occurred.");
            logger.error("An error occurred while attempting to click.");
            throw e;
        }
        return this;
    }
    @Step
    public Dashboards setOwnerName(String name) {
        logger.info("Attempting to set owner name with text: '{}'.", name);

        try {
            Singleton.setTextElement(ENTER_OWNERS_NAME, name);
            logger.info("Owner name set successfully with text: '{}'.", name);
        } catch (NoSuchElementException e) {
            logger.error("The owner name field element was not found.", e);
            throw e;
        } catch (Exception e) {
            logger.error("An error occurred while trying to set the owner name with text: '{}'.", name, e);
            throw e;
        }
        return this;
    }
    @Step
    public Dashboards clickSubmitButton() {
        try {
            Singleton.clickElement(SUBMIT_BUTTON);
        } catch (NoSuchElementException e) {
            logger.info("Attempted to click but element not found.");
            logger.error("Element to click not found");
            throw e;
        } catch (StaleElementReferenceException e) {
            logger.info("Attempted to click but an error occurred.");
            logger.error("An error occurred while attempting to click.");
            throw e;
        }
        return this;
    }
    @Step
    public Dashboards clickNextStepButtonWidget() {
        try {
            Singleton.clickElement(NEXT_STEP_WIDGET_BUTTON);
        } catch (NoSuchElementException e) {
            logger.info("Attempted to click but element not found.");
            logger.error("Element to click not found");
            throw e;
        } catch (StaleElementReferenceException e) {
            logger.info("Attempted to click but an error occurred.");
            logger.error("An error occurred while attempting to click.");
            throw e;
        }
        return this;
    }
    @Step
    public Dashboards clickAddWidget() {
        Singleton.Wait(ADD_WIDGET_BUTTON);
        try {
            Singleton.clickElement(ADD_WIDGET_BUTTON);
        } catch (NoSuchElementException e) {
            logger.info("Attempted to click but element not found.");
            logger.error("Element to click not found");
            throw e;
        } catch (StaleElementReferenceException e) {
            logger.info("Attempted to click but an error occurred.");
            logger.error("An error occurred while attempting to click.");
            throw e;
        }
        return this;
    }
    @Step
    public boolean isElementPresent() {
        logger.info("Checking if the element is present.");
        boolean isPresent = !driver.findElements(FINISHED_DASHBOARD).isEmpty();
        if (isPresent) {
            logger.info("The element is present.");
        } else {
            logger.info("The element is not present.");
        }
        return isPresent;
    }
}
