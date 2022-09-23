package amazon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class GetitToday {
	private WebDriver driver;
	@FindBy (xpath="//i[@class='a-icon a-icon-checkbox']")
	private WebElement getitToday;
	@FindBy (xpath="//a[@id='nav-link-accountList']")
	private WebElement accountAndLi;
	@FindBy (xpath="//span[text()='Create a Wish List']")
	private WebElement createWishLi;
	private Actions act;
	public GetitToday(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		act = new Actions(driver);
	}
	
	public void getItToday()
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(getitToday));
			getitToday.click();
	}
	public void acc()
	{
		act.moveToElement(accountAndLi).build().perform();
	}
	public void clickonWishList()
	{
		act.moveToElement(createWishLi).click().build().perform();
	}
}
