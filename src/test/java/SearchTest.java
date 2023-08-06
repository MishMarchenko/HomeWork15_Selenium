import org.testng.annotations.Test;
import po.SearchPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.AssertJUnit.assertEquals;
public class SearchTest extends BaseTest {
    @Test
    void shouldBeVisibleUbisoftTitle(){
        new SearchPage()
                  .inputText("Ubisoft")
                  .enterSearch()
                  .clickOnUbisoftLink();
            assertThat(new SearchPage().checkTitle())
                    .as("The result of test is appeared")
                    .isEqualTo("Ubisoft");
    }
}