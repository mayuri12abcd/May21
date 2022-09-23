package snapdeal;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Lips1_5 {
	@FindBy (xpath="//span[@id='trendingSearches']//a[3]")
	private WebElement kurti;
	@FindBy (xpath="//div[@class='accountInner']")
	private WebElement signIn;
	private WebDriver driver;
	private Actions act;
	public Lips1_5(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		this.driver=driver;

	}
	
	public void openLips()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(kurti));
		kurti.click();
	}
	public void signIn1()
	{
		act = new Actions(driver);
		act.moveToElement(signIn).perform();
	}
	public void yourAcc()
	{
		
	}
}
