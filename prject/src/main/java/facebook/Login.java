package facebook;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utility;

public class Login {
	@FindBy (xpath="//input[@id='email']")
	private WebElement userName;
	@FindBy (xpath="//input[@id='pass']")
	private WebElement password;

	@FindBy (xpath="//button[@name='login']")
	private WebElement loginButton;
	
	@FindBy (xpath="//a[text()='Messenger']")
	private WebElement messengerlink;
	@FindBy (xpath="//div[@aria-label='Facebook site links']//li")
	private List<WebElement> options;
	@FindBy (xpath="//a[text()='Bulletin']")
	private WebElement bulletin;
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendUsernameandPassword(String Name,String passWord)
	{
		userName.sendKeys(Name);
		password.sendKeys(passWord);
	}
		public boolean clickonLogin()
	{
		return loginButton.isEnabled();
	}
		public void messengeropen()
	{
		messengerlink.click();
	}
		public void openServices()
		{
			options.get(15).click();
		}
		public void openBulletin()
		{
			bulletin.click();
		}
}
