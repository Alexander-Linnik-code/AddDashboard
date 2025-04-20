package linnik.UITest;

import io.qameta.allure.Description;
import linnik.singleton.Singleton;
import linnik.uipages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UITestDashboard {
    @Test
    @Description("Adding a board")
    public void test() {
        boolean actual = new HomePage()
                .open()
                .clickLogin()
                .clickDashboard()
                .clickAddNewDashBoard()
                .addNameDashboard("New Dashboard6")
                .clickAddBoard()
                .clickAddNewWidget()
                .clickChoosePassingRateSummary()
                .clickNextStepButton()
                .clickAddFilterButton()
                .setFilterField("filter4")
                .setLaunchName("Time")
                .clickMoreButton()
                .clickOwnerButton()
                .setOwnerName("Alex")
                .clickSubmitButton()
                .clickNextStepButtonWidget()
                .clickNextStepButton()
                .clickAddWidget()
                .isElementPresent();
        Assertions.assertFalse(actual, "Элемент не найден на странице.");
        Singleton.quit();
    }
}
