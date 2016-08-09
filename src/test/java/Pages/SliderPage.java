package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

/**
 * Created by Daniil Kornienko on 02.08.2016.
 */
public class SliderPage extends BasePage {



    @FindBy(xpath="//a[@data-bind='click: moveRight']")
	public WebElement moveRight;

	@FindBy(xpath="//a[@data-bind='click: moveLeft']")
	private WebElement moveLeft;

	@FindBy(id="slider-handle")
	private WebElement webElement;

	@FindBy(xpath="//input[@data-bind='value: amount']")
	private WebElement enterBalance;

	@FindBy(xpath="//*[@id='balance-holder']/span[@data-bind='text: balance']")
	private WebElement balance;

	@FindBy(xpath="//div[@class='tariff']//a[@class='btn disabled']")
	private WebElement addOfferDisabled;

    @FindBy(xpath="//div[@class='tariff']//a[@class='btn']")
    private WebElement addOfferEnabled;

	@FindBy(xpath="//a[@data-bind='click: doReset']")
	private WebElement reset;

    @FindBy(xpath="//a[@data-bind='click: doPayment']")
    private WebElement addBalance;

    @FindBy(xpath="//div[@class='tariff unavailable']/*/div[@class='time']/strong")
    private WebElement currentTime;

    @FindBy(xpath="//div[@class='tariff unavailable']/*/div[@class='speed']/strong")
    private WebElement currentSpeed;

    @FindBy(xpath="//div[@class='tariff unavailable']/*/div[@class='cost no-arrow']/strong")
    private WebElement currentCost;

    public SliderPage(WebDriver driver) {
        super(driver);
    }



    public BalancePages slideRight() throws InterruptedException {
        moveRight.click();
        return new BalancePages(driver);
    }

    public BalancePages slideRightAndBalance() throws InterruptedException {
        positiveBalance();
        moveRight.click();
        return new BalancePages(driver);
    }


    public boolean btnDsbl() throws InterruptedException {
        boolean status = addOfferDisabled.isDisplayed();
        return status;
    }

    public boolean btnAnable() throws InterruptedException {
        boolean status = addOfferEnabled.isDisplayed();
        return status;
    }

    public BalancePages negativeBalance () throws InterruptedException {
        reset.click();
        enterBalance.clear();
        enterBalance.sendKeys("-500");
        addBalance.click();
        return new BalancePages(driver);
    }

    public BalancePages positiveBalance() {

        enterBalance.clear();
        enterBalance.sendKeys("5000");
        addBalance.click();
        return new BalancePages(driver);
    }

    public BalancePages reset() {
        reset.click();
        return new BalancePages(driver,currentTime,currentSpeed,currentCost);
    }

    public BalancePages viewAndBuy(int buyCash) throws InterruptedException {
        String bc = String.valueOf(buyCash);
        moveRight.click();
        enterBalance.clear();
        enterBalance.sendKeys(bc);
        addBalance.click();
        addOfferEnabled.click();
        return new BalancePages(driver);
    }

    public BalancePages defaultState() {
        return new BalancePages(driver);
    }
}
