import org.testng.annotations.Test;
import po.ArticlePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginTestValidation extends BaseTest{
    @Test
    void checkUserNameValidation() {
        new ArticlePage()
                .clickOnLoginButton()
                .inputUserName("Михо")
                .inputPassword("qwer1608QWER")
                .enterCredentials();
        assertThat(new ArticlePage().checkDataValidationError())
                .as("The result of test is appeared")
                .isEqualTo("Введены неверные имя участника или пароль. Попробуйте ещё раз.");
    }
    @Test
    void checkPasswordValidation() {
        new ArticlePage()
                .clickOnLoginButton()
                .inputUserName("МихоАвто")
                .inputPassword("qwer1608")
                .enterCredentials();
        assertThat(new ArticlePage().checkDataValidationError())
                .as("The result of test is appeared")
                .isEqualTo("Введены неверные имя участника или пароль. Попробуйте ещё раз.");
    }
}
