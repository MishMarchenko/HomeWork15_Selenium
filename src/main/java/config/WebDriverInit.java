package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverInit {
    private static volatile WebDriver driver;
    private WebDriverInit(){}

    private static synchronized WebDriver getDriver(){
        if (driver == null){
            synchronized (WebDriverInit.class){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        }
        return driver;
    }
    public static void closeDriver(){
        driver.quit();
    }
}
