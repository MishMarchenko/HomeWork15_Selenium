package selenium.listeners;

import org.testng.annotations.Test;
import selenium.po.po.FramePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FrameTest extends BaseTest {
    @Test
    void getTextFromChildFrame(){
        driver.get("https://demoqa.com/nestedframes");
        driver.manage().window().maximize();
        new FramePage()
                .switchToParentFrame()
                .switchToChildFrame();
        assertThat(new FramePage().getTextFromFrame())
                .as("Selenium located not into frame")
                .isEqualTo("Child Iframe");
    }
}
