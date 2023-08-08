package po;

import Base.BaseMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static config.WebDriverInit.getDriver;

public class FramePage extends BaseMethod {
    private final By textFromChildFrame = By.xpath("/html/body/p");
//    WebElement parentFrameElement = getDriver().findElement(By.xpath("//iframe[@id='frame1']"));
//    WebElement childIframeElement = getDriver().findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));

    public String getTextFromFrame(){
        return getTextFromElement(textFromChildFrame);
    }
//    public void switchToFrame(){
//        WebElement parentFrameElement = getDriver().findElement(By.xpath("//iframe[@id='frame1']"));
//        getWait().until(d->d.switchTo().frame(parentFrameElement));
//
//    }

}
