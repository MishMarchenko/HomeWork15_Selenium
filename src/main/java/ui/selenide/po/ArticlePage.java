package ui.selenide.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ArticlePage {
    private final SelenideElement loginButton = $x("//li[@id='pt-login']/a/span");
    private final SelenideElement userNameInput = $x("//input[@id='wpName1']");
    private final SelenideElement passwordInput = $x("//input[@id='wpPassword1']");
    public SelenideElement getUserName(){
        return $x("//li[@id='pt-userpage']/a/span");
    }
    public ArticlePage clickOnLoginButton(){
        loginButton.shouldBe(visible).click();
        return page(ArticlePage.class);
    }
    public ArticlePage inputUserName(String text){
        userNameInput.shouldBe(visible).sendKeys(text);
        return page(ArticlePage.class);
    }
    public ArticlePage inputPassword(String text){
        passwordInput.shouldBe(visible).sendKeys(text);
        return page(ArticlePage.class);
    }
    public ArticlePage clickEnter(){
        userNameInput.shouldBe(visible).sendKeys(Keys.ENTER);
        return page(ArticlePage.class);
    }

}
