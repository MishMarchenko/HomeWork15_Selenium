package ui.selenium.listeners;

import org.testng.annotations.Test;
import ui.selenium.po.UploadPage;


public class UploadTest extends BaseTest {
    @Test
    public void uploadFileTest(){
        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();
        new UploadPage()
                .uploadFile("C:\\Users\\Misha\\IdeaProjects\\Selenium\\text.txt");
    }
}
