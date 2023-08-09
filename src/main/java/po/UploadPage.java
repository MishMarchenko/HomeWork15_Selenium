package po;

import Base.BaseMethod;
import org.openqa.selenium.By;

public class UploadPage extends BaseMethod {
    private final By upload = By.xpath("//input[@id='uploadFile']");
    public UploadPage uploadFile(String path){
        send(upload, path);
        return this;
    }
}
