package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Daniil Kornienko on 03.08.2016.
 */
public class MyDriverFactory {
    public WebDriver driver;

    public WebDriver getDriver() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(1,TimeUnit.MINUTES);
        return driver;
    }
}
