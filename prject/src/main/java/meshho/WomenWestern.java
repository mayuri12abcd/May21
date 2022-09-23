package meshho;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenWestern {
	private WebDriver driver;

	@FindBy (xpath="//span[text()='Women Western']")
	private WebElement westernW;
	
	@FindBy (xpath="//p[text()='Nightsuits']")
	private WebElement nightSuit;
	public WomenWestern(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void moveToWesternDress()
	{
		Actions act = new Actions(driver);
		act.moveToElement(westernW).perform();
	}
	public void clickNightsuit()
	{
		Actions act = new Actions(driver);
		act.moveToElement(nightSuit).click().build().perform();
	}

}
