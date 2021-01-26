package Utils;

import Constants.SeleniumConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

    private static WebDriver driver = Driver.getDriver();

    public static void sleep(long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void waitForClickability(WebElement element) {
        WebDriverWait explicitWait = new WebDriverWait(Driver.getDriver(), SeleniumConstants.EXPLICIT_WAIT_TIME);
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }


}
