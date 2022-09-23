package w3schools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Home {
	@FindBy (xpath="(//a[text()='Try it Yourself Â»'])[1]")
	private WebElement tryIt;
	@FindBy (xpath="//a[text()='JS Navigator']")
	private WebElement navigator;
	public Home(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickTryit()
	{
		tryIt.click();
	}
	public void clicknavigator()
	{
		navigator.click();
	}
}
