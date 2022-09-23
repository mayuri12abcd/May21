package angelone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	@FindBy (xpath="//span[text()='×']")
	private WebElement closePopup;
		
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void closePopUp()
	{
		closePopup.click();
	}
}
