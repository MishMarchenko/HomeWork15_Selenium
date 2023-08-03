package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static config.WebDriverInit.getDriver;

public class BaseMethod {
    protected WebDriverWait getWait(){
        return new WebDriverWait(getDriver(), 15);
    }
    protected void click(By locator){
        getWait().until(d -> d.findElement(locator)).click();
    }
    protected void send(By locator, String text){
        getWait().until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
    }
    protected void clickEnter(By locator){
        getWait().until(d -> d.findElement(locator)).sendKeys(Keys.ENTER);
    }
    protected String getTextFromElement(By locator){
        return getWait().until(d -> d.findElement(locator)).getText();
    }
}
