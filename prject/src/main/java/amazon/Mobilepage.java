package amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mobilepage {
	private WebDriver driver;
	@FindBy (xpath="(//i[@class='a-icon a-icon-checkbox'])[5]")
	private WebElement vivo1;
	@FindBy (xpath="(//i[@class='a-icon a-icon-checkbox'])[4]")
	private WebElement oppo1;
		private WebDriverWait wait;
	
	public Mobilepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}
	
	public void vivo()
	{
		wait.until(ExpectedConditions.visibilityOf(vivo1));
		vivo1.click();
	}
	public void oppo()
	{
		wait.until(ExpectedConditions.visibilityOf(oppo1));
		oppo1.click();
	}

}
