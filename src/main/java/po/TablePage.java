package po;

import Base.BaseMethod;

import Base.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TablePage extends BaseMethod {
    private final By table = By.xpath("//div[@class='rt-tbody']");
    public String getTextFromTable(int row, int column){
        WebElement tableTmp = getWait().until(d->d.findElement(table));
        Table table1 = new Table(tableTmp);
        return table1.getValue(row - 1, column);
    }

}
