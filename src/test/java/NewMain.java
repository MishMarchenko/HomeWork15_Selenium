import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.AssertJUnit.assertEquals;
public class NewMain {
    public static void main(String[] args) {
        By search = By.xpath("//input[@name='search']");
        By ubisoft = By.xpath("//div[@class='mw-search-result-heading']/a/span");
        By result = By.xpath("//h1[@id='firstHeading']");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.get("https://ru.wikipedia.org/");
        driver.manage().window().maximize();
        wait.until(d -> d.findElement(search)).sendKeys("Ubisoft");
        wait.until(d -> d.findElement(search)).sendKeys(Keys.ENTER);
        wait.until(d -> d.findElement(ubisoft)).click();
        assertEquals("Ubisoft",getTextFromElement(driver, result));
        driver.quit();
    }
    static String getTextFromElement(WebDriver driver, By locator){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        return wait.until(d -> d.findElement(locator)).getText();
    }
}
