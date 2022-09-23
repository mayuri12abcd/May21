package meshho;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Carrier {
	@FindBy (xpath="//a[text()='Home']")
	private WebElement home;
	@FindBy (xpath="//a[text()='News']")
	private WebElement news;
	@FindBy (xpath="//a[text()='Life at Meesho']")
	private WebElement lifeAtmeesho;
	public Carrier(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickhome()
	{
		home.click();
	}
	public void clicknews()
	{
		news.click();
	}
	public void clickLifeAtMessho()
	{
		lifeAtmeesho.click();
	}
}
