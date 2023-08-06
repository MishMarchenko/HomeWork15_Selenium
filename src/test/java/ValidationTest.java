import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import po.ArticlePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidationTest extends BaseTest{
    @Test(groups = {"Regression"}, dataProvider = "UserNameValidationTest")
    void checkUserNameValidation(String userName) {
        new ArticlePage()
                .clickOnLoginButton()
                .inputUserName(userName)
                .inputPassword("qwer1608QWER")
                .enterCredentials();
        assertThat(new ArticlePage().checkDataValidationError())
                .as("The result of test is appeared")
                .isEqualTo("Введены неверные имя участника или пароль. Попробуйте ещё раз.");
    }
    @Test(groups = {"Regression"}, dataProvider = "PasswordValidationTest")
    void checkPasswordValidation(String password) {
        new ArticlePage()
                .clickOnLoginButton()
                .inputUserName("МихоАвто")
                .inputPassword(password)
                .enterCredentials();
        assertThat(new ArticlePage().checkDataValidationError())
                .as("The result of test is appeared")
                .isEqualTo("Введены неверные имя участника или пароль. Попробуйте ещё раз.");
    }
    @DataProvider(name = "UserNameValidationTest")
    public Object[][] getUserName(){
        return new Object[][]{
                {"Something"}
        };
    }
    @DataProvider(name = "PasswordValidationTest")
    public Object[][] getPassword(){
        return new Object[][]{
                {"*&^((^$(^$($"}
        };
    }
}