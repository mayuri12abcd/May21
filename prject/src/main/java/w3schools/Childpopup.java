package w3schools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
public class Childpopup {
	private WebDriver driver;

	@FindBy (xpath="//button[text()='Try it']")
	private WebElement tryIt;
	@FindBy (xpath="(//a[@title='Change Theme'])[1]")
	private WebElement changeTheme;

	@FindBy (xpath="//a[@id='getwebsitebtn']")
	private WebElement getYourWebsite;
	public Childpopup(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void tyitInFrame()
	{
		tryIt.click();
	}
	public void changeColorTheme()
	{
		changeTheme.click();
	}
	public void getyOURWebSite()
	{
	}
}
