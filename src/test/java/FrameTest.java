import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import po.FramePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FrameTest extends BaseTest{
    @Test
    void getTextFromChildFrame(){
        driver.get("https://demoqa.com/nestedframes");
        driver.manage().window().maximize();

        WebElement parentFrame = driver.findElement(By.xpath("//iframe[@id='frame1']"));
        driver.switchTo().frame(parentFrame);

        WebElement childFrame = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        driver.switchTo().frame(childFrame);

        assertThat(new FramePage().getTextFromFrame())
                .as("Selenium located not into frame")
                .isEqualTo("Child Iframe");
    }
}
