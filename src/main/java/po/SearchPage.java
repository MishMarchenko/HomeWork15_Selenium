package po;

import Base.BaseMethod;
import org.openqa.selenium.By;

public class SearchPage extends BaseMethod {
    private final By search = By.xpath("//input[@name='search']");
    private final By ubisoft = By.xpath("//div[@class='mw-search-result-heading']/a/span");
    private final By title = By.xpath("//h1[@id='firstHeading']");
    public SearchPage inputText(String text){
        send(search, text);
        return this;
    }
    public SearchPage enterSearch(){
        clickEnter(search);
        return this;
    }
    public SearchPage clickOnUbisoftLink(){
        click(ubisoft);
        return this;
    }
    public String checkTitle(){
        return getTextFromElement(title);
    }
}
