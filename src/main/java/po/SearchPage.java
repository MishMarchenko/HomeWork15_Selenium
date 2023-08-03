package po;

import Base.BaseMethod;
import org.openqa.selenium.By;

public class SearchPage extends BaseMethod {
    private final By search = By.xpath("//input[@name='search']");
    private final By ubisoft = By.xpath("//div[@class='mw-search-result-heading']/a/span");
    private final By result = By.xpath("//h1[@id='firstHeading']");

    public void inputText(String text){
        send(search, text);
    }
    public void enterSearch(){
        clickEnter(search);
    }
    public void clickOnUbisoftLink(){
        click(ubisoft);
    }
    public String checkTitle(){
        return getTextFromElement(result);
    }
}
