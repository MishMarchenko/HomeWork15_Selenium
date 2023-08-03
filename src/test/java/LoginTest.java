import org.testng.annotations.Test;
import po.LogIn;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BaseTest{
    LogIn signIn = new LogIn();

    @Test
    void checkUserNameAfterLogin() {
        signIn.clickOnLoginButton();
        signIn.inputUserName("МихоАвто");
        signIn.inputPassword("qwer1608QWER");
        signIn.enterCredentials();
        assertEquals("МихоАвто", signIn.checkUserName());
    }
}
