package facebook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class RoomsPage {
	@FindBy (xpath=" //a[text()=' Return to messenger.com '] ")
	private WebElement returnToMess;
	
	@FindBy (xpath=" //a[text()=' Visit our help center '] ")
	private WebElement visitOurHelpCentre;

	public RoomsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void goBacktomessger()
	{
		returnToMess.click();
	}
	public void visitOurHelpCentre()
	{
		visitOurHelpCentre.click();
	}
}
