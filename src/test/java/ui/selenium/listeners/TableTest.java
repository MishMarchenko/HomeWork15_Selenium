package ui.selenium.listeners;

import org.testng.annotations.Test;
import ui.selenium.po.TablePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TableTest extends BaseTest {
    @Test
    public void getTextFromTable(){
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();
        assertThat(new TablePage().getTextFromTable(2,2))
                .as("Selenium located not into table")
                .isEqualTo("Cantrell");
    }
}
