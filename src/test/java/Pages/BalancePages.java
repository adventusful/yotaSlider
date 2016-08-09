package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Daniil Kornienko on 05.08.2016.
 */
public class BalancePages extends BasePage{


    public BalancePages(WebDriver driver) {
        super(driver);

    }

    public BalancePages(WebDriver driver,  WebElement currentTime, WebElement currentSpeed, WebElement currentCost) {
        super(driver);
        this.balanceField = balanceField;
        this.currentTime = currentTime;
        this.currentSpeed = currentSpeed;
        this.currentCost = currentCost;
    }

    @FindBy(xpath="//*[@id='balance-holder']/span[@data-bind='text: balance']")
	private WebElement balanceField;

    @FindBy(xpath="//div[@class='tariff unavailable']/*/div[@class='time']/strong")
    private WebElement currentTime;

    @FindBy(xpath="//div[@class='tariff unavailable']/*/div[@class='speed']/strong")
    private WebElement currentSpeed;

    @FindBy(xpath="//div[@class='tariff unavailable']/*/div[@class='cost no-arrow']/strong")
    private WebElement currentCost;


    @FindBy(xpath="//div[@class='main-offer-container line']/*//div[@class='tarriff-info']/div[@class='time']/strong")
    private WebElement newtime;

    @FindBy(xpath="//div[@class='main-offer-container line']/*//div[@class='tarriff-info']/div[@class='speed']/strong")
    private WebElement newSpeed;

    @FindBy(xpath="//div[@class='main-offer-container line']/*//div[@class='tarriff-info']/div[@class='cost']/strong")
    private WebElement newCost;

    public int getBalance () {
         int b = Integer.parseInt(balanceField.getText());
        return b;
    }

    public int getCurrentTime() {
        int cTime = Integer.parseInt(currentTime.getText());
        return cTime;
    }

    public int getNewTime() {
        int cTime = Integer.parseInt(newtime.getText());
        return cTime;
    }

    public int getCurrentCost() {
        int cCost = Integer.parseInt(currentCost.getText());
        return cCost;
    }

    public int getNewCost() {
        int cCost = Integer.parseInt(newCost.getText());
        return cCost;
    }

    public String getCurrentSpeed() {
        return currentSpeed.getText();
    }

    public String getNewSpeed() {
        return newSpeed.getText();
    }


}
