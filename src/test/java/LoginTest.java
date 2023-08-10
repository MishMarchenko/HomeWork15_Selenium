import org.testng.annotations.Test;
import po.ArticlePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class LoginTest extends BaseTest{
    @Test(groups = {"Smoke"})
    void checkUserNameAfterLogin() {
        driver.get("https://ru.wikipedia.org/");
        driver.manage().window().maximize();
        new ArticlePage()
        .clickOnLoginButton()
        .inputUserName("МихоАвто")
        .inputPassword("qwer1608QWER")
        .enterCredentials();
        assertThat(new ArticlePage().checkUserName())
                .as("The result of test is appeared")
                .isEqualTo("МихоАвто");
    }
}
