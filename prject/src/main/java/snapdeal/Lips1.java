package snapdeal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Lips1 {
	@FindBy (xpath="(//span[@class='catText'])[5]")
	private WebElement beauty;
	
	@FindBy (xpath="//span[text()='Lips']")
	private WebElement lips;

		public Lips1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void searchLips()
	{
		beauty.click();
	}
	public void lipsclick()
	{
		lips.click();
	}
}
