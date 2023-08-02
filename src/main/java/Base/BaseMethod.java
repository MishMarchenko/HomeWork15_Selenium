package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static config.WebDriverInit.getDriver;

public class BaseMethod {
    public WebDriverWait getWait(){
        return  new WebDriverWait(getDriver(), 15);
    }

    static String getTextFromElement(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        return wait.until(d -> d.findElement(locator)).getText();
    }
}
