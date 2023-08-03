import org.testng.annotations.Test;
import po.SearchPage;
import po.SignInFlow;

import static org.testng.AssertJUnit.assertEquals;
public class SearchTest extends BaseTest {

    SearchPage search = new SearchPage();
    SignInFlow signIn = new SignInFlow();
    @Test
    void shouldBeVisibleUbisoftTitle(){
            search.inputText("Ubisoft");
            search.enterSearch();
            search.clickOnUbisoftLink();
            assertEquals("Ubisoft",search.checkTitle());
    }
}