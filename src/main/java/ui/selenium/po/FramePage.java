package ui.selenium.po;

import ui.selenium.Base.BaseMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static ui.selenium.config.WebDriverInit.getDriver;

public class FramePage extends BaseMethod {
    private final By textFromChildFrame = By.xpath("/html/body/p");
    public String getTextFromFrame(){
        return getTextFromElement(textFromChildFrame);
    }
    public FramePage switchToParentFrame(){
        WebElement parentFrameElement = getDriver().findElement(By.xpath("//iframe[@id='frame1']"));
        getWait().until(d->d.switchTo().frame(parentFrameElement));
        return this;
    }
    public FramePage switchToChildFrame(){
        WebElement childFrameElement = getDriver().findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        getWait().until(d->d.switchTo().frame(childFrameElement));
        return this;
    }

}
