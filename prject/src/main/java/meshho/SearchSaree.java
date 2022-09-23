package meshho;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SearchSaree {
	@FindBy (xpath="(//input[@type='text'])[1]")
	private WebElement search;
	@FindBy (xpath="//span[text()='Careers']")
	private WebElement carriers;
	

	public SearchSaree(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void searchForSaree()
	{
		search.sendKeys("Saree");
		search.clear();
		search.sendKeys("Colorful Saree");
		search.sendKeys(Keys.ENTER);
	}
	public void gotoCarriers()
	{
		carriers.click();
	}
}
