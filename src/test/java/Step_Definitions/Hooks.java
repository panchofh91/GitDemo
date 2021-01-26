package Step_Definitions;

import Utils.Driver;
import cucumber.api.Scenario;
import org.junit.After;
import org.junit.Before;

public class Hooks {
    public static Scenario currentScenario;

    @Before
    public void beforeScenario(Scenario scenario) {
        Driver.getDriver();
        currentScenario = scenario;
    }

    @After
    public void afterScenario() {
        Driver.quitDriver();
    }

    @After
    public void afterStepActions() {
        //CucumberUtils.logInfor("", true);
    }
}
