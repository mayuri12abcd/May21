package facebook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class MessengerPage {
	@FindBy (xpath="//a[text()='Rooms']")
	private WebElement rooms;
	
	@FindBy (xpath="//a[text()='Features']")
	private WebElement features;

	public MessengerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void openRomms()
	{
		rooms.click();
	}
	public void openFeatures()
	{
		features.click();
	}
	
	
}
