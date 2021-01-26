package Utils;

import Step_Definitions.Hooks;
import cucumber.api.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CucumberUtils {
    //By second account
    //private static WebDriver driver = Driver.getDriver();

    public static void logInfo(String msg, boolean takeScreenshot){
        Scenario scenario = Hooks.currentScenario;
        scenario.write(DateUtils.currentDateTime() + " INFO: " + msg);

        if (takeScreenshot)
            scenario.embed(((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES), "image/png");
    }

}
