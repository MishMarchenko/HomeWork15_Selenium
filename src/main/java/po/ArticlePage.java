package po;

import Base.BaseMethod;
import org.openqa.selenium.By;

public class ArticlePage extends BaseMethod {
    private final By loginButton = By.xpath("//li[@id='pt-login']/a/span");
    private final By userNameInput = By.xpath("//input[@id='wpName1']");
    private final By passwordInput = By.xpath("//input[@id='wpPassword1']");
    private final By userName = By.xpath("//li[@id='pt-userpage']/a/span");
    private final By validationError = By.xpath("//div[@class='cdx-message__content']");

    public ArticlePage clickOnLoginButton(){
        click(loginButton);
        return this;
    }
    public ArticlePage inputUserName(String text){
        send(userNameInput, text);
        return this;
    }
    public ArticlePage inputPassword(String text){
        send(passwordInput, text);
        return this;
    }
    public ArticlePage enterCredentials(){
        clickEnter(passwordInput);
        return this;
    }
    public String checkUserName(){
        return getTextFromElement(userName);
    }
    public String checkDataValidationError(){
        return getTextFromElement(validationError);
    }
}
