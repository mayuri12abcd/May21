package meshho;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Color {
	private WebDriver driver;
	private JavascriptExecutor js;
	
	@FindBy (xpath="//div[@label='Price']//div")
	private WebElement pattern;
	@FindBy (xpath="//p[text()='Under â‚¹ 299']")
	private WebElement price299;
	@FindBy (xpath="//img[@alt='instagram']")
	private WebElement insta;
	public Color(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		 js =(JavascriptExecutor)driver;

	}
	
	public void scrollUptoBlue()
	{
		js.executeScript("window.scrollBy(0,3100)");
	}
	public void selectPattern()
	{
		Actions act = new Actions(driver);
		act.moveToElement(pattern).click().build().perform();
	}
	public void openInstagram()
	{
		insta.click();
	}
}
