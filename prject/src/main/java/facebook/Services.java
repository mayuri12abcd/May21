package facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Services {
	@FindBy (xpath="//input[@id='email']")
	private WebElement email;
	@FindBy (xpath="//input[@id='pass']")
	private WebElement password;

	public Services(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void giveEmail()
	{
		email.sendKeys("abc@gmail.com");
	}
	public void givePassword()
	{
		password.sendKeys("1199");
	}
}
