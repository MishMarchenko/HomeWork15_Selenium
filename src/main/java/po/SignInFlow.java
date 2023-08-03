package po;

import Base.BaseMethod;
import org.openqa.selenium.By;

public class SignInFlow extends BaseMethod {
    private final By loginButton = By.xpath("//li[@id='pt-login']/a/span");
    private final By userNameInput = By.xpath("//input[@id='wpName1']");
    private final By passwordInput = By.xpath("//input[@id='wpPassword1']");
    private final By userName = By.xpath("//li[@id='pt-userpage']/a/span");
    public void clickOnLoginButton(){
        click(loginButton);
    }
    public void inputUserName(String text){
        send(userNameInput, text);
    }
    public void inputPassword(String text){
        send(passwordInput, text);
    }
    public void enterCredentials(){
        clickEnter(passwordInput);
    }
    public String checkUserName(){
        return getTextFromElement(userName);
    }
}
