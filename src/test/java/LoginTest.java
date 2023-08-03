import org.testng.annotations.Test;
import po.SignInFlow;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BaseTest{
    SignInFlow signIn = new SignInFlow();

    @Test
    void SignInWikiPage() {
        signIn.clickOnLoginButton();
        signIn.inputUserName("МихоАвто");
        signIn.inputPassword("qwer1608QWER");
        signIn.enterCredentials();
        assertEquals("МихоАвто", signIn.checkUserName());
    }
}
