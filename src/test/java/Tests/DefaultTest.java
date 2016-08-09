package Tests;

import Pages.BalancePages;
import Pages.SliderPage;
import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.*;


/**
 * Created by Daniil Kornienko on 04.08.2016.
 */
public class DefaultTest extends BaseTest {

    SliderPage sl;


    @BeforeSuite
    public void setUp() throws Exception {
        sl = new SliderPage(driver);

    }


    @AfterSuite
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    @Description("Проверка что при запуске приложения кнопка не активна")
    public void testBtndsbl() throws Exception {
        Assert.assertTrue(sl.btnDsbl(), "Active but expected disable");
    }


    @Test
    @Description("Проверка пополнения негативного баланса")
    public void testNegBalance() throws Exception {
        int b = sl.negativeBalance().getBalance();
        Assert.assertEquals(b, 0, "Negative Balance");
    }

    @Test
    @Description("Проверка пополнения позитивного баланса")
    public void testPosBalance() throws Exception {
        int b = sl.positiveBalance().getBalance();
        Assert.assertEquals(b, 500, "Not Positive");
    }

    @Test
    @Description("Проверка кнопки сброса")
    public void testReset() throws Exception {
        BalancePages a = sl.reset();
        Assert.assertEquals(a.getBalance(), 0, "not default");
        Assert.assertEquals(a.getCurrentCost(), 0, "not default");
        Assert.assertEquals(a.getCurrentTime(), 0, "not default");
        Assert.assertEquals(a.getCurrentSpeed(), "64", "Speed not default");
    }

    @Test
    @Description("Проверка баланса по умолчанию, подключенного продукта по умолчанию")
    public void testDefault() throws Exception {
        BalancePages a = new BalancePages(driver);
        Assert.assertEquals(a.getBalance(), 0, "not default");
        Assert.assertEquals(a.getCurrentCost(), 0, "not default");
        Assert.assertEquals(a.getCurrentTime(), 0, "not default");
        Assert.assertEquals(a.getCurrentSpeed(), "64", "Speed not default");
    }
}
