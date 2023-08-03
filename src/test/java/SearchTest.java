import org.testng.annotations.Test;
import po.SearchPage;

import static org.testng.AssertJUnit.assertEquals;
public class SearchTest extends BaseTest {
    SearchPage search = new SearchPage();
    @Test
    void shouldBeVisibleUbisoftTitle(){
            search.inputText("Ubisoft");
            search.enterSearch();
            search.clickOnUbisoftLink();
            assertEquals("Ubisoft",search.checkTitle());
    }
}