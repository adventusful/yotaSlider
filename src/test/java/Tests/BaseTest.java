package Tests;

import Common.MyDriverFactory;
import Pages.SliderPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

/**
 * Created by Daniil Kornienko on 02.08.2016.
 */
public class BaseTest {
    protected WebDriver driver;


    String url = "http://localhost:4567/index.html";

    SliderPage sliderpage = new SliderPage(driver);

    @BeforeClass
    public void startServer() throws Exception {
        Process process = Runtime.getRuntime().exec("java -jar test-slider-1.0.0-SNAPSHOT.jar");
    }

    @BeforeSuite
    public void setSuite() throws Exception {
        driver = new MyDriverFactory().getDriver();
        driver.get(url);

    }

    @AfterSuite
    public void tearDown() throws Exception {
        driver.quit();

    }
}
