package selenide;

import org.testng.annotations.Test;
import selenide.po.ArticlePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginTest {
    @Test
    void shouldBeVisibleUserName(){
        open("https://ru.wikipedia.org/");
        getWebDriver().manage().window().maximize();
        new ArticlePage()
                .clickOnLoginButton()
                .inputUserName("МихоАвто")
                .inputPassword("qwer1608QWER")
                .clickEnter();
        assertThat(new ArticlePage()
                .getUserName().shouldBe(visible).getText())
                .as("The username was not found")
                .isEqualTo("МихоАвто");
    }
}
